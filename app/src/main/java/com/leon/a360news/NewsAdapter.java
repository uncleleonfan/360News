package com.leon.a360news;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Leon on 2017/5/1.
 */

public class NewsAdapter extends RecyclerView.Adapter {

    private static final String TAG = "NewsAdapter";

    private Context mContext;
    private List<ResultBean.DataBean> mDataList;

    private static final int VIEW_TYPE_TITLE = 0;
    private static final int VIEW_TYPE_TITLE_AND_IMAGE = 1;
    private static final int VIEW_TYPE_THREE_IMAGES = 2;

    public NewsAdapter(Context context, List<ResultBean.DataBean> dataList) {
        mContext = context;
        mDataList = dataList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");
        switch (viewType) {
            case VIEW_TYPE_TITLE:
                return new TitleViewHolder(new TextView(mContext));
            case VIEW_TYPE_TITLE_AND_IMAGE:
                return new TitleAndImageViewHolder(new TitleAndImageView(mContext));
            case VIEW_TYPE_THREE_IMAGES:
                return new TitleAndThreeImageViewHolder(new TitleAndThreeImageView(mContext));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: ");
        ResultBean.DataBean dataBean = mDataList.get(position);
        switch (getItemViewType(position)) {
            case VIEW_TYPE_TITLE:
                ((TextView)holder.itemView).setText(dataBean.getTitle());
                break;
            case VIEW_TYPE_TITLE_AND_IMAGE:
                ((TitleAndImageView)holder.itemView).bindView(dataBean);
                break;
            case VIEW_TYPE_THREE_IMAGES:
                ((TitleAndThreeImageView)holder.itemView).bindView(dataBean);
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        Log.d(TAG, "getItemViewType: ");
        List<String> imgs = mDataList.get(position).getImgs();
        if (imgs.size() == 0) {
            return VIEW_TYPE_TITLE;
        } else if (imgs.size() == 1){
            return VIEW_TYPE_TITLE_AND_IMAGE;
        } else {
            return VIEW_TYPE_THREE_IMAGES;
        }
    }

    @Override
    public int getItemCount() {
        if (mDataList == null) {
            Log.d(TAG, "getItemCount: 0");
            return 0;
        }
        Log.d(TAG, "getItemCount: " + mDataList.size());
        return mDataList.size();
    }

    public class TitleViewHolder extends RecyclerView.ViewHolder {

        public TitleViewHolder(View itemView) {
            super(itemView);
        }
    }

    public class TitleAndImageViewHolder extends RecyclerView.ViewHolder {

        public TitleAndImageViewHolder(View itemView) {
            super(itemView);
        }
    }

    public class TitleAndThreeImageViewHolder extends RecyclerView.ViewHolder {

        public TitleAndThreeImageViewHolder(View itemView) {
            super(itemView);
        }
    }


}
