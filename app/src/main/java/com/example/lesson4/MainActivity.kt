package com.example.lesson4

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lesson4.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: PersonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = PersonAdapter(::showSnackbar, ::showSnackbarLike)

        val layoutManager =  LinearLayoutManager(this)
        binding.recycleview.layoutManager = layoutManager
        binding.recycleview.adapter = adapter

        PersonHolder.addListener(personsListener)
    }

    override fun onDestroy(){
        super.onDestroy()
        PersonHolder.removeListener(personsListener)
    }

    private val personsListener: PersonsListener = {
        adapter.persons = it
    }

    private fun showSnackbar(name: String): Unit{
        Snackbar.make(binding.root, "Нажата карточка: $name", 500).show()
    }

    private fun showSnackbarLike(name: String): Unit{
        Snackbar.make(binding.root, "Нажат лайк: $name", 500).show()
    }
}