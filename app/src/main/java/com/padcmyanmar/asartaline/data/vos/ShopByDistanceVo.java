package com.padcmyanmar.asartaline.data.vos;

import com.google.gson.annotations.SerializedName;

public class ShopByDistanceVo {

    @SerializedName("shopByDistanceId")
    private String shopByDistanceId;

    @SerializedName("mealShop")
    private MealShopVo mealShop;

    @SerializedName("distanceInFeet")
    private String distanceInFeet;

    public String getShopByDistanceId() {
        return shopByDistanceId;
    }

    public MealShopVo getMealShop() {
        return mealShop;
    }

    public String getDistanceInFeet() {
        return distanceInFeet;
    }
}
