package com.example.helloworld;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    private TextView name;
    private TextView shortName;
    private TextView value;
    private TextView change1h;
    private TextView change24h;
    private TextView change7d;
    private TextView market;
    private TextView volume;
    private ImageView search;

    private static final String TAG = "DetailActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        int position = intent.getIntExtra(MainActivity.EXTRA_MESSAGE, 0);
        Coin coin = Coin.getCoins().get(position);

        name = findViewById(R.id.mName);
        shortName = findViewById(R.id.mSymbol);
        value = findViewById(R.id.textView10);
        change1h = findViewById(R.id.textView11);
        change24h = findViewById(R.id.textView12);
        change7d = findViewById(R.id.textView13);
        market = findViewById(R.id.textView14);
        volume = findViewById(R.id.textView15);
        search = findViewById(R.id.mSearch);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search();
            }
        });

        showCoin(coin);
    }

    private void showCoin(Coin coin) {
        name.setText(coin.getName());
        shortName.setText(coin.getSymbol());
        value.setText(String.valueOf(coin.getValue()));
        change1h.setText(String.valueOf(coin.getChange1h()));
        change24h.setText(String.valueOf(coin.getChange24h()));
        change7d.setText(String.valueOf(coin.getChange7d()));
        market.setText(String.valueOf(coin.getMarketcap()));
        volume.setText(String.valueOf(coin.getVolume()));
    }

    private void search() {
        String url = "https://www.google.com/";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}
