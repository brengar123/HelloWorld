package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        int position = intent.getIntExtra(MainActivity.EXTRA_MESSAGE, 0);

        FragmentManager myManager = getSupportFragmentManager();
        FragmentTransaction myTransaction = myManager.beginTransaction();
        Fragment myFragment = new DetailFragment();
        Bundle arguments = new Bundle();
        arguments.putInt("POSITION", position);
        myFragment.setArguments(arguments);
        myTransaction.replace(R.id.scrollView2, myFragment);
        myTransaction.commit();
    }
}