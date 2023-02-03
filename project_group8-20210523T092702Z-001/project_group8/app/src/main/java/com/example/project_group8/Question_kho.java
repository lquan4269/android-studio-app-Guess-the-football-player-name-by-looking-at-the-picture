package com.example.project_group8;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Question_kho extends Activity {

    ImageView iv_player;
    List<StateModel> list;
    Random r;
    int turn = 0;
    int rightAnswers = 0;
    Button butNext,b_Back,b_submit;
    EditText edt;
    TextView textView;
    public int counter= 800;
    MediaPlayer mediaPlayer;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.kho);
        r = new Random();
        textView= (TextView) findViewById(R.id.textViewTime);
        iv_player = (ImageView) findViewById(R.id.iv_player);
        butNext = (Button) findViewById(R.id.BtnNext);
        b_Back = (Button) findViewById(R.id.BtnGameBack);
        edt = (EditText) findViewById(R.id.editText);
        b_submit=(Button) findViewById(R.id.Btnsubmit);



        list = new ArrayList<>();
        for(int i=0; i< new Database_kho().answers.length;i++){
            list.add(new StateModel(new Database_kho().answers[i],new Database_kho().player[i]));
            Collections.shuffle(list);
        }
        //list = list.subList(0, new Database_kho().answers.length/4 - 1);
        new CountDownTimer(30000, 1000){
            public void onTick(long millisUntilFinished){
                textView.setText("Thời gian còn lại là : " + String.valueOf(counter));
                counter--;
            }
            public  void onFinish(){
                getResults();
            }
        }.start();

        mediaPlayer = MediaPlayer.create(Question_kho.this, R.raw.edm);
        mediaPlayer.start();
        mediaPlayer.setLooping(false);

        iv_player.setImageResource(list.get(turn).getImage());

        b_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Question_kho.this, choingay_next.class);
                startActivity(intent);
            }
        });

        //newQuestion(turn);
        butNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (edt.getText().toString().equalsIgnoreCase(list.get(turn).getName())) {
                    Toast.makeText(Question_kho.this,"Right",Toast.LENGTH_SHORT).show();
                    rightAnswers += 1;
                } else {
                    Toast.makeText(Question_kho.this,"Wrong",Toast.LENGTH_SHORT).show();
                }
                turn += 1;

                if (turn == list.size()) {
                    mediaPlayer.reset();
                    mediaPlayer.stop();
                    getResults();
                }
                iv_player.setImageResource(list.get(turn).getImage());
                edt.setText("");
            }
                });//butNext



    }//onCreate

    public  void getResults () {
        Intent intent = new Intent(getApplicationContext(),activity_result.class);
        intent.putExtra("rightAnswers",rightAnswers);
        startActivity(intent);
    }


}//Question_kho
