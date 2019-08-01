package com.example.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.Lifecycle
import kotlinx.android.synthetic.main.activity_without_view_model.*

class WithViewModelActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var scoreViewModel: ScoreViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_without_view_model)
        setSupportActionBar(tootBar)
        supportActionBar?.setTitle(R.string.with_view_model)

        scoreViewModel =
            ViewModelProviders.of(this).get(ScoreViewModel::class.java)
       // scoreViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application).create(ScoreViewModel::class.java)

        //todo subscribe score team1
        scoreViewModel.getScoreLiveData1().observe(this@WithViewModelActivity,object : Observer<Int>{
            override fun onChanged(t: Int?) {
                Log.d("TAG:WithViewModelAtv","onChanged:team1 = $t")
                tvCountTeam1.text = t.toString()
            }
        })
        //todo subscribe score team2
        scoreViewModel.getScoreLiveData2().observe(this@WithViewModelActivity,object : Observer<Int>{
            override fun onChanged(t: Int?) {
                Log.d("TAG:WithViewModelAtv","onChanged:team2 = $t")
                tvCountTeam2.text = t.toString()
            }
        })
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

    override fun onDestroy() {
        scoreViewModel.getScoreLiveData1().removeObserver {  }
        scoreViewModel.getScoreLiveData2().removeObserver {  }
        super.onDestroy()
    }

    private fun View.OnClickListener.listenToViews(vararg views: View) {
        views.forEach { it.setOnClickListener(this) }
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btnPlus1PointsTeam1 -> {
                scoreViewModel.increaseScoreTeam1(1)
            }
            R.id.btnPlus2PointsTeam1 -> {
                scoreViewModel.increaseScoreTeam1(2)
            }
            R.id.btnPlus3PointsTeam1 -> {
                scoreViewModel.increaseScoreTeam1(3)
            }
            R.id.btnPlus1PointsTeam2 -> {
                scoreViewModel.increaseScoreTeam2(1)
            }
            R.id.btnPlus2PointsTeam2 -> {
                scoreViewModel.increaseScoreTeam2(2)
            }
            R.id.btnPlus3PointsTeam2 -> {
                scoreViewModel.increaseScoreTeam2(3)
            }
            R.id.btnReset -> {
                scoreViewModel.resetScore()
            }
        }
    }
}
