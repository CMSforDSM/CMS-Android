package com.dsm.cms.ext

import java.text.SimpleDateFormat
import java.util.*

fun setDateAsOfToday(date: String): String {
    val myDate = Calendar.getInstance()
    val dateArray = date.split("T")
    val todayDate = SimpleDateFormat("yyyy-MM-dd", Locale.US).format(myDate.time)

    return if (dateArray[0] != todayDate) {
        dateArray[0]
    } else {
        val str: String = dateArray[1].split(".")[0]
        str.substring(0, str.length - 3)
    }
}