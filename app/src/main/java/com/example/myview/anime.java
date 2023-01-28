package com.example.myview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class anime extends View {
    private int lastX;
    private int lastY;
    public anime(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
//        int x = (int) event.getX();
//        int y = (int) event.getY();
//        switch (event.getAction()){
//            case MotionEvent.ACTION_DOWN:
//                lastX = x;
//                lastY = y;
//                break;
//                case MotionEvent.ACTION_HOVER_MOVE:
//
//        }
        return true;
    }
}
