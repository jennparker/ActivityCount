package com.booisajerk.activitycount;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class ActivityRecordAdapter extends RecyclerView.Adapter<ActivityRecordAdapter.ActivityRecordViewHolder> {


    class ActivityRecordViewHolder extends RecyclerView.ViewHolder {
        private final TextView dateItemView, activityOneItemView, activityTwoItemView, activityThreeItemView;

        private ActivityRecordViewHolder(View itemView) {
            super(itemView);
            dateItemView = itemView.findViewById(R.id.activity_item_date);
            activityOneItemView = itemView.findViewById(R.id.activity_item_one);
            activityTwoItemView = itemView.findViewById(R.id.activity_item_two);
            activityThreeItemView = itemView.findViewById(R.id.activity_item_three);
        }
    }

    private final LayoutInflater mInflater;
    private List<ActivityRecord> mActivityRecords; // Cached copy of activity records

    ActivityRecordAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public ActivityRecordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.activity_history_row, parent, false);
        return new ActivityRecordViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ActivityRecordViewHolder holder, int position) {
        if (mActivityRecords != null) {
            ActivityRecord current = mActivityRecords.get(position);
            holder.dateItemView.setText(current.getDate());
            //TODO Be smarter with displaying these strings
            holder.activityOneItemView.setText("Squats: " + String.valueOf(current.getActivityOneCount()));
            holder.activityTwoItemView.setText("Push ups: " + String.valueOf(current.getActivityTwoCount()));
            holder.activityThreeItemView.setText("Dip: " + String.valueOf(current.getActivityThreeCount()));


        } else {
            //TODO remove hard coding
            holder.dateItemView.setText("No Date");
            holder.activityOneItemView.setText("No result");
            holder.activityTwoItemView.setText("No results");
            holder.activityThreeItemView.setText("No results");
        }
    }

    void setActivityRecord(List<ActivityRecord> activityRecords) {
        mActivityRecords = activityRecords;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (mActivityRecords != null) {
            return mActivityRecords.size();
        } else {
            return 0;
        }
    }
}