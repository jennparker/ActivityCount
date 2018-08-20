package com.booisajerk.activitycount;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "activity_record_table")
public class ActivityRecord {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "date")
    private String mDate;

    @ColumnInfo(name = "activity_one_count")
    private int mActivityOneCount;

    @ColumnInfo(name = "activity_two_count")
    private int mActivityTwoCount;

    @ColumnInfo(name = "activity_three_count")
    private int mActivityThreeCount;

    ActivityRecord(String date, int activityOneCount, int activityTwoCount, int activityThreeCount) {
        this.mDate = date;
        this.mActivityOneCount = activityOneCount;
        this.mActivityTwoCount = activityTwoCount;
        this.mActivityThreeCount = activityThreeCount;
    }

    public String getDate() {
        return this.mDate;
    }

    public int getActivityOneCount() {
        return  this.mActivityOneCount;
    }

    public int getActivityTwoCount() {
        return  this.mActivityTwoCount;
    }

    public int getActivityThreeCount() {
        return  this.mActivityThreeCount;
    }
}

