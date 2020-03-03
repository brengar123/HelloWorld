package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.net.Uri;

public class ActivityNEW extends AppCompatActivity {
    private TextView mDetailMessage;
    private Button mShowVideoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        mDetailMessage = findViewById(R.id.textView);
        mDetailMessage.setText(message);

        mShowVideoButton = findViewById(R.id.youtube);
        mShowVideoButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                showVideo("https://www.youtube.com/watch?v=3ymwOvzhwHs");
            }
        });
    }
private void showVideo(String url) {
    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
    startActivity(intent);
        }

}
