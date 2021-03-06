package com.example.helloworld;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.helloworld.Entities.Coin;
import com.example.helloworld.Entities.CoinLoreResponse;
import com.google.gson.Gson;

import java.util.List;

import static com.example.helloworld.Entities.CoinLoreResponse.json;

public class DetailFragment extends Fragment {
    private TextView name;
    private TextView shortName;
    private TextView value;
    private TextView change1h;
    private TextView change24h;
    private TextView change7d;
    private TextView market;
    private TextView volume;
    private ImageView search;

    public DetailFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_detail, container, false);
        Bundle arguments = getArguments();
        int position = arguments.getInt("POSITION");

        Gson gson = new Gson();
        CoinLoreResponse response = gson.fromJson(json, CoinLoreResponse.class);
        List<Coin> coins = response.getData();
        final Coin mCoin = coins.get(position);

        name = v.findViewById(R.id.mName);
        shortName = v.findViewById(R.id.mSymbol);
        value = v.findViewById(R.id.textView10);
        change1h = v.findViewById(R.id.textView11);
        change24h = v.findViewById(R.id.textView12);
        change7d = v.findViewById(R.id.textView13);
        market = v.findViewById(R.id.textView14);
        volume = v.findViewById(R.id.textView15);
        search = v.findViewById(R.id.mSearch);

        name.setText(mCoin.getName());
        shortName.setText(mCoin.getSymbol());
        value.setText("$" + mCoin.getPriceUsd());
        change1h.setText(mCoin.getPercentChange1h() + "%");
        change24h.setText(mCoin.getPercentChange24h() + "$");
        change7d.setText(mCoin.getPercentChange7d() + "$");
        market.setText("$" + String.format("%,.2f", Double.parseDouble(mCoin.getMarketCapUsd())));
        volume.setText("$" + String.format("%,.2f", mCoin.getVolume24()));

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

        return v;
    }

    private void search() {
        String url = "https://www.google.com/";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}
