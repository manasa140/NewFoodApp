package com.example.food_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.TextView


class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_splash)
        val img=findViewById<TextView>(R.id.Image)
        val eater=findViewById<TextView>(R.id.Eater)
        val desc=findViewById<TextView>(R.id.desc)
        val animation=AnimationUtils.loadAnimation(this,R.anim.slide)
        val animation2=AnimationUtils.loadAnimation(this,R.anim.slidedown)
        img.startAnimation(animation)
        eater.startAnimation(animation)
        desc.startAnimation(animation2)
        Handler().postDelayed({
            val intent = Intent(this,Fooditems::class.java)
            startActivity(intent)
        },5000)
    }
}