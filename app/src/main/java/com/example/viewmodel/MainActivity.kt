package com.example.viewmodel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(tootBar)
        supportActionBar?.setTitle(R.string.app_name)
        btnWithoutViewModel.setOnClickListener { intent2Activity(this, WithoutViewModelActivity::class.java, false) }
        btnWithViewModel.setOnClickListener { intent2Activity(this, WithViewModelActivity::class.java, false) }

    }

    private fun intent2Activity(
        activity: AppCompatActivity, toClass: Class<*>, isFinish: Boolean
    ) {
        val intent = Intent(activity, toClass)
        intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
        activity.startActivity(intent)

        if (isFinish) {
            activity.finish()
        }
    }

}
