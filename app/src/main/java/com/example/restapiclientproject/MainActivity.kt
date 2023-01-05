package com.example.restapiclientproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.restapiclientproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showFragment()
    }

    private fun showFragment() {
        val mFragmentManager = supportFragmentManager
        val mfragmentTransaction = mFragmentManager.beginTransaction()
        val mFragment = fragment_dataa()

        mfragmentTransaction.add(R.id.fl_data,mFragment).commit()
    }
}