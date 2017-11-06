package com.saran.play;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by core I5 on 10/31/2017.
 */

public class BsociableTourActivity extends AppCompatActivity implements View.OnClickListener {
    private ViewPager vpTour, vpTourHolder;
    private TabLayout tlTour;
    private Button btnNext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour);
        getSupportActionBar().hide();

        vpTour = findViewById(R.id.vp_tour);
        vpTourHolder = findViewById(R.id.vp_tour_holder);
        tlTour = findViewById(R.id.tl_tour);
        btnNext = findViewById(R.id.btn_next);

        btnNext.setOnClickListener(this);

        TourPagerAdapter tourPagerAdapter = new TourPagerAdapter(getSupportFragmentManager());
        vpTour.setAdapter(tourPagerAdapter);
        vpTour.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                vpTourHolder.setCurrentItem(position);
                if (position == 2){
                    btnNext.setText(getString(R.string.done));
                } else {
                    btnNext.setText(getString(R.string.next));
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        tlTour.setupWithViewPager(vpTour);
        LinearLayout tabStrip = ((LinearLayout)tlTour.getChildAt(0));
        for(int i = 0; i < tabStrip.getChildCount(); i++) {
            tabStrip.getChildAt(i).setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    return true;
                }
            });
        }

        TourContentPagerAdapter contentPagerAdapter = new TourContentPagerAdapter(getSupportFragmentManager());
        vpTourHolder.setAdapter(contentPagerAdapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_next:{
                if (btnNext.getText().toString().equalsIgnoreCase("NEXT")){
                    vpTour.setCurrentItem(vpTour.getCurrentItem()+1);
                } else if (btnNext.getText().toString().equalsIgnoreCase("DONE")){
                    Intent intent = new Intent(this,BsociableInviteActivity.class);
                    startActivity(intent);
                }
                break;
            }
        }
    }
}
