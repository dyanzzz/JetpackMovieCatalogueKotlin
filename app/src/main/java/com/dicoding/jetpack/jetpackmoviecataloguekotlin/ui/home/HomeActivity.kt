package com.dicoding.jetpack.jetpackmoviecataloguekotlin.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.jetpack.jetpackmoviecataloguekotlin.R
import com.dicoding.jetpack.jetpackmoviecataloguekotlin.adapter.SectionsPagerAdapter
import com.dicoding.jetpack.jetpackmoviecataloguekotlin.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val activityHomeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(activityHomeBinding.root)

        val sectionPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        activityHomeBinding.viewPager.adapter = sectionPagerAdapter
        activityHomeBinding.tabs.setupWithViewPager(activityHomeBinding.viewPager)

        supportActionBar?.elevation = 0f
    }
}