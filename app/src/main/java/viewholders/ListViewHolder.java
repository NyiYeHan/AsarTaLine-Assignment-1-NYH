package viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.padcmyanmar.asartaline.R;
import com.padcmyanmar.asartaline.data.vos.TasteVo;
import com.padcmyanmar.asartaline.data.vos.WarDeeVo;
import com.padcmyanmar.asartaline.delegates.WarDeeDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListViewHolder extends RecyclerView.ViewHolder {

    private WarDeeVo mWarDeeVo;
    private WarDeeDelegate mWarDeeDelegate;

    @BindView(R.id.tv_title)
    TextView tvTitle;

    @BindView(R.id.iv_small)
    ImageView ivSmall;

    @BindView(R.id.tv_taste)
    TextView tvTaste;


    public ListViewHolder(View itemView, WarDeeDelegate warDeeDelegate) {

        super(itemView);
        ButterKnife.bind(this, itemView);
        this.mWarDeeDelegate = warDeeDelegate;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mWarDeeDelegate.onTapList(mWarDeeVo);
            }
        });

    }

    public void bindData(WarDeeVo warDeeVo) {
        mWarDeeVo = warDeeVo;
        for (String url : warDeeVo.getImages()) {
            Glide.with(ivSmall.getContext())
                    .load(url)
                    .into(ivSmall);
        }
        tvTitle.setText(warDeeVo.getName());
        for (TasteVo tasteVo : warDeeVo.getGeneralTaste()) {
            tvTaste.setText(tasteVo.getTaste());
        }
    }
}
