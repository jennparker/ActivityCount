package com.booisajerk.activitycount;

import android.os.Bundle;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class WorkoutHistory extends AppCompatActivity {
    private ActivityRecordViewModel mActivityRecordViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final ActivityRecordAdapter adapter = new ActivityRecordAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mActivityRecordViewModel = ViewModelProviders.of(this).get(ActivityRecordViewModel.class);

        mActivityRecordViewModel.getAllActivityRecords().observe(this, new Observer<List<ActivityRecord>>() {
            @Override
            public void onChanged(@Nullable final List<ActivityRecord> records) {
                adapter.setActivityRecord(records);
            }
        });
    }
}
