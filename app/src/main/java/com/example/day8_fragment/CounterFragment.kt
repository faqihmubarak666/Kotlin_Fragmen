package com.example.day8_fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_counter.*


/**
 * A simple [Fragment] subclass.
 * Use the [CounterFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CounterFragment : Fragment(), View.OnClickListener {
    var result: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_counter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonIncrement.setOnClickListener(this)
        buttonDecrement.setOnClickListener(this)
    }


    override fun onClick(v: View?) {
        val activity = activity as MainActivity
        when (v) {
            buttonIncrement -> {
                this.result += 1
                activity.sendData(this.result.toString())
            }
            buttonDecrement -> {
                this.result -= 1
                activity.sendData(this.result.toString())
            }
        }
    }
}

