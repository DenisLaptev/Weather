package com.nx.weather.data.ui_model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Denys Laptiev
 * Date: 2/7/2022
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherForecast {

    private Long id;
    private String date;
    private String minTemp;
    private String maxTemp;
    private String link;
}
