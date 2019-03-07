package com.example.werder.stateflippertest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.button_for_changing_state
import kotlinx.android.synthetic.main.activity_main.container_content
import kotlinx.android.synthetic.main.activity_main.container_empty
import kotlinx.android.synthetic.main.activity_main.container_error
import kotlinx.android.synthetic.main.activity_main.container_progress

class MainActivity : AppCompatActivity() {

    private var i = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_for_changing_state.setOnClickListener { generateNextState(it) }
    }

    private fun generateNextState(v: View) {
        showProgress()
        v.postDelayed({
            when(i++ % 3) {
                0 -> showContent()
                1 -> showEmpty()
                2 -> showError()
            }
        }, 1000)
    }

    private fun showProgress() {
        container_progress.visibility = View.VISIBLE
        container_content.visibility = View.GONE
        container_empty.visibility = View.GONE
        container_error.visibility = View.GONE
    }

    private fun showContent() {
        container_progress.visibility = View.GONE
        container_content.visibility = View.VISIBLE
        container_empty.visibility = View.GONE
        container_error.visibility = View.GONE
    }

    private fun showEmpty() {
        container_progress.visibility = View.GONE
        container_content.visibility = View.GONE
        container_empty.visibility = View.VISIBLE
        container_error.visibility = View.GONE
    }

    private fun showError() {
        container_progress.visibility = View.GONE
        container_content.visibility = View.GONE
        container_empty.visibility = View.GONE
        container_error.visibility = View.VISIBLE
    }
}