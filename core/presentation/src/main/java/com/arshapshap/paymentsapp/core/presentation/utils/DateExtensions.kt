package com.arshapshap.paymentsapp.core.presentation.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun Date.format(): String {
    val dateFormat = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())
    return dateFormat.format(this)
}