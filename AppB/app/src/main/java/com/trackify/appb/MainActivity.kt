package com.trackify.appb

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE)
        val editor = prefs.edit()
        editor.putString("key1", "value1")
        editor.putString("key2", "value2")
        editor.putString("Suman", "Neupane")
        editor.apply()
    }
}