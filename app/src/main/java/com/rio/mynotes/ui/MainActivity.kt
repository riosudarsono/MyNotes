package com.rio.mynotes.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.rio.mynotes.R
import com.rio.mynotes.ui.create.CreateNoteActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getData()
        setOnclick()
    }

    private fun setOnclick(){
        fab_create.setOnClickListener { startActivity(Intent(this, CreateNoteActivity::class.java)) }
    }

    private fun getData(){
        viewModel.getData("1").observe(this, Observer {

        })
    }

}