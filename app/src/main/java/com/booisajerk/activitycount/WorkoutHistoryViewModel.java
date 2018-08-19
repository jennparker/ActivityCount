package com.booisajerk.activitycount;

import androidx.annotation.NonNull;

public class WorkoutHistoryViewModel {

    private String dateText;
    private String activityOneText;
    private String activityTwoText;
    private String activityThreeText;

    public WorkoutHistoryViewModel(@NonNull final String dateText, @NonNull final String activityOneText
            , @NonNull final String activityTwoText, @NonNull final String activityThreeText) {
        setDateText(dateText);
        setActivityOneText(activityOneText);
        setActivityTwoText(activityTwoText);
        setActivityThreeText(activityThreeText);
    }

    @NonNull
    public String getDateText() {
        return dateText;
    }

    public void setDateText(@NonNull final String dateText) {
        this.dateText = dateText;
    }

    @NonNull
    public String getActivityOneText() {
        return activityOneText;
    }

    public void setActivityOneText(@NonNull final String activityOneText) {
        this.activityOneText = activityOneText;
    }

    @NonNull
    public String getActivityTwoText() {
        return activityTwoText;
    }

    public void setActivityTwoText(@NonNull final String activityTwoText) {
        this.activityTwoText = activityTwoText;
    }

    @NonNull
    public String getActivityThreeText() {
        return activityThreeText;
    }

    public void setActivityThreeText(@NonNull final String activityThreeText) {
        this.activityThreeText = activityThreeText;
    }
}