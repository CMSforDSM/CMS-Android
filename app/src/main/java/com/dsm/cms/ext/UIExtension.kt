package com.dsm.cms.ext

import android.app.Activity
import android.content.Intent
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

inline fun <reified T : Activity> AppCompatActivity.setupNavigateEvent(navigateEvent: LiveData<Unit>) {
    navigateEvent.observe(this, Observer {
        startActivity(Intent(this, T::class.java))
    })
}

fun AppCompatActivity.setupToastEvent(
    toastEvent: LiveData<Int>,
    timeLength: Int = Toast.LENGTH_SHORT
) {
    toastEvent.observe(this, Observer { stringResId ->
        Toast.makeText(this, stringResId, timeLength).show()
    })
}

fun Fragment.setupToastEvent(
    toastEvent: LiveData<Int>,
    timeLength: Int = Toast.LENGTH_SHORT
) {
    toastEvent.observe(viewLifecycleOwner, Observer { stringResId ->
        Toast.makeText(activity, stringResId, timeLength).show()
    })
}

fun AppCompatActivity.hideKeyboard() {
    (this.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager)
        .hideSoftInputFromWindow(window.attributes.token, 0)
}

fun Fragment.hideKeyboard() {
    (activity?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager)
        .hideSoftInputFromWindow(view?.windowToken, 0)
}