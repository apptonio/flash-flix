package edu.rit.flashflix.utils

import android.widget.ImageView
import coil.load
import coil.transform.CircleCropTransformation
import edu.rit.flashflix.R

fun ImageView.loadUrl(url: String?, isCircleCrop: Boolean = false) {
    url?.let {
        this.load(it) {
            crossfade(true)
            placeholder(R.drawable.ic_baseline_photo_24)
            if(isCircleCrop) transformations(CircleCropTransformation())
        }
    }
}