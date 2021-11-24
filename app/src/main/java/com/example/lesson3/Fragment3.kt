package com.example.lesson3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lesson3.databinding.Fragment2Binding
import com.example.lesson3.databinding.Fragment3Binding


class Fragment3 : Fragment(), IFragment {

    lateinit var binding: Fragment3Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment3Binding.inflate(inflater)
        nextBtnClick()
        prevBtnClick()

        setOnClickListeners()
        return binding.root
    }

    fun setOnClickListeners(){
        binding.minus.setOnClickListener{
            setOperation(binding.minus.text.toString())
        }
        binding.plus.setOnClickListener{
            setOperation(binding.plus.text.toString())
        }
        binding.multipy.setOnClickListener{
            setOperation(binding.multipy.text.toString())
        }
        binding.divide.setOnClickListener{
            setOperation(binding.divide.text.toString())
        }
    }

    fun setOperation(operation: String){
        Calculator.operation = operation
    }

    override fun nextBtnClick(){
        binding.next.setOnClickListener{
            val activityCallback = requireActivity() as ActivityCallback
            activityCallback.showNextFragment(this)
        }
    }

    override fun prevBtnClick() {
        binding.prev.setOnClickListener{
            val activityCallback = requireActivity() as ActivityCallback
            activityCallback.showPreviousFragment(this)
        }
    }

    companion object {
        fun newInstance() = Fragment3()
    }
}