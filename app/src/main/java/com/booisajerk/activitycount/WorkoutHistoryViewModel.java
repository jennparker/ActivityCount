package com.booisajerk.activitycount;

import androidx.annotation.NonNull;

public class WorkoutHistoryViewModel {

    private String itemText;

    public WorkoutHistoryViewModel(@NonNull final String itemText) {
        setText(itemText);
    }

    @NonNull
    public String getText() {
        return itemText;
    }

    public void setText(@NonNull final String itemText) {
        this.itemText = itemText;
    }
}