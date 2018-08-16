package com.booisajerk.activitycount

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_history.*
import java.util.*


class WorkoutHistory : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        val adapter = WorkoutHistoryAdapter(generateList())
        recyclerview.setHasFixedSize(true)
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = adapter
    }

    private fun generateList(): List<WorkoutHistoryViewModel> {
        val viewModelList = ArrayList<WorkoutHistoryViewModel>()

        for (i in 0..19) {
            viewModelList.add(WorkoutHistoryViewModel(String.format(Locale.US, "This is item %d", i)))
        }

        return viewModelList
    }
}