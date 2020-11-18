package com.example.recyclerviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.recyclerviewapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Menambahkan Objek Data Binding
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(
                this,
                R.layout.activity_main
        )
    }
}