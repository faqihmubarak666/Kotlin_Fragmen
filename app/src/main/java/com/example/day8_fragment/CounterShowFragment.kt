package com.example.day8_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_counter_show.*

/**
 * A simple [Fragment] subclass.
 * Use the [CounterShowFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CounterShowFragment() : Fragment() {

    var counter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        println("Counter_Show_Fragment this = $activity")

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_counter_show, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        notifyCounterChange(counter)
    }

    fun notifyCounterChange(counter: Int){
        counterTextView.text = counter.toString()
    }

}