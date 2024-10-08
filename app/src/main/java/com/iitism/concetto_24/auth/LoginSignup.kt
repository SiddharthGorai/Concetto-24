package com.iitism.concetto_24.auth

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.iitism.concetto_24.R
import com.iitism.concetto_24.ui.HomeFragment
import com.iitism.concetto_24.ui.MainActivity
import com.iitism.concetto_24.utils.SharedPrefsHelper

class LoginSignup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login_signup)

    }

}