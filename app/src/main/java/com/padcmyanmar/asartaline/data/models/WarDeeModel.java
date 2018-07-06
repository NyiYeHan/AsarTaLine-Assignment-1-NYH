package com.padcmyanmar.asartaline.data.models;

import com.padcmyanmar.asartaline.data.vos.WarDeeVo;
import com.padcmyanmar.asartaline.events.SuccessGetWarDeeEvent;
import com.padcmyanmar.asartaline.network.RetrofitDataAgentImpl;
import com.padcmyanmar.asartaline.network.WarDeeDataAgent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;
import java.util.Map;

public class WarDeeModel {
    private static WarDeeModel obj;
    private Map<String, WarDeeVo> mMap;
    private WarDeeDataAgent warDeeDataAgent;
    private static final String DUMMY_ACESS_TOKEN = "b002c7e1a528b7cb460933fc2875e916";
    private WarDeeModel() {
        warDeeDataAgent = RetrofitDataAgentImpl.getObj();
        EventBus.getDefault().register(this);
        mMap = new HashMap<>();
    }

    public static WarDeeModel getObj() {
        if (obj == null) {
            obj = new WarDeeModel();
        }
        return obj;
    }

    public void loadWarDeeList() {
        warDeeDataAgent.loadWarDeeList(1, DUMMY_ACESS_TOKEN);

    }

    public WarDeeVo getWarDeeById(String warDeeId) {
        return mMap.get(warDeeId);
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onSuccessGetWarDee(SuccessGetWarDeeEvent event) {
        for (WarDeeVo warDee : event.getWarDee()) {
            mMap.put(warDee.getWarDeeId(), warDee);
        }

    }
}
