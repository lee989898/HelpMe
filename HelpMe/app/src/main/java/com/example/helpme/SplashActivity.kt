package com.example.helpme

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.helpme.databinding.ActivitySplashBinding
import kotlinx.coroutines.delay

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val splashBinding: ActivitySplashBinding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(splashBinding.root)

        val splashAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_splash)
        val splashAnimation2 = AnimationUtils.loadAnimation(this, R.anim.anim_splash2)
        val splashAnimation3 = AnimationUtils.loadAnimation(this, R.anim.anim_splash3)
        val splashAnimation4 = AnimationUtils.loadAnimation(this, R.anim.anim_splash4)
        splashBinding.logoH.animation = splashAnimation3
        splashBinding.logoF.animation = splashAnimation2
        splashBinding.logoM.animation = splashAnimation

        splashAnimation3.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
                    splashBinding.logoText.animation = splashAnimation4
            }

            override fun onAnimationEnd(animation: Animation?) {
//                splashBinding.logoText.visibility = View.VISIBLE

                Handler(Looper.getMainLooper()).postDelayed({
                    startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                    overridePendingTransition(R.anim.slide_up_enter, R.anim.slide_up_exit)
                    finish()
                }, 1000)
            }

            override fun onAnimationRepeat(animation: Animation?) {
                //
            }

        })
    }
}