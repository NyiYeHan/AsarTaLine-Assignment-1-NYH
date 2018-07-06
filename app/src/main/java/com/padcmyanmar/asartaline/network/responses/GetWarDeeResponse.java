package com.padcmyanmar.asartaline.network.responses;

import com.google.gson.annotations.SerializedName;
import com.padcmyanmar.asartaline.data.vos.WarDeeVo;

import java.util.List;

public class GetWarDeeResponse {
    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;


    @SerializedName("apiVersion")
    private String apiVersion;

    @SerializedName("astlWarDee")
    private List<WarDeeVo> warDee;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public List<WarDeeVo> getWarDee() {
        return warDee;
    }
    public boolean isResponseOk(){
        return (code == 200 && warDee != null);
    }
}
