package com.nx.weather.repository;

import com.nx.weather.data.persistant.WeatherForecastEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Denys Laptiev
 * Date: 2/7/2022
 */

//JpaRepository is better then CRUDRepository because it has useful methods (i.e. saveAndFlush)
public interface WeatherRepository  extends JpaRepository<WeatherForecastEntity, Long> {
}
