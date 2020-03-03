package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    public static final String EXTRA_MESSAGE = "au.edu.unsw.infs3634.beers.MESSAGE";
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate Called:");
        setContentView(R.layout.activity_main);

        mButton = findViewById(R.id.clickMe);
        mButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                launchDetailActivity("Hello from DetailActivity ***");
            }
        });


    }
    private void launchDetailActivity(String message){
        Intent intent = new Intent( this, ActivityNEW.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart Called");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume Called");
    }
}
