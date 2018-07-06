package com.padcmyanmar.asartaline.network;

import com.padcmyanmar.asartaline.events.FailureEvent;
import com.padcmyanmar.asartaline.events.SuccessGetWarDeeEvent;
import com.padcmyanmar.asartaline.network.responses.GetWarDeeResponse;
import com.padcmyanmar.asartaline.utils.WarDeeConstants;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitDataAgentImpl implements WarDeeDataAgent {

    private static RetrofitDataAgentImpl obj;
    private WarDeeApi mWarDeeApi;

    private RetrofitDataAgentImpl() {
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(WarDeeConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        mWarDeeApi = retrofit.create(WarDeeApi.class);
    }

    public static RetrofitDataAgentImpl getObj() {
        if (obj == null) {
            obj = new RetrofitDataAgentImpl();
        }
        return obj;
    }


    @Override
    public void loadWarDeeList(int page, String accessToken) {
        Call<GetWarDeeResponse> loadNewCall = mWarDeeApi.loadWarDeeList(accessToken, page);
        loadNewCall.enqueue(new Callback<GetWarDeeResponse>() {
            @Override
            public void onResponse(Call<GetWarDeeResponse> call, Response<GetWarDeeResponse> response) {
                GetWarDeeResponse warDeeResponse = response.body();
                if (warDeeResponse.isResponseOk() && warDeeResponse != null) {
                    SuccessGetWarDeeEvent event = new SuccessGetWarDeeEvent(warDeeResponse.getWarDee());
                    EventBus.getDefault().post(event);
                }
            }

            @Override
            public void onFailure(Call<GetWarDeeResponse> call, Throwable t) {
                FailureEvent event = new FailureEvent(t.getMessage());
                EventBus.getDefault().post(event);
            }
        });

    }
}
