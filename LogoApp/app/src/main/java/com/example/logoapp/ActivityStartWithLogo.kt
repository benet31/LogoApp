package com.example.logoapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import java.util.*

class ActivityStartWithLogo : AppCompatActivity() {

    private val SPLASH_SCREEN_TIMEOUT = 3000L

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_with_logo)
        val logoApsideView: ImageView = this.findViewById(R.id.logoApside) as ImageView
        /*val animation = RotateAnimation(
            0.0f,
            360f,
            android.R.attr.pivotX.toFloat(),
            android.R.attr.pivotY.toFloat()
        )*/


        val animationRotate = AnimationUtils.loadAnimation(this, R.anim.rotate)
        logoApsideView.startAnimation(animationRotate)
        //Redirection page principale
        Handler().postDelayed({
            /*logoApsideView.rotation = 0.0f
            while (logoApsideView.rotation<=360.0f) {
                logoApsideView.rotation+=90.0f
            }*/

            val intent = Intent(applicationContext, MainActivity::class.java)
            this.startActivity(intent)
            this.finish()
            logoApsideView.startAnimation(animationRotate)
        }, SPLASH_SCREEN_TIMEOUT)
    }


}