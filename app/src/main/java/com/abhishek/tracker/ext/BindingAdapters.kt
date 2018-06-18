package com.abhishek.tracker.ext

import android.databinding.BindingAdapter
import android.support.annotation.DrawableRes
import android.support.v4.content.ContextCompat
import android.view.View

import android.widget.TextView



@BindingAdapter("backgroundDrawable")
fun setBackgroundDrawable(view: View, @DrawableRes resId: Int) {
    view.background = ContextCompat.getDrawable(view.context, resId)
}


@BindingAdapter("isVisible")
fun setIsVisible(view: View, isVisible: Boolean) {
    if (isVisible) {
        view.visibility = View.VISIBLE
    } else {
        view.visibility = View.GONE
    }
}

@BindingAdapter("app:errorAssets")
fun onErrorText(view: TextView, assets: Pair<Int, Int>) {
    view.text = view.context.getText(assets.first)
    view.setCompoundDrawablesWithIntrinsicBounds(0,
            assets.second, 0, 0)
}

