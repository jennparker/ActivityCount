package com.booisajerk.activitycount;

import android.app.Application;

import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class ActivityRecordViewModel  extends AndroidViewModel {

    private ActivityRecordRepository mRepository;

    private LiveData<List<ActivityRecord>> mAllActivityRecords;

    public ActivityRecordViewModel (Application application) {
        super(application);
        mRepository = new ActivityRecordRepository(application);
        mAllActivityRecords = mRepository.getAllActivityRecords();
    }

    LiveData<List<ActivityRecord>> getAllActivityRecords() {
        return mAllActivityRecords;
    }

    public void insert(ActivityRecord activityRecord) {
        mRepository.insert(activityRecord); }
}