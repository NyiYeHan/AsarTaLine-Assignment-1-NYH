package com.padcmyanmar.asartaline.data.vos;

import com.google.gson.annotations.SerializedName;

public class ShopByPopularityVo {

    @SerializedName("shopByPopularityId")
    private String shopByPopularityId;

    @SerializedName("mealShop")
    private MealShopVo mealShop;

    public String getShopByPopularityId() {
        return shopByPopularityId;
    }

    public MealShopVo getMealShop() {
        return mealShop;
    }
}
