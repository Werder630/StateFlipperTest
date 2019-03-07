package com.example.werder.stateflippertest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main_with_state_flipper.button_for_changing_state
import kotlinx.android.synthetic.main.activity_main_with_state_flipper.state_flipper

class MainActivityWithStateFlipper : AppCompatActivity() {

    private var i = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_with_state_flipper)

        button_for_changing_state.setOnClickListener { generateNextState(it) }
    }

    private fun generateNextState(v: View) {
        state_flipper.showProgress()
        v.postDelayed({
            when(i++ % 3) {
                0 -> state_flipper.showContent()
                1 -> state_flipper.showEmpty()
                2 -> state_flipper.showError()
            }
        }, 1000)
    }
}