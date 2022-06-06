package com.dokari4.onboardingchatbottvlk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*
import kotlin.concurrent.schedule

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        supportActionBar?.hide()
        val intent = Intent(this, TestActivity::class.java)
        Timer("SettingUp", false).schedule(2000) {
            startActivity(intent)
            finish()
        }


    }
}