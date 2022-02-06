package com.bd.satellitetracking.utils

import android.content.Context
import android.content.res.AssetManager
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

fun AssetManager.readAssetsFile(fileName: String): String =
    open(fileName).bufferedReader().use { it.readText() }

fun RecyclerView.addItemDecoration() {
    if (layoutManager !is LinearLayoutManager)
        return
    addItemDecoration(DividerItemDecorator(context))
}

fun EditText.hideKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}