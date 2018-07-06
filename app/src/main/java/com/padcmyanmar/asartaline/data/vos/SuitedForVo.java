package com.padcmyanmar.asartaline.data.vos;

import com.google.gson.annotations.SerializedName;

public class SuitedForVo {

    @SerializedName("suitedForId")
    private String suitedId;

    @SerializedName("suitedFor")
    private String suitedfor;

    @SerializedName("suitedForDesc")
    private String suitedForDesc;

    public String getSuitedId() {
        return suitedId;
    }

    public String getSuitedfor() {
        return suitedfor;
    }

    public String getSuitedForDesc() {
        return suitedForDesc;
    }
}
