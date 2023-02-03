package com.example.project_group8;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;

import java.util.ArrayList;


public class activity_result extends Activity {
    Button BtnHdBack;
    MediaPlayer mediaPlayer;
    TextView txtLose,txtWin;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);




        BtnHdBack = (Button) findViewById(R.id.BtnBack);
        TextView tv_result= (TextView) findViewById(R.id.tv_result);
        txtLose = (TextView) findViewById(R.id.txtLosse);
        txtWin = (TextView) findViewById(R.id.txtWinner);
        int score = getIntent().getIntExtra("rightAnswers", 0);
        tv_result.setText(score+" /20");

        if(score<=5){
            mediaPlayer = MediaPlayer.create(activity_result.this, R.raw.hahaha);
            mediaPlayer.start();
            mediaPlayer.setLooping(false);
            txtLose.setVisibility(View.VISIBLE);

        }else{
            mediaPlayer = MediaPlayer.create(activity_result.this, R.raw.success_sound);
            mediaPlayer.start();
            mediaPlayer.setLooping(false);
            txtWin.setVisibility(View.VISIBLE);
        }


        BtnHdBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_result.this, MainActivity.class);
                startActivity(intent);
                mediaPlayer.reset();
                mediaPlayer.stop();
            }
        });
    }

}