package com.dokari4.onboardingchatbottvlk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.asLiveData
import com.dokari4.onboardingchatbottvlk.databinding.ActivityTestBinding

class TestActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTestBinding
    private lateinit var checker: Checker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestBinding.inflate(layoutInflater)
        setContentView(binding.root)
        checker = Checker(applicationContext)

        observeOnboard()
    }

    private fun observeOnboard() {
        checker.isDoneFlow.asLiveData().observe(this) {
                passChecker ->
            passChecker?.let {
                when(passChecker) {
                    PassChecker.UNDONE -> moveOnboarding()
                }
            }
        }
    }

    private fun moveOnboarding() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}