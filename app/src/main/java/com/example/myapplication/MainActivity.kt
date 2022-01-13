package com.example.myapplication

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

interface ActivityCallback{
    fun getNewPerson(person: Person)
}

class MainActivity : AppCompatActivity(), ActivityCallback {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: PersonAdapter
    private var fragment: AsyncFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        var fm = supportFragmentManager
        var oldFragment = fm.findFragmentByTag(AsyncFragment.TAG)
        if (oldFragment == null){
            fragment = AsyncFragment()
            fm.beginTransaction().add(fragment!!, AsyncFragment.TAG).commit()
        }
        else{
            fragment = oldFragment as AsyncFragment
            adapter.getPreviousPersons(fragment!!.persons)
        }

        setContentView(binding.root)

        adapter = PersonAdapter(::showSnackbar, ::showSnackbarLike)

        val layoutManager =  LinearLayoutManager(this)
        binding.recycleview.layoutManager = layoutManager
        binding.recycleview.adapter = adapter

    }

    private fun showSnackbar(name: String): Unit{
        Snackbar.make(binding.root, "Нажата карточка: $name", 500).show()
    }

    private fun showSnackbarLike(name: String): Unit{
        Snackbar.make(binding.root, "Нажат лайк: $name", 500).show()
    }

    override fun getNewPerson(person: Person) {
        adapter.addNewPerson(person)
    }
}