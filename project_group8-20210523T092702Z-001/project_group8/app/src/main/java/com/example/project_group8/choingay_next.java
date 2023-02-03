package com.example.project_group8;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import java.io.Serializable;
import java.util.ArrayList;


public class choingay_next extends Activity {
    Button BT,BTDe,BTTb,BTKho,BtBack;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choingay_next);

        BTDe = (Button) findViewById(R.id.BtnDe);
        BTKho = (Button) findViewById(R.id.BtnKho);
        BTTb = (Button) findViewById(R.id.BtnTrungBinh);
        BtBack = (Button) findViewById(R.id.BtnBack);

        BTDe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(choingay_next.this, Quenstion_de.class);
                startActivity(intent);
                mediaPlayer.reset();
                mediaPlayer.stop();

            }
        });
        BTTb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(choingay_next.this, Quenstion_tb.class);
                startActivity(intent);
                mediaPlayer.reset();
                mediaPlayer.stop();
            }
        });

        BtBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(choingay_next.this, MainActivity.class);
                    startActivity(intent);
                    mediaPlayer.reset();
                    mediaPlayer.stop();
            }
        });


        BTKho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(choingay_next.this, Question_kho.class);
                startActivity(intent);
                mediaPlayer.reset();
                mediaPlayer.stop();
            }
        });
}

}
