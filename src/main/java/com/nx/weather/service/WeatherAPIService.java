package com.nx.weather.service;


import com.google.gson.Gson;
import com.nx.weather.api.json_model.DailyForecast;
import com.nx.weather.api.json_model.WeatherJSONModel;
import com.nx.weather.data.ui_model.WeatherForecast;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Denys Laptiev
 * Date: 2/7/2022
 */

@Service
public class WeatherAPIService implements CRUDService<WeatherForecast, Long> {

    private final static String WEATHER_API_URL = "http://dataservice.accuweather.com/forecasts/v1/daily/5day/323903";
    private final static String API_KEY = "Q83Viyd4pHVdeCdXQgdrpB0tvo4GG3vw";
    private final static String PARAM_API_KEY = "apikey";


    private String getJSONStringFromAPI() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(WEATHER_API_URL + "?" + PARAM_API_KEY + "=" + API_KEY))
                .build();

        HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
        String jsonString = httpResponse.body();
        System.out.println(jsonString);
        return jsonString;
    }

    private WeatherJSONModel getObject(String jsonString) {
        Gson gson = new Gson();
        WeatherJSONModel weatherJSONModel = gson.fromJson(jsonString, WeatherJSONModel.class);
        System.out.println(weatherJSONModel);
        return weatherJSONModel;
    }

    @Override
    public void create(WeatherForecast obj) {
        throw new UnsupportedOperationException();
    }

    @Override
    public WeatherForecast findById(Long id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<WeatherForecast> findAll() throws IOException, InterruptedException {
        String jsonString = getJSONStringFromAPI();
        WeatherJSONModel weatherJSONModel = getObject(jsonString);
        List<WeatherForecast> weatherForecasts = convertJSONModelToDomainList(weatherJSONModel);
        return weatherForecasts;
    }

    private List<WeatherForecast> convertJSONModelToDomainList(WeatherJSONModel weatherJSONModel) {
        List<WeatherForecast> weatherForecasts = new ArrayList<>();
        List<DailyForecast> dailyForecasts = weatherJSONModel.getDailyForecasts();
        for (DailyForecast dailyForecast : dailyForecasts) {
            WeatherForecast weatherForecast = new WeatherForecast();
            weatherForecast.setId(Long.parseLong(dailyForecast.getEpochDate()));
            weatherForecast.setDate(dailyForecast.getDate());
            weatherForecast.setMinTemp(dailyForecast.getTemperature().getMinimum().getValue());
            weatherForecast.setMaxTemp(dailyForecast.getTemperature().getMaximum().getValue());
            weatherForecast.setLink(dailyForecast.getLink());
            weatherForecasts.add(weatherForecast);
        }
        return weatherForecasts;
    }

    @Override
    public WeatherForecast update(WeatherForecast obj) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(WeatherForecast obj) {
        throw new UnsupportedOperationException();
    }
}
