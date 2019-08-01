package com.example.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_without_view_model.*

class WithoutViewModelActivity : AppCompatActivity(), View.OnClickListener {

    private var mScoreTeam1 = 0
    private var mScoreTeam2 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_without_view_model)
        setSupportActionBar(tootBar)
        supportActionBar?.setTitle(R.string.without_view_model)

        setValueToTvCount()

        listenToViews(
            btnPlus1PointsTeam1,
            btnPlus2PointsTeam1,
            btnPlus3PointsTeam1,
            btnPlus1PointsTeam2,
            btnPlus2PointsTeam2,
            btnPlus3PointsTeam2,
            btnReset
        )


    }

    private fun setValueToTvCount() {
        tvCountTeam1.text = mScoreTeam1.toString()
        tvCountTeam2.text = mScoreTeam2.toString()
    }

    private fun View.OnClickListener.listenToViews(vararg views: View) {
        views.forEach { it.setOnClickListener(this) }
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btnPlus1PointsTeam1 -> {
                mScoreTeam1++
                tvCountTeam1.text = mScoreTeam1.toString()
            }
            R.id.btnPlus2PointsTeam1 -> {
                mScoreTeam1 += 2
                tvCountTeam1.text = mScoreTeam1.toString()
            }
            R.id.btnPlus3PointsTeam1 -> {
                mScoreTeam1 += 3
                tvCountTeam1.text = mScoreTeam1.toString()
            }
            R.id.btnPlus1PointsTeam2 -> {
                mScoreTeam2++
                tvCountTeam2.text = mScoreTeam2.toString()
            }
            R.id.btnPlus2PointsTeam2 -> {
                mScoreTeam2 += 2
                tvCountTeam2.text = mScoreTeam2.toString()
            }
            R.id.btnPlus3PointsTeam2 -> {
                mScoreTeam2 += 3
                tvCountTeam2.text = mScoreTeam2.toString()
            }
            R.id.btnReset -> {
                mScoreTeam2 = 0
                mScoreTeam1 = 0
                setValueToTvCount()
            }
        }
    }
}
