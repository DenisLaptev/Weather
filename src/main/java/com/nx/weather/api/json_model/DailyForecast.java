package com.nx.weather.api.json_model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Denys Laptiev
 * Date: 2/7/2022
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DailyForecast {

    @SerializedName("Date")
    private String date;
    @SerializedName("EpochDate")
    private String epochDate;
    @SerializedName("Temperature")
    private Temperature temperature;
    @SerializedName("Day")
    private DayVal day;
    @SerializedName("Night")
    private DayVal night;
    @SerializedName("Sources")
    private List<String> sources = new ArrayList<>();
    @SerializedName("MobileLink")
    private String mobileLink;
    @SerializedName("Link")
    private String link;
}
