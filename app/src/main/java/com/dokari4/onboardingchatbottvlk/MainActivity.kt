package com.dokari4.onboardingchatbottvlk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.dokari4.onboardingchatbottvlk.databinding.ActivityMainBinding
import kotlinx.coroutines.launch
import java.util.*
import kotlin.concurrent.schedule

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var checker: Checker
    private var isDone = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        checker = Checker(applicationContext)

        binding.finishBtn.setOnClickListener {
            setDone()
            moveActivity()
        }
        // Action Bar Hide
        supportActionBar?.hide()
    }

    private fun setDone() {
        lifecycleScope.launch {
            when(isDone) {
                false -> checker.setDone(PassChecker.DONE)
            }
        }
    }
    private fun moveActivity() {
        val intent = Intent(this, TestActivity::class.java)
        Timer("SettingUp", false).schedule(1000) {
            startActivity(intent)
        }
    }
}