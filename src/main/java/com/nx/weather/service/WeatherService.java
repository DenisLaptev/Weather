package com.nx.weather.service;

import com.nx.weather.data.persistant.WeatherForecastEntity;
import com.nx.weather.data.ui_model.WeatherForecast;
import com.nx.weather.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Denys Laptiev
 * Date: 2/7/2022
 */
@Service
public class WeatherService implements CRUDService<WeatherForecast, Long> {

    @Autowired
    WeatherRepository weatherRepository;

    @Override
    public void create(WeatherForecast weatherForecast) {
        WeatherForecastEntity entity = convertDomainToEntity(weatherForecast);
        weatherRepository.save(entity);
    }

    @Override
    public WeatherForecast findById(Long id) {
        WeatherForecastEntity entity = weatherRepository.findById(id).orElse(null);
        WeatherForecast weatherForecast = convertEntityToDomain(entity);
        return weatherForecast;
    }

    @Override
    public List<WeatherForecast> findAll() {
        List<WeatherForecastEntity> entityList = weatherRepository.findAll();
        List<WeatherForecast> weatherForecasts = convertEntityListToDomainList(entityList);
        return weatherForecasts;
    }

    @Override
    public WeatherForecast update(WeatherForecast weatherForecast) {
        WeatherForecastEntity entity = convertDomainToEntity(weatherForecast);
        weatherRepository.save(entity);
        return weatherForecast;
    }

    @Override
    public void delete(WeatherForecast weatherForecast) {
        WeatherForecastEntity entity = convertDomainToEntity(weatherForecast);
        weatherRepository.delete(entity);
    }

    /*
    public class WeatherForecast {
        private Long id;
        private String date;
        private String minTemp;
        private String maxTemp;
        private String link;
    }
    public class WeatherForecastEntity {
        private Long id;
        private String date;
        private String minTemp;
        private String maxTemp;
        private String link;
    }
     */
    private WeatherForecastEntity convertDomainToEntity(WeatherForecast weatherForecast) {
        Long id = weatherForecast.getId();
        String date = weatherForecast.getDate();
        String minTemp = weatherForecast.getMinTemp();
        String maxTemp = weatherForecast.getMaxTemp();
        String link = weatherForecast.getLink();

        WeatherForecastEntity weatherForecastEntity = new WeatherForecastEntity();
        weatherForecastEntity.setId(id);
        weatherForecastEntity.setDate(date);
        weatherForecastEntity.setMinTemp(minTemp);
        weatherForecastEntity.setMaxTemp(maxTemp);
        weatherForecastEntity.setLink(link);

        return weatherForecastEntity;
    }

    private WeatherForecast convertEntityToDomain(WeatherForecastEntity weatherForecastEntity) {
        Long id = weatherForecastEntity.getId();
        String date = weatherForecastEntity.getDate();
        String minTemp = weatherForecastEntity.getMinTemp();
        String maxTemp = weatherForecastEntity.getMaxTemp();
        String link = weatherForecastEntity.getLink();

        WeatherForecast weatherForecast = new WeatherForecast();
        weatherForecast.setId(id);
        weatherForecast.setDate(date);
        weatherForecast.setMinTemp(minTemp);
        weatherForecast.setMaxTemp(maxTemp);
        weatherForecast.setLink(link);

        return weatherForecast;
    }

    private List<WeatherForecast> convertEntityListToDomainList(List<WeatherForecastEntity> entityList) {
        //TODO: make Stream implementation
        List<WeatherForecast> domainList = new ArrayList<>();
        for (WeatherForecastEntity entity : entityList) {
            WeatherForecast domain = convertEntityToDomain(entity);
            domainList.add(domain);
        }
        return domainList;
    }

    private List<WeatherForecastEntity> convertDomainListToEntityList(List<WeatherForecast> domainList) {
        //TODO: make Stream implementation
        List<WeatherForecastEntity> entityList = new ArrayList<>();
        for (WeatherForecast domain : domainList) {
            WeatherForecastEntity entity = convertDomainToEntity(domain);
            entityList.add(entity);
        }
        return entityList;
    }
}
