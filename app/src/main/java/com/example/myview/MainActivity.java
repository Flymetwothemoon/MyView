package com.example.myview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.TestLooperManager;
import android.util.Log;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import Adapter.num;
import Adapter.numAdapter;


public class MainActivity extends AppCompatActivity {
    private com.example.myview.anime anime;
    private com.example.myview.scroller mScroller;
    private Button mButton;
    private Button mButton_1;
    private Button mButton_2;
    private Button mButton_4;
    private Button mButton_3;
    private Button mButton_5;
    private Button mButton_6;
    private Button mButton_7;
    private List<num>mList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init(){
        anime = findViewById(R.id.anime);
        mButton = findViewById(R.id.button_0);
        mButton_1 = findViewById(R.id.button_1);
        mButton_2 = findViewById(R.id.button_2);
        mButton_3 = findViewById(R.id.button_3);
        mButton_4 = findViewById(R.id.button_4);
        mButton_5 = findViewById(R.id.button_5);
        mButton_6 = findViewById(R.id.button_6);
        mButton_7 = findViewById(R.id.button_7);
        anime.setAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.translate));
        mScroller = findViewById(R.id.scroller);
        mScroller.smoothScrollTo(-100,0);
        android.animation.ObjectAnimator animator = android.animation.ObjectAnimator.ofFloat(mButton,"alpha", 0,1);
        animator.setDuration(20000);
        animator.start();
        android.animation.ObjectAnimator animator1 = android.animation.ObjectAnimator.ofFloat(mButton_1,"translationX",100);
        animator1.setDuration(200000);
        animator1.start();
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(mButton_2,"rotationX",180,360);
        animator2.setDuration(10000);
        animator2.start();
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(mButton_3,"rotation",180,360);
        animator3.setDuration(10000);
        animator3.start();
        ObjectAnimator animator4 = ObjectAnimator.ofFloat(mButton_4,"rotationY",180,360);
        animator4.setDuration(10000);
        animator4.start();
        ObjectAnimator animator5 = ObjectAnimator.ofFloat(mButton_5,"scaleX",1);
        animator5.setDuration(20000);
        animator5.start();
        ObjectAnimator animator6 = ObjectAnimator.ofFloat(mButton_6,"scaleX",2);
        animator6.setDuration(20000);
        animator6.start();
        init_0();
        init_1();
    }
    private void init_0(){
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0,100);
        valueAnimator.setTarget(mButton_7);
        valueAnimator.setDuration(10000).start();
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Float mFloat = (Float)animation.getAnimatedValue();
                Log.d("TAG",""+mFloat);
                num num1 = new num();
                num1.num =String.valueOf(mFloat);
                mList.add(num1);
            }
        });
    }
    private void init_1(){
        numAdapter adapter = new numAdapter(mList);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setAdapter(adapter);
    }
}