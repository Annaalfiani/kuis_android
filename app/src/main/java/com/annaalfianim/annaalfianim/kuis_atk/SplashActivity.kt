package com.annaalfianim.annaalfianim.kuis_atk

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        supportActionBar?.hide()
        Handler().postDelayed(Runnable { startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            finish()}, 2000)
    }
}
