package com.bd.satellitetracking.utils

import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter


@BindingAdapter("app:tint")
fun setTintColor(imageView: ImageView, colorId: Int) {
    imageView.setColorFilter(
        ContextCompat.getColor(imageView.context, colorId),
        android.graphics.PorterDuff.Mode.SRC_IN
    )
}