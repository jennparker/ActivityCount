package com.booisajerk.activitycount;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class WorkoutHistoryAdapter extends RecyclerView.Adapter {

    private List<WorkoutHistoryViewModel> models = new ArrayList<>();

    public WorkoutHistoryAdapter(final List<WorkoutHistoryViewModel> viewModels) {
        if (viewModels != null) {
            this.models.addAll(viewModels);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new WorkoutHistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        ((WorkoutHistoryViewHolder) holder).bindData(models.get(position));
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    @Override
    public int getItemViewType(final int position) {
        return R.layout.activity_history_row;
    }
}