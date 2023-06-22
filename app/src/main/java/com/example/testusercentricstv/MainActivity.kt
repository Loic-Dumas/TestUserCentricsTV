package com.example.testusercentricstv

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.usercentrics.sdk.Usercentrics
import com.usercentrics.sdk.UsercentricsBanner
import com.usercentrics.sdk.UsercentricsOptions

/**
 * Activity which init user centrics and display banners.
 * The settings ID relates to a simple category, with various services regrouped in multiple categories (essential and non essential)
 * Two buttons can display first and second banner.
 *
 * Issue : navigation in banner on TV, is really difficult.
 * 1. Focused is not showed properly
 * 2. Impossible to unselect a category
 */
class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initUI()

        initUserCentrics()
    }

    private fun initUI() {
        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)

        button1.setOnClickListener { displayFirstLayer() }
        button2.setOnClickListener { displaySecondLayer() }
    }

    private fun initUserCentrics() {

        val options = UsercentricsOptions(settingsId = "sdx6T74U0BL_sn")

        Log.d("TestUserCentrics", "Start Init User Centrics")
        Usercentrics.initialize(this, options)

        Usercentrics.isReady({ status ->
            if (status.shouldCollectConsent) {
                displayFirstLayer()
            } else {
                applyConsent()
            }
        }, { error ->
            Log.d("TestUserCentrics", "Error in isReady $error")
        })
    }

    private fun displayFirstLayer() {
        val banner = UsercentricsBanner(this)
        banner.showFirstLayer { userResponse ->
            applyConsent()
        }
    }

    private fun displaySecondLayer() {
        val banner = UsercentricsBanner(this)
        banner.showSecondLayer { userResponse ->
            applyConsent()
        }
    }

    private fun applyConsent() {
        Log.d("TestUserCentrics", "Apply consent")
    }
}