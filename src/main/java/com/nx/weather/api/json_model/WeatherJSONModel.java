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
public class WeatherJSONModel {

    @SerializedName("Headline")
    private Headline headline;
    @SerializedName("DailyForecasts")
    private List<DailyForecast> dailyForecasts = new ArrayList<>();
}
