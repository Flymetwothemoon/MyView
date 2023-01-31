package com.example.myview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.TestLooperManager;
import android.util.Log;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
    private Button mButton_8;
    private Button mButton_9;
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
        mButton_8 = findViewById(R.id.button_8);
        mButton_9 = findViewById(R.id.button_9);
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
        monior(animator6);
        init_0();
        init_1();
        animatorset();
        propervaluesholder(mButton_9);
    }

    private void propervaluesholder(Button button) {
        PropertyValuesHolder propertyValuesHolder = PropertyValuesHolder.ofFloat("scaleX",2,3,4,1);
        PropertyValuesHolder propertyValuesHolder1 = PropertyValuesHolder.ofFloat("translationX",100,200,300,100);
        PropertyValuesHolder propertyValuesHolder2 = PropertyValuesHolder.ofFloat("alpha",1,0,1,0,1);
        PropertyValuesHolder propertyValuesHolder3 = PropertyValuesHolder.ofFloat("rotationX",180,90,180,0);
        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(button,propertyValuesHolder,propertyValuesHolder1,propertyValuesHolder2,propertyValuesHolder3);
        objectAnimator.setDuration(5000).start();
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
    private void monior(ObjectAnimator animator){

        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                Toast.makeText(MainActivity.this,"scaleX2 start",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Toast.makeText(MainActivity.this,"scaleX2 end",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                Toast.makeText(MainActivity.this,"scaleX2 cancel",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                Toast.makeText(MainActivity.this,"scaleX2 repeat",Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void animatorset(){
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mButton_8,"translationX",100,0,50,100);
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(mButton_8,"alpha",0,1,0,1);
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(mButton_8,"rotationX",90,180,360,0);
        ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(mButton_8,"scaleX",2,3,4,5,1);
        animatorSet.setDuration(3000);
        animatorSet.play(objectAnimator).with(objectAnimator1).before(objectAnimator2).after(objectAnimator3);
        animatorSet.start();
    }
}