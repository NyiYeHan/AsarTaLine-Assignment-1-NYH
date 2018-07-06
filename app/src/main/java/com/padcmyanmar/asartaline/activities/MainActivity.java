package com.padcmyanmar.asartaline.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.padcmyanmar.asartaline.R;
import com.padcmyanmar.asartaline.adapters.WarDeeAdapter;
import com.padcmyanmar.asartaline.data.models.WarDeeModel;
import com.padcmyanmar.asartaline.data.vos.WarDeeVo;
import com.padcmyanmar.asartaline.delegates.WarDeeDelegate;
import com.padcmyanmar.asartaline.events.SuccessGetWarDeeEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements WarDeeDelegate {


    private WarDeeVo mWarDeeVo;
    private WarDeeAdapter adapter;

    @BindView(R.id.rv_list)
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this, this);
        adapter = new WarDeeAdapter(this);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        WarDeeModel.getObj().loadWarDeeList();
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSuccessGetWarDee(SuccessGetWarDeeEvent event) {
        adapter.setWarDeeList(event.getWarDee());
    }

    @Override
    public void onTapList(WarDeeVo warDeeVo) {
        Intent intent = new Intent(getApplicationContext(), WarDeeDetailsActivity.class);
        intent.putExtra("wardeeId", warDeeVo.getWarDeeId());
        startActivity(intent);
    }
}
