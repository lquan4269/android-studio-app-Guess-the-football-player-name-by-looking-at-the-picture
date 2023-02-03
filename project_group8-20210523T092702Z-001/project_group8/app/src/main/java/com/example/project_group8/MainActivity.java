package com.example.project_group8;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;



public class MainActivity extends Activity {

    Button BT1, BT2, BT3;
    ImageButton btnbacksong,btnplaysong,btnpausesong,btnnextsong,btnstopsong;
    TextView txtTittle;
    int pos = 0 ;   // position (vị trí thứ tự của nhạc)
    MediaPlayer mediaPlayer;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BT1 = (Button) findViewById(R.id.BtnPlay);
        BT2 = (Button) findViewById(R.id.BtnTutorial);
        BT3 = (Button) findViewById(R.id.BtnBack);

        btnplaysong = (ImageButton) findViewById(R.id.imgbtnPlay);
        btnstopsong=(ImageButton) findViewById(R.id.imgbtnStop);


        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.ale);
        mediaPlayer.start();
        mediaPlayer.setLooping(true);


        btnplaysong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer.isPlaying()){
                    // nếu đang chạy > click vào thì pause > button thành play
                    mediaPlayer.pause();
                    btnplaysong.setImageResource(R.drawable.play);
                } else {
                    mediaPlayer.start();
                    btnplaysong.setImageResource(R.drawable.pause);
                }
            }
        });
        btnstopsong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.reset();
                mediaPlayer.stop();
                btnplaysong.setImageResource(R.drawable.play);
            }
        });

        BT1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Sử dụng Intent để mở activity choingay
                Intent intent = new Intent(MainActivity.this, choingay_next.class);
                startActivity(intent);
            }
        });
        BT2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, huongdan.class);
                startActivity(intent);

            }
        });
        BT3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, login.class);
                startActivity(intent);
                mediaPlayer.reset();
                mediaPlayer.stop();
            }
        });
}

}

