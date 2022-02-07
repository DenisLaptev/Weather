package com.nx.weather.controller.rest;

import com.nx.weather.data.ui_model.WeatherForecast;
import com.nx.weather.service.CRUDService;
import com.nx.weather.service.WeatherAPIService;
import com.nx.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Denys Laptiev
 * Date: 2/7/2022
 */

@RestController
@RequestMapping(WeatherForecastRestController.WEATHER_FORECAST_URL)
public class WeatherForecastRestController extends CRUDRestController<WeatherForecast, Long>{

    public static final String WEATHER_FORECAST_URL = "weather-forecast";

    @Autowired
    private WeatherService weatherService;
    @Autowired
    private WeatherAPIService weatherAPIService;

    @GetMapping("/init")
    public ResponseEntity<List<WeatherForecast>> init() {

        List<WeatherForecast> wfs = new ArrayList();

        wfs.add(new WeatherForecast(1L, "Date1", "-10", "+10",null));
        wfs.add(new WeatherForecast(2L, "Date2", "-20", "+30","link2"));
        wfs.add(new WeatherForecast(3L, "Date3", "-1", "+20",null));
        wfs.add(new WeatherForecast(4L, "Date4", "-5", "+40","link4"));
        wfs.add(new WeatherForecast(5L, "Date5", "-10", "+2",null));

        for (WeatherForecast wf : wfs) {
            weatherService.create(wf);
        }

        return ResponseEntity.ok(wfs);
    }

    @GetMapping("/from-api")
    public ResponseEntity<List<WeatherForecast>> fromAPI() throws IOException, InterruptedException {

        List<WeatherForecast> wfs = weatherAPIService.findAll();

        return ResponseEntity.ok(wfs);
    }

    @Override
    CRUDService<WeatherForecast, Long> getService() {
        return weatherService;
    }
}
