package lazycoder21.droid.myapplication.util

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImage(imageUrl: String) {
    Glide
        .with(this.context)
        .load(imageUrl)
        .centerCrop()
        .into(this);
}