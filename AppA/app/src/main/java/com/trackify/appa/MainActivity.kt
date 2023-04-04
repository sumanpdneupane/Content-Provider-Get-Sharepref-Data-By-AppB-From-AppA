package com.trackify.appa

import android.annotation.SuppressLint
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.trackify.appa.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var map: MutableMap<String, Any> = mutableMapOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getFromContentProvider()
        if (map.isNotEmpty()) {
            binding.displaySharedValue.setText("${map.toMap()}")
        }

    }

    @SuppressLint("Range")
    fun getFromContentProvider() {
        val uri: Uri = Uri.parse("content://com.trackify.appb.provider")
        val projection = arrayOf("key", "value")
        val cursor: Cursor? = contentResolver.query(uri, projection, null, null, null)
        if (cursor != null && cursor.moveToFirst()) {
            do {
                val key: String = cursor.getString(cursor.getColumnIndex("key"))
                val value: String = cursor.getString(cursor.getColumnIndex("value"))
                // Use the retrieved key and value as needed
                map.put(key, value)
            } while (cursor.moveToNext())
        }
    }
}