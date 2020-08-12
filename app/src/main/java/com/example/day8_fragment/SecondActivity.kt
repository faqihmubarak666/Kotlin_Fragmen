package com.example.day8_fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() , View.OnClickListener, CounterHandler{

    lateinit var counterFragment: CounterFragment
    lateinit var counterShowFragment: CounterShowFragment

    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        toCounterFragmentButton.setOnClickListener(this)
        toCounterShowFragmentButton.setOnClickListener(this)
        counterFragment = CounterFragment()
        counterShowFragment = CounterShowFragment()

        supportFragmentManager.beginTransaction().add(R.id.fragmentContainer, counterFragment).commit()

    }

    override fun notifyCounterIncrease() {
        counter+=1
    }

    override fun notifyCounterDecrease() {
        counter-=1
    }

    override fun onClick(v: View?) {
        when(v){
            toCounterFragmentButton -> {switchFragment(counterFragment)}
            toCounterShowFragmentButton -> {
                counterShowFragment.counter = counter
                switchFragment(counterShowFragment)
            }
        }
    }

    fun switchFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit()
    }
}
