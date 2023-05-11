package id.ac.ubaya.informatika.satujiwa_nald.util

import android.widget.ImageView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception

fun ImageView.loadImage(url:String?){
    Picasso.get().load(url).resize(300,150).centerCrop()
        .into(this,object :Callback{
            override fun onSuccess() {

            }

            override fun onError(e: Exception?) {

            }
        })
}