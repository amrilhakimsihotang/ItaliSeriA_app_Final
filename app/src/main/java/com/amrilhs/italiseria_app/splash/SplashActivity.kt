package com.amrilhs.italiseria_app.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.amrilhs.italiseria_app.MainActivity
import com.amrilhs.italiseria_app.databinding.ActivitySplashBinding

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private lateinit var splashBinding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashBinding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(splashBinding.root)
        val background = object : Thread() {
            override fun run() {
                try {
                    sleep(SLEEP_TIME)
                    val mIntent = Intent(baseContext, MainActivity::class.java)
                    startActivity(mIntent)
                    this@SplashActivity.finish()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
        background.start()
    }

    companion object {
        const val SLEEP_TIME: Long = 5000
    }
}
