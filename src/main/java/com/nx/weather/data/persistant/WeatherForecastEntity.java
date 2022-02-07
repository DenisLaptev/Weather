package com.nx.weather.data.persistant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Denys Laptiev
 * Date: 2/7/2022
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherForecastEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String date;
    private String minTemp;
    private String maxTemp;
    private String link;

}
