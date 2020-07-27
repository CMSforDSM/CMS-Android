package com.dsm.cms.ext

import java.text.SimpleDateFormat
import java.util.*

fun setDateAsOfToday(date: String?): String {
    date?.let {
        val myDate = Calendar.getInstance()
        val dateArray = it.split("T")
        val todayDate = SimpleDateFormat("yyyy-MM-dd", Locale.US).format(myDate.time)

        return if (dateArray[0] != todayDate) {
            dateArray[0]
        } else {
            dateArray[1].split(".")[0]
        }
    }
    return ""
}

fun setDateManually(date: String?): String {
    date?.let { return it.replace("T", " ") }
    return ""
}