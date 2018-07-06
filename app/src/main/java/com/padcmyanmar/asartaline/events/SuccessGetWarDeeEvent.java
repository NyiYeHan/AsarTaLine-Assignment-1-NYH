package com.padcmyanmar.asartaline.events;

import com.padcmyanmar.asartaline.data.vos.WarDeeVo;
import com.padcmyanmar.asartaline.network.responses.GetWarDeeResponse;

import java.util.List;

public class SuccessGetWarDeeEvent {
    private List<WarDeeVo> warDee;

    public List<WarDeeVo> getWarDee() {
        return warDee;
    }

    public SuccessGetWarDeeEvent(List<WarDeeVo> warDee) {

        this.warDee = warDee;
    }
}
