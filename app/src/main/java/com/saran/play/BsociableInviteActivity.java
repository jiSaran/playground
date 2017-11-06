package com.saran.play;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by core I5 on 10/31/2017.
 */

public class BsociableInviteActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView ivMessenger, ivWhatsapp, ivSms, ivEmail;
    private TextView tvSkip;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite_frame);
        getSupportActionBar().hide();
        ivMessenger = findViewById(R.id.iv_messenger);
        ivWhatsapp = findViewById(R.id.iv_whatsapp);
        ivEmail = findViewById(R.id.iv_email);
        ivSms = findViewById(R.id.iv_sms);
        tvSkip = findViewById(R.id.tv_skip);

        ivMessenger.setOnClickListener(this);
        ivWhatsapp.setOnClickListener(this);
        ivEmail.setOnClickListener(this);
        ivSms.setOnClickListener(this);
        tvSkip.setOnClickListener(this);

        final Animation messengerAnimation = AnimationUtils.loadAnimation(this, R.anim.zoom_in);
        final Animation smsAnimation = AnimationUtils.loadAnimation(this, R.anim.zoom_in);
        final Animation whatsAppAnimation = AnimationUtils.loadAnimation(this, R.anim.zoom_in);
        final Animation emailAnimation = AnimationUtils.loadAnimation(this, R.anim.zoom_in);

        messengerAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                CountDownTimer timer = new CountDownTimer(250, 1) {
                    @Override
                    public void onTick(long l) {

                    }

                    @Override
                    public void onFinish() {
                        ivSms.startAnimation(smsAnimation);
                    }
                };
                timer.start();
            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        smsAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                CountDownTimer timer = new CountDownTimer(250, 1) {
                    @Override
                    public void onTick(long l) {

                    }

                    @Override
                    public void onFinish() {
                        ivWhatsapp.startAnimation(whatsAppAnimation);
                    }
                };
                timer.start();
            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        whatsAppAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                CountDownTimer timer = new CountDownTimer(250, 1) {
                    @Override
                    public void onTick(long l) {

                    }

                    @Override
                    public void onFinish() {
                        ivEmail.startAnimation(emailAnimation);
                    }
                };
                timer.start();
            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        ivMessenger.startAnimation(messengerAnimation);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_messenger:{
                try {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    intent.setPackage("com.facebook.orca");
                    intent.putExtra(Intent.EXTRA_TEXT, "Hello World");
                    startActivity(intent);
                } catch (ActivityNotFoundException e){
                    e.printStackTrace();
                    Toast.makeText(this,"Messenger app not found!!!",Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case R.id.iv_sms:{
                try{
                    Intent intent = new Intent(Intent.ACTION_MAIN);
                    intent.addCategory(Intent.CATEGORY_APP_MESSAGING);
                    startActivity(intent);
                } catch (ActivityNotFoundException e){
                    e.printStackTrace();
                    Toast.makeText(this, "SMS app not found!!!",Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case R.id.iv_whatsapp:{
                try {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    intent.setPackage("com.whatsapp");
                    intent.putExtra(Intent.EXTRA_TEXT, "Hello World");
                    startActivity(intent);
                } catch (ActivityNotFoundException e){
                    e.printStackTrace();
                    Toast.makeText(this,"Whatsapp not found!!!",Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case R.id.iv_email:{
                try {
                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_EMAIL, "emailaddress@emailaddress.com");
                    intent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
                    intent.putExtra(Intent.EXTRA_TEXT, "I'm email body.");
                    startActivity(intent);
                } catch (ActivityNotFoundException e){
                    e.printStackTrace();
                    Toast.makeText(this,"Email app not found!!!",Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case R.id.tv_skip:{
                break;
            }
        }
    }
}
