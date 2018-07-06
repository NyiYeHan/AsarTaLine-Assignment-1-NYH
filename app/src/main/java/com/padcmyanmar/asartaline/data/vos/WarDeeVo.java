package com.padcmyanmar.asartaline.data.vos;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WarDeeVo {

    @SerializedName("warDeeId")
    private String warDeeId;

    @SerializedName("name")
    private String name;

    @SerializedName("images")
    private List<String> images;

    @SerializedName("generalTaste")
    private List<TasteVo> generalTaste;

    @SerializedName("suitedFor")
    private List<SuitedForVo> suitedFor;

    @SerializedName("priceRangeMin")
    private String priceRangeMin;

    @SerializedName("priceRangeMax")
    private String priceRangeMax;

    @SerializedName("matchWarDeeList")
    private List<WarDeeVo> matchWarDeeList;

    @SerializedName("shopByDistance")
    private List<ShopByDistanceVo> shopByDistance;

    @SerializedName("shopByPopularity")
    private List<ShopByPopularityVo> shopByPopularity;

    public String getWarDeeId() {
        return warDeeId;
    }

    public String getName() {
        return name;
    }

    public List<String> getImages() {
        return images;
    }

    public List<TasteVo> getGeneralTaste() {
        return generalTaste;
    }

    public List<SuitedForVo> getSuitedFor() {
        return suitedFor;
    }

    public String getPriceRangeMin() {
        return priceRangeMin;
    }

    public String getPriceRangeMax() {
        return priceRangeMax;
    }

    public List<WarDeeVo> getMatchWarDeeList() {
        return matchWarDeeList;
    }

    public List<ShopByDistanceVo> getShopByDistance() {
        return shopByDistance;
    }

    public List<ShopByPopularityVo> getShopByPopularity() {
        return shopByPopularity;
    }
}
