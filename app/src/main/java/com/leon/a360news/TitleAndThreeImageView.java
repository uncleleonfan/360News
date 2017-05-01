package com.leon.a360news;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by Leon on 2017/5/1.
 */

public class TitleAndThreeImageView extends RelativeLayout {

    private TextView mTitle;
    private ImageView mImageView1;
    private ImageView mImageView2;
    private ImageView mImageView3;

    public TitleAndThreeImageView(Context context) {
        this(context, null);
    }

    public TitleAndThreeImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_title_and_three_image, this);
        mTitle = (TextView) findViewById(R.id.title);
        mImageView1 = (ImageView) findViewById(R.id.image1);
        mImageView2 = (ImageView) findViewById(R.id.image2);
        mImageView3 = (ImageView) findViewById(R.id.image3);
    }

    public void bindView(ResultBean.DataBean dataBean) {
        mTitle.setText(dataBean.getTitle());
        Glide.with(getContext()).load(dataBean.getImgs().get(0)).into(mImageView1);
        Glide.with(getContext()).load(dataBean.getImgs().get(1)).into(mImageView2);
        Glide.with(getContext()).load(dataBean.getImgs().get(2)).into(mImageView3);
    }
}
