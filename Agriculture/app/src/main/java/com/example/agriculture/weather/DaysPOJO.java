package com.example.agriculture.weather;

public class DaysPOJO {

    String daysDate;
    String minValue;
    String maxValue;

    public DaysPOJO(String daysDate, String minValue, String maxValue) {
        this.daysDate = daysDate;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public String getDaysDate() {
        return daysDate;
    }

    public void setDaysDate(String daysDate) {
        this.daysDate = daysDate;
    }

    public String getMinValue() {
        return minValue;
    }

    public void setMinValue(String minValue) {
        this.minValue = minValue;
    }

    public String getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(String maxValue) {
        this.maxValue = maxValue;
    }
}
