package com.example.helloworld;

import com.example.helloworld.Entities.Coin;
import com.example.helloworld.Entities.CoinLoreResponse;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

import com.google.gson.Gson;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "au.edu.unsw.infs3634.beers.MESSAGE";
    private boolean wideMode;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.rvList);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        Gson gson = new Gson();
        CoinLoreResponse response = gson.fromJson(CoinLoreResponse.json, CoinLoreResponse.class);
        List<Coin> coins = response.getData();
        wideMode = setWideMode();

        CoinAdapter.RecyclerViewClickListener listener = new CoinAdapter.RecyclerViewClickListener() {
        @Override
                public void onClick(View view, int position){
            if (wideMode) {
                FragmentManager myManager = getSupportFragmentManager();
                FragmentTransaction myTransaction = myManager.beginTransaction();
                Fragment myFragment = new DetailFragment();
                Bundle arguments = new Bundle();
                arguments.putInt("POSITION", position);
                myFragment.setArguments(arguments);
                myTransaction.replace(R.id.detailContainer, myFragment);
                myTransaction.commit();
            }
            else {
                launchDetailActivity(position);
            }
        }
        };
        mAdapter = new CoinAdapter(this, coins, listener);
        mRecyclerView.setAdapter(mAdapter);
    }

    private boolean setWideMode() {
        if(findViewById(R.id.detailContainer) == null) {
            return false;
        }
        else {
            return true;
        }
    }
    private void launchDetailActivity(int message){
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

}
