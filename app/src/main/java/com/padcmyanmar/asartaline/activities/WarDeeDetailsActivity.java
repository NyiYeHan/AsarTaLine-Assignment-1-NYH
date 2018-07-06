package com.padcmyanmar.asartaline.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.padcmyanmar.asartaline.R;
import com.padcmyanmar.asartaline.data.models.WarDeeModel;
import com.padcmyanmar.asartaline.data.vos.TasteVo;
import com.padcmyanmar.asartaline.data.vos.WarDeeVo;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WarDeeDetailsActivity extends AppCompatActivity {


    @BindView(R.id.tv_title_details)
    TextView tvDetailsTitle;

    @BindView(R.id.details_description)
    TextView tvDescription;

    @BindView(R.id.iv_details)
    ImageView ivDetails;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_war_dee_details);
        ButterKnife.bind(this, this);

        String wardeeId = getIntent().getStringExtra("wardeeId");
        WarDeeVo warDeeVo = WarDeeModel.getObj().getWarDeeById(wardeeId);
        if (warDeeVo != null) {
            bind(warDeeVo);

        }
    }

    public void bind(WarDeeVo warDeeVo) {

        for (TasteVo tasteVo : warDeeVo.getGeneralTaste()) {
            tvDetailsTitle.setText(tasteVo.getTaste());
            tvDescription.setText(tasteVo.getTasteDesc());
        }
        for (String url : warDeeVo.getImages()){
            Glide.with(ivDetails.getContext())
                    .load(url)
                    .into(ivDetails);
        }

    }
}
