package com.arshapshap.paymentsapp.core.presentation.utils

import android.content.Context
import android.widget.Toast

fun Context.showToast(message: CharSequence) =
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

fun Context.showLongToast(message: CharSequence) =
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()