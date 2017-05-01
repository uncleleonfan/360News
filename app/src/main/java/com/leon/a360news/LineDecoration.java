package com.leon.a360news;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Leon on 2017/5/1.
 */

public class LineDecoration extends RecyclerView.ItemDecoration {

    private Drawable mDividerDrawer;

    public LineDecoration() {
        mDividerDrawer = new ColorDrawable(Color.BLACK);
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int width = parent.getWidth();
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = parent.getChildAt(i);
            mDividerDrawer.setBounds(0, childAt.getBottom(), width, childAt.getBottom() + 2);
            mDividerDrawer.draw(c);
        }
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.set(0, 0, 0, 30);
    }
}
