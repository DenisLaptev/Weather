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
public class Headline {

    @SerializedName("EffectiveDate")
    private String effectiveDate;
    @SerializedName("EffectiveEpochDate")
    private String effectiveEpochDate;
    @SerializedName("Severity")
    private String severity;
    @SerializedName("Text")
    private String text;
    @SerializedName("Category")
    private String category;
    @SerializedName("EndDate")
    private String endDate;
    @SerializedName("EndEpochDate")
    private String endEpochDate;
    @SerializedName("MobileLink")
    private String mobileLink;
    @SerializedName("Link")
    private String link;
}
