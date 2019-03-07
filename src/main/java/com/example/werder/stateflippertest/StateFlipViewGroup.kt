package com.example.werder.stateflippertest

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ViewAnimator

class StateFlipViewGroup
@JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null
) : ViewAnimator(context, attrs) {

    private var content: Int = -1
    private var progress: Int = -1
    private var empty: Int = -1
    private var error: Int = -1

    override fun onViewAdded(child: View) {
        super.onViewAdded(child)

        if (child.id > 0) {
            invalidateIds()
        }
    }

    override fun onViewRemoved(child: View) {
        super.onViewRemoved(child)

        if (child.id > 0) {
            invalidateIds()
        }
    }

    fun showContent() {
        showState(content)
    }

    fun showProgress() {
        showState(progress)
    }

    fun showEmpty() {
        showState(empty)
    }

    fun showError() {
        showState(error)
    }

    private fun invalidateIds() {
        for (i in 0 until childCount) {
            when (getChildAt(i).id) {
                R.id.content_container -> content = i
                R.id.progress_container -> progress = i
                R.id.empty_container -> empty = i
                R.id.error_container -> error = i
            }
        }
    }

    private fun showState(index: Int) {
        if (index >= 0 && displayedChild != index) {
            displayedChild = index
        }
    }
}

