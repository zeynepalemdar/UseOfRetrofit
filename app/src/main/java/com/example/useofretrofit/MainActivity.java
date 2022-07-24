package com.example.useofretrofit;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.useofretrofit.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private viewModel viewModel;
    private ActivityMainBinding activityMainBinding;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());
        getAllUsersList();
    }

    public void getAllUsersList() {
        viewModel = new ViewModelProvider(this).get(viewModel.class);
        viewModel.getLiveData().observe(this, examples -> {
            if (examples != null) {
                LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
                activityMainBinding.rcl.setLayoutManager(layoutManager);
                adapter = new Adapter(examples, this);
                activityMainBinding.rcl.setAdapter(adapter);
            }
        });
    }
}