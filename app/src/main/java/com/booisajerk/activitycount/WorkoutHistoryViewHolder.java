package com.booisajerk.activitycount;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class WorkoutHistoryViewHolder extends RecyclerView.ViewHolder {

    private TextView dateTextView, activityOneTextView, activityTwoTextView, activityThreeTextView;

    public WorkoutHistoryViewHolder(final View itemView) {
        super(itemView);
        dateTextView = itemView.findViewById(R.id.activity_item_date);
        activityOneTextView = itemView.findViewById(R.id.activity_item_one);
        activityTwoTextView = itemView.findViewById(R.id.activity_item_two);
        activityThreeTextView = itemView.findViewById(R.id.activity_item_three);
    }

    public void bindData(final WorkoutHistoryViewModel viewModel) {
        dateTextView.setText(viewModel.getDateText());
        activityOneTextView.setText(viewModel.getActivityOneText());
        activityTwoTextView.setText(viewModel.getActivityTwoText());
        activityThreeTextView.setText(viewModel.getActivityThreeText());
    }
}