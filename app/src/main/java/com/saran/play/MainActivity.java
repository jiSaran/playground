package com.saran.play;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.saran.play.data.User;
import com.saran.play.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        User user = new User("Test", "User");
        binding.setUser(user);
        EventHandlers eventHandlers = new EventHandlers();
        binding.setHandler(eventHandlers);
    }
}
