package com.example.myview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class layout extends View {
    private int lastX;
    private int lastY;
    public layout(Context context) {
        super(context);
    }

    public layout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public layout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //获取手指触碰点的x,y坐标
        int x = (int)event.getX();
        int y = (int)event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                //按下的手势已完成，动作包含最终释放位置以及自上次向下或移动事件以来的任何中间点。
                lastX = x;
                lastY = y;
                break;
                case MotionEvent.ACTION_MOVE:
                    //计算移动的距离
                    int offsetX = x - lastX;
                    int offsetY = y - lastY;
                    //重新放置位置
                    layout(getLeft()+offsetX,getTop()+offsetY,getRight()+offsetX,getBottom()+offsetY);
                    break;
        }
        return true;

    }
}
