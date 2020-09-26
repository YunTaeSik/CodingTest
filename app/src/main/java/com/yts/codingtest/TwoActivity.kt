package com.yts.codingtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class TwoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        Log.e(javaClass.simpleName, "onCreate")

    }


    override fun onRestart() {
        super.onRestart()
        Log.e(javaClass.simpleName, "onRestart")
    }

    override fun onStart() {
        super.onStart()
        Log.e(javaClass.simpleName, "onStart")
    }


    override fun onResume() {
        super.onResume()
        Log.e(javaClass.simpleName, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e(javaClass.simpleName, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e(javaClass.simpleName, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(javaClass.simpleName, "onDestroy")
    }
}