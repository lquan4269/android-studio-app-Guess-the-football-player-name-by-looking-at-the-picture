package com.example.project_group8;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class huongdan extends Activity {
    Button BtnHdBack;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.huongdan);
        BtnHdBack = (Button) findViewById(R.id.BtnHdBack);


        BtnHdBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(huongdan.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }}
