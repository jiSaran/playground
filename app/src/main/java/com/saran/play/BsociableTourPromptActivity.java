package com.saran.play;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by core I5 on 10/31/2017.
 */

public class BsociableTourPromptActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnTakeTour;
    private TextView tvSkip;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_prompt);
        getSupportActionBar().hide();
        btnTakeTour = findViewById(R.id.btn_take_tour);
        btnTakeTour.setOnClickListener(this);
        tvSkip = findViewById(R.id.tv_skip);
        Animation bottomUp = AnimationUtils.loadAnimation(this,
                R.anim.slide_from_bottom);

        Animation sildeIn = AnimationUtils.loadAnimation(this,
                R.anim.bottom_slide_in);

        final float startSize = 0; // Size in pixels
        final float endSize = 15;
        final int animationDuration = 1500; // Animation duration in ms

        ValueAnimator animator = ValueAnimator.ofFloat(startSize, endSize);
        animator.setDuration(animationDuration);

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedValue = (float) valueAnimator.getAnimatedValue();
                btnTakeTour.setTextSize(animatedValue);
            }
        });

        animator.start();
        btnTakeTour.startAnimation(bottomUp);
        tvSkip.startAnimation(sildeIn);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_take_tour:{
                Intent intent = new Intent(this,BsociableTourActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.tv_skip:{
                break;
            }
        }
    }
}
