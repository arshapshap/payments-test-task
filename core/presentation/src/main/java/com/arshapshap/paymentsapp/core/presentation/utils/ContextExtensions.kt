package com.arshapshap.paymentsapp.core.presentation.utils

import android.content.Context
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

fun Context.showToast(message: CharSequence) =
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

fun Context.showAlert(
    title: String,
    message: String? = null,
    positiveButtonText: String,
    onPositiveButtonClick: () -> Unit = { },
) {
    var builder = AlertDialog.Builder(this)
        .setTitle(title)
        .setPositiveButton(positiveButtonText) { _, _ ->
            onPositiveButtonClick.invoke()
        }
    if (message != null)
        builder = builder.setMessage(message)
    builder.show()
}

fun Context.showAlertWithTwoButtons(
    title: String,
    message: String? = null,
    positiveButtonText: String,
    negativeButtonText: String,
    onPositiveButtonClick: () -> Unit = { },
    onNegativeButtonClick: () -> Unit = { }
) {
    var builder = AlertDialog.Builder(this)
        .setTitle(title)
        .setPositiveButton(positiveButtonText) { _, _ ->
            onPositiveButtonClick.invoke()
        }.setNegativeButton(negativeButtonText) { _, _ ->
            onNegativeButtonClick.invoke()
        }
    if (message != null)
        builder = builder.setMessage(message)
    builder.show()
}