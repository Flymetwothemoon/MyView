package com.example.myview;

import android.view.View;

public class ObjectAnimator {
    public ObjectAnimator(View view) {
        mView = view;
    }

    public void setWidth(int width){
        mView.getLayoutParams().width=width;
        mView.requestLayout();
    }
    public int getWidth(){
        return mView.getLayoutParams().width;
    }
    private View mView;
}
