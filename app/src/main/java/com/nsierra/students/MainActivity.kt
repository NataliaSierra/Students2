package com.nsierra.students

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.widget.ImageView
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {
        val duration: Long = 3000;
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            supportActionBar?.hide()
            this.window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
            val logoSplash = findViewById<ImageView>(R.id.imgsplash)
            Glide.with(this).load(R.drawable.logosplash).into(logoSplash)

            changeActivity()
        }
    private fun changeActivity() {
        Handler().postDelayed(Runnable {
            val intent = Intent(this, ActivitySplash::class.java)
            startActivity(intent)
        }, duration)
    }
}