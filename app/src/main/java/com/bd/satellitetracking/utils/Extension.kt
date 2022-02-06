package com.bd.satellitetracking.utils

import android.content.res.AssetManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

fun AssetManager.readAssetsFile(fileName: String): String =
    open(fileName).bufferedReader().use { it.readText() }

fun RecyclerView.addItemDecoration() {
    if (layoutManager !is LinearLayoutManager)
        return
    addItemDecoration(DividerItemDecorator(context))
}