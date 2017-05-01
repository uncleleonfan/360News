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

public class TitleAndImageView extends RelativeLayout {

    private TextView mTitle;
    private ImageView mImageView;

    public TitleAndImageView(Context context) {
        this(context, null);
    }

    public TitleAndImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_title_and_image, this);
        mTitle = (TextView) findViewById(R.id.title);
        mImageView = (ImageView) findViewById(R.id.image);

    }

    public void bindView(ResultBean.DataBean dataBean) {
        mTitle.setText(dataBean.getTitle());
        Glide.with(getContext()).load(dataBean.getImgs().get(0)).into(mImageView);
    }
}
