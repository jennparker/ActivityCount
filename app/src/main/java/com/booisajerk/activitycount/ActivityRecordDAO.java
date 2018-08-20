package com.booisajerk.activitycount;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface ActivityRecordDAO {

    @Insert
    void insert(ActivityRecord activityRecord);

    @Query("DELETE FROM activity_record_table")
    void deleteAll();

    @Query("SELECT * from activity_record_table ORDER BY date ASC")
    LiveData<List<ActivityRecord>> getAllActivityRecords();

}