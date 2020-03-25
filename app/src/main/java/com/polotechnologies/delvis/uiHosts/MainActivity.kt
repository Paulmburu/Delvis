package com.polotechnologies.delvis.uiHosts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.polotechnologies.delvis.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppTheme)
        setContentView(R.layout.activity_main)
    }
}
