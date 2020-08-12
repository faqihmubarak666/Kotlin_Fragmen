package com.example.day8_fragment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_counter_show.*

//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//    }
//
//    fun sendData(passData: String) {
//        counterTextView.text = passData
//    }
//
//}

class MainActivity : AppCompatActivity(), CounterHandler {
    lateinit var counterFragment: CounterFragment // lateinit var nya bisa di assignnya nanti
    lateinit var counterShowFragment: CounterShowFragment
    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        counterFragment = fragment1 as CounterFragment // as / casting
        counterShowFragment = fragment2 as CounterShowFragment
        println("MAIN_ACTIVITY this = $this")
    }

    override fun notifyCounterIncrease(){
        counter += 1
        counterShowFragment.notifyCounterChange(counter)
        println(counter)
    }

    override  fun notifyCounterDecrease(){
        counter -= 1
        counterShowFragment.notifyCounterChange(counter)
        println(counter)
    }

    fun toSecondActivity(view: View){
        startActivity(Intent(this, SecondActivity::class.java))
    }

}