package com.example.agriculture.weather;

public class HourlyPOJO {

    String dateTime;
    String weatherIcon;
    String iconPhrase;
    String value;

    public HourlyPOJO(String datetime, String weathericon, String iconphrase, String t_value) {
        dateTime = datetime;
        weatherIcon = weathericon;
        iconPhrase = iconphrase;
        value = t_value;
    }

    public String getDateTime() {
        return dateTime;
    }

    public String getWeatherIcon() {
        return weatherIcon;
    }

    public String getIconPhrase() {
        return iconPhrase;
    }

    public String getValue() {
        return value;
    }
}

