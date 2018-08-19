package com.booisajerk.activitycount

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_history.*
import java.util.*

class WorkoutHistory : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        val adapter = WorkoutHistoryAdapter(generateSampleList())
        recyclerview.setHasFixedSize(true)
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = adapter

        val dividerItemDecoration = DividerItemDecoration(recyclerview.getContext(),
                resources.configuration.orientation)
        recyclerview.addItemDecoration(dividerItemDecoration)
    }

    private fun generateSampleList(): List<WorkoutHistoryViewModel> {
        val viewModelList = ArrayList<WorkoutHistoryViewModel>()

        for (i in 9 downTo 1) {
            viewModelList.add(WorkoutHistoryViewModel(
                    String.format(Locale.US, "%d Aug 2018", i)
                    , String.format(Locale.US, "Push Ups: %d", i * i)
                    , String.format(Locale.US, "Squats: %d ", i + i)
                    , String.format(Locale.US, "Dips: %d ", i * i + i)))
        }

        return viewModelList
    }
}