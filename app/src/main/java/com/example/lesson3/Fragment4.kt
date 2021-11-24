package com.example.lesson3

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lesson3.databinding.Fragment2Binding
import com.example.lesson3.databinding.Fragment4Binding

class Fragment4 : Fragment(), IFragment {

    lateinit var binding: Fragment4Binding

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = Fragment4Binding.inflate(inflater)
        prevBtnClick()

        printResult()

        return binding.root
    }

    fun printResult(){
        binding.result.text = Calculator.calculate()
    }

    override fun prevBtnClick() {
        binding.prev.setOnClickListener{
            val activityCallback = requireActivity() as ActivityCallback
            activityCallback.showPreviousFragment(this)
        }
    }

    override fun nextBtnClick() {

    }

    companion object{
        fun newInstance() = Fragment4()
    }
}