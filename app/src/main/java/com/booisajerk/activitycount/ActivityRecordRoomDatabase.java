package com.booisajerk.activitycount;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {ActivityRecord.class}, version = 3)
public abstract class ActivityRecordRoomDatabase extends RoomDatabase {

    public abstract ActivityRecordDAO activityRecordDAO();

    private static ActivityRecordRoomDatabase INSTANCE;

    static ActivityRecordRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ActivityRecordRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ActivityRecordRoomDatabase.class, "activity_record_database")
                            .addCallback(sRoomDatabaseCallback)
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback() {

                @Override
                public void onOpen(@NonNull SupportSQLiteDatabase db) {
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final ActivityRecordDAO mDao;

        PopulateDbAsync(ActivityRecordRoomDatabase db) {
            mDao = db.activityRecordDAO();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            mDao.deleteAll();
            ActivityRecord activityRecord = new ActivityRecord(
                    "18 June 2018", 3, 5, 47);
            mDao.insert(activityRecord);
            activityRecord = new ActivityRecord("17 June 2018", 67, 4, 87);
            mDao.insert(activityRecord);
            return null;
        }
    }
}
