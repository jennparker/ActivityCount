package com.booisajerk.activitycount;

import android.app.Application;
import android.os.AsyncTask;

import java.util.List;

import androidx.lifecycle.LiveData;

public class ActivityRecordRepository {

    private ActivityRecordDAO activityRecordDAO;
    private LiveData<List<ActivityRecord>> mAllActivityRecords;

    ActivityRecordRepository(Application application) {

        ActivityRecordRoomDatabase db = ActivityRecordRoomDatabase.getDatabase(application);
        activityRecordDAO = db.activityRecordDAO();
        mAllActivityRecords = activityRecordDAO.getAllActivityRecords();
    }

    LiveData<List<ActivityRecord>> getAllActivityRecords() {
        return mAllActivityRecords;
    }

    public void insert(ActivityRecord activityRecord) {
        new insertAsyncTask(activityRecordDAO).execute(activityRecord);
    }

    private static class insertAsyncTask extends AsyncTask<ActivityRecord, Void, Void> {

        private ActivityRecordDAO mAsyncTaskDao;

        insertAsyncTask(ActivityRecordDAO dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final ActivityRecord... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
