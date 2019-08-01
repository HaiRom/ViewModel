package com.example.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel : ViewModel() {

    private val mScoreLiveData1 = MutableLiveData<Int>()
    private val mScoreLiveData2 = MutableLiveData<Int>()

    init {
        mScoreLiveData1.value = 0
        mScoreLiveData2.value = 0

    }

    override fun onCleared() {
        Log.d("TAG:ScoreViewModel", "onCleared")
        super.onCleared()
    }

    fun getScoreLiveData1(): LiveData<Int> {
        return mScoreLiveData1
    }

    fun getScoreLiveData2(): LiveData<Int> {
        return mScoreLiveData2
    }

    fun increaseScoreTeam1(score: Int) {
        mScoreLiveData1.value = mScoreLiveData1.value?.plus(score)
    }

    fun increaseScoreTeam2(score: Int) {
        mScoreLiveData2.value = mScoreLiveData2.value?.plus(score)
    }

    fun resetScore() {
        mScoreLiveData1.value = 0
        mScoreLiveData2.value = 0
    }
}