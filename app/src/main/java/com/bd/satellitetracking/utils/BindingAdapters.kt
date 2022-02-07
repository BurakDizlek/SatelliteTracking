package com.bd.satellitetracking.utils

import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import java.text.SimpleDateFormat
import java.util.*


@BindingAdapter("app:tint")
fun setTintColor(imageView: ImageView, colorId: Int?) {
    colorId?.let {
        imageView.setColorFilter(
            ContextCompat.getColor(imageView.context, it),
            android.graphics.PorterDuff.Mode.SRC_IN
        )
    }
}

@BindingAdapter("app:date")
fun setDate(textView: TextView, date: Date?) {
    date?.let {
        val sdf = SimpleDateFormat(DateFormatPatterns.display, Locale.getDefault())
        textView.text = sdf.format(it)
    }
}