package com.draw.master.tool.activities

import android.content.Intent
import android.os.Handler
import com.simplemobiletools.commons.activities.BaseSplashActivity
import com.draw.master.tool.R

class SplashActivity : BaseSplashActivity() {
    override fun initActivity() {
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({
            openMain()
        }, 2000)
    }

    fun openMain() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}
