package com.abhishek.tracker.ext

import androidx.databinding.BindingAdapter
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import android.view.View

import android.widget.TextView


@BindingAdapter("isVisible")
fun setIsVisible(view: View, isVisible: Boolean) {
    if (isVisible) {
        view.visibility = View.VISIBLE
    } else {
        view.visibility = View.GONE
    }
}

@BindingAdapter("app:errorAssets")
fun onErrorText(view: TextView, assets: Pair<Int, Int>?) {
    if(assets != null) {
        view.text = view.context.getText(assets.first)
        view.setCompoundDrawablesWithIntrinsicBounds(0,
                assets.second, 0, 0)
    }
}

