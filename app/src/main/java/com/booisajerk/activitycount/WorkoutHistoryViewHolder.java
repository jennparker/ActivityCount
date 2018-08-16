package com.booisajerk.activitycount;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class WorkoutHistoryViewHolder extends RecyclerView.ViewHolder {

    private TextView textView;

    public WorkoutHistoryViewHolder(final View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.activity_item);
    }

    public void bindData(final WorkoutHistoryViewModel viewModel) {
        textView.setText(viewModel.getText());
    }
}