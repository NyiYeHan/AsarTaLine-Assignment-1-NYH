package com.padcmyanmar.asartaline.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padcmyanmar.asartaline.R;
import com.padcmyanmar.asartaline.data.vos.WarDeeVo;
import com.padcmyanmar.asartaline.delegates.WarDeeDelegate;

import java.util.ArrayList;
import java.util.List;

import viewholders.ListViewHolder;

public class WarDeeAdapter extends RecyclerView.Adapter<ListViewHolder>{

    private List<WarDeeVo> mWarDeeVos;
    private WarDeeDelegate mWarDeeDelegate;

    public WarDeeAdapter(WarDeeDelegate warDeeDelegate){
        mWarDeeVos = new ArrayList<>();
        mWarDeeDelegate = warDeeDelegate;
    }
    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.view_holder_list,parent,false);
        return new ListViewHolder(view,mWarDeeDelegate);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        holder.bindData(mWarDeeVos.get(position));
    }

    @Override
    public int getItemCount() {
        return mWarDeeVos.size();
    }
    public void setWarDeeList(List<WarDeeVo> warDeeVos){
        mWarDeeVos = warDeeVos;
        notifyDataSetChanged();

    }
}
