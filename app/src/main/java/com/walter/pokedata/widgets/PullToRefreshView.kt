package com.walter.pokedata.widgets

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.progressindicator.CircularProgressIndicator
import com.walter.pokedata.R

class PullToRefreshView @JvmOverloads constructor(private val ctx: Context, private val attributeSet: AttributeSet? = null, private val defStyleAttr: Int = 0) : MotionLayout(ctx, attributeSet, defStyleAttr) {
    var progress: CircularProgressIndicator
    var containerLayout: ConstraintLayout
    var motionLayout: MotionLayout
    private var currentTransition : Int

    init {
        val inflater = ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.pull_to_refresh_view, this)
        progress = findViewById(R.id.pull_to_refresh_progress)
        containerLayout = findViewById(R.id.pull_to_refresh_container)
        motionLayout = findViewById(R.id.pull_to_refresh_motion)
        motionLayout.setTransition(R.id.pull_down)
        currentTransition = R.id.pull_down
    }

    override fun addView(child: View, index: Int, params: ViewGroup.LayoutParams) {
        if(containerLayout == null) {
            super.addView(child, index, params)
        } else {
          containerLayout.addView(child, index, params)
        }
    }

    override fun onAnimationEnd() {
        super.onAnimationEnd()
        if(currentTransition == R.id.pull_down) {
            motionLayout.setTransition(R.id.load)
            motionLayout.transitionToStart()
        }
    }

}