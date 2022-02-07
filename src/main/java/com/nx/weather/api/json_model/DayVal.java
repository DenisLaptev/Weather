package com.nx.weather.api.json_model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Denys Laptiev
 * Date: 2/7/2022
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DayVal {
    @SerializedName("Icon")
    private String icon;
    @SerializedName("IconPhrase")
    private String iconPhrase;
    @SerializedName("HasPrecipitation")
    private String hasPrecipitation;
    @SerializedName("PrecipitationType")
    private String precipitationType;
    @SerializedName("PrecipitationIntensity")
    private String precipitationIntensity;
}
