package com.example.myview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity {
    private com.example.myview.anime anime;
    private com.example.myview.scroller mScroller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init(){
        anime = findViewById(R.id.anime);
        anime.setAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.translate));
        //ObjectAnimator.ofFloat(anime,"translationX",0,300).setDuration(1000).start();
        mScroller = findViewById(R.id.scroller);
        mScroller.smoothScrollTo(-100,0);
    }
}