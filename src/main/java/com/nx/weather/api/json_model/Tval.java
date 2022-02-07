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
public class Tval {
    @SerializedName("Value")
    private String value;
    @SerializedName("Unit")
    private String unit;
    @SerializedName("UnitType")
    private String unitType;
}
