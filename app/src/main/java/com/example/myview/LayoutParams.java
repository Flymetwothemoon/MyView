package com.example.myview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;

public class LayoutParams extends View {
    private int lastX;
    private int lastY;
    public LayoutParams(Context context) {
        super(context);
    }

    public LayoutParams(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public LayoutParams(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int)event.getX();
        int y = (int)event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                lastX = x;
                lastY = y;
                break;
                case MotionEvent.ACTION_MOVE:
                    int offsetX = x - lastX;
                    int offsetY = y - lastY;
                   RelativeLayout.LayoutParams layoutParams= (RelativeLayout.LayoutParams) getLayoutParams();
                    layoutParams.leftMargin = getLeft() + offsetX;
                    layoutParams.topMargin = getTop() + offsetY;
                    setLayoutParams(layoutParams);
                    break;
        }
        return true;
    }
}
