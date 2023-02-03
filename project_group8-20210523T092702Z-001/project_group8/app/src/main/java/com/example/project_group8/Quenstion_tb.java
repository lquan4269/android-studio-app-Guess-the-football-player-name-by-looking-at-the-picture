package com.example.project_group8;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class Quenstion_tb extends  Activity{
    Button b_answer1, b_answer2,b_answer3,b_answer4,b_back,b_submit;
    ImageView iv_player;
    List<StateModel> list;
    Random r ;
    int turn =1;
    int rightAnswers=0;
    TextView textView;
    public int counter= 500;
    MediaPlayer mediaPlayer;

    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.de);
        r = new Random();
        iv_player =(ImageView) findViewById(R.id.iv_player);
        textView= (TextView) findViewById(R.id.textViewTime);
        b_answer1 = (Button) findViewById(R.id.RdbA);
        b_answer2 = (Button) findViewById(R.id.RdbB);
        b_answer3 = (Button) findViewById(R.id.RdbC);
        b_answer4 = (Button) findViewById(R.id.RdbD);
        b_back = (Button) findViewById(R.id.BtnGameBack);
        b_submit=(Button) findViewById((R.id.Btnsubmit));

        list = new ArrayList<>();

        for(int i=0; i< new Database_tb().answers.length;i++){
            list.add(new StateModel(new Database_tb().answers[i],new Database_tb().player[i]));
            Collections.shuffle(list);
        }
        newQuestion(turn);
        new CountDownTimer(30000, 1000){
            public void onTick(long millisUntilFinished){
                textView.setText("Thời gian còn lại là : " + String.valueOf(counter));
                counter--;
            }
            public  void onFinish(){
                getResults();
            }
        }.start();

        mediaPlayer = MediaPlayer.create(Quenstion_tb.this, R.raw.edm3);
        mediaPlayer.start();
        mediaPlayer.setLooping(false);

        b_answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b_answer1.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){
                    rightAnswers = rightAnswers +1;
                    Toast.makeText(Quenstion_tb.this,"Đúng",Toast.LENGTH_SHORT).show();
                    turn++;
                    newQuestion(turn);
                    if(turn<list.size()){
                        turn++;
                        newQuestion(turn);
                    }
                }else{
                    Toast.makeText(Quenstion_tb.this,"SAI",Toast.LENGTH_SHORT).show();
                    turn++;
                    newQuestion(turn);
                }
                if(turn<list.size()){
                    turn++;
                    newQuestion(turn);
                }
                if(turn==list.size()){
                    b_submit.setVisibility(View.VISIBLE);
                    mediaPlayer.reset();
                    mediaPlayer.stop();
                    getResults();
                }
            }
        });
        b_answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b_answer2.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){
                    rightAnswers = rightAnswers +1;
                    Toast.makeText(Quenstion_tb.this,"Đúng",Toast.LENGTH_SHORT).show();
                    turn++;
                    newQuestion(turn);
                    if(turn<list.size()){
                        turn++;
                        newQuestion(turn);
                    }
                }else{
                    Toast.makeText(Quenstion_tb.this,"SAI",Toast.LENGTH_SHORT).show();
                    turn++;
                    newQuestion(turn);
                }
                if(turn<list.size()){
                    turn++;
                    newQuestion(turn);
                }
                if(turn==list.size()){
                    b_submit.setVisibility(View.VISIBLE);
                    mediaPlayer.reset();
                    mediaPlayer.stop();
                    getResults();
                }
            }
        });
        b_answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b_answer3.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){
                    rightAnswers = rightAnswers +1;
                    Toast.makeText(Quenstion_tb.this,"Đúng",Toast.LENGTH_SHORT).show();
                    turn++;
                    newQuestion(turn);
                    if(turn<list.size()){
                        turn++;
                        newQuestion(turn);
                    }
                }
                if(turn<list.size()){
                    turn++;
                    newQuestion(turn);
                }
                if(turn==list.size()){
                    b_submit.setVisibility(View.VISIBLE);
                    mediaPlayer.reset();
                    mediaPlayer.stop();
                    getResults();
                }
            }
        });
        b_answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(b_answer4.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){
                    rightAnswers = rightAnswers +1;
                    Toast.makeText(Quenstion_tb.this,"Đúng",Toast.LENGTH_SHORT).show();
                    turn++;
                    newQuestion(turn);
                    if(turn<list.size()){
                        turn++;
                        newQuestion(turn);
                    }
                }else{
                    Toast.makeText(Quenstion_tb.this,"SAI",Toast.LENGTH_SHORT).show();
                    turn++;
                    newQuestion(turn);
                }
                if(turn<list.size()){
                    turn++;
                    newQuestion(turn);
                }
                if(turn==list.size()){
                    b_submit.setVisibility(View.VISIBLE);
                    mediaPlayer.reset();
                    mediaPlayer.stop();
                    getResults();
                }
            }
        });
        b_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Quenstion_tb.this,activity_result.class);
                startActivity(intent);
                mediaPlayer.reset();
                mediaPlayer.stop();
                getResults();
                }
        });
        b_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Quenstion_tb.this, choingay_next.class);
                startActivity(intent);
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
            }
        });
    }
    private void newQuestion(int number){
        iv_player.setImageResource(list.get(number-1).getImage());
        int correct_answer = r.nextInt(4)+1;
        int firstButton = number -1;
        int secondButton;
        int thirdButton;
        int fourthButton;
        switch(correct_answer){
            case 1:
                b_answer1.setText(list.get(firstButton).getName());
                do{
                    secondButton = r.nextInt(list.size());
                }while (secondButton == firstButton);
                do{
                    thirdButton = r.nextInt(list.size());
                }while(thirdButton == firstButton || thirdButton == secondButton);
                do {
                    fourthButton = r.nextInt(list.size());
                }while (fourthButton == firstButton || fourthButton == secondButton || fourthButton == thirdButton);
                b_answer2.setText(list.get(secondButton).getName());
                b_answer3.setText(list.get(thirdButton).getName());
                b_answer4.setText(list.get(fourthButton).getName());

                break;
            case 2:
                b_answer2.setText(list.get(firstButton).getName());
                do{
                    secondButton = r.nextInt(list.size());
                }while (secondButton == firstButton);
                do{
                    thirdButton = r.nextInt(list.size());
                }while(thirdButton == firstButton || thirdButton == secondButton);
                do {
                    fourthButton = r.nextInt(list.size());
                }while (fourthButton == firstButton || fourthButton == secondButton || fourthButton == thirdButton);
                b_answer1.setText(list.get(secondButton).getName());
                b_answer3.setText(list.get(thirdButton).getName());
                b_answer4.setText(list.get(fourthButton).getName());
                break;
            case 3:
                b_answer3.setText(list.get(firstButton).getName());
                do{
                    secondButton = r.nextInt(list.size());
                }while (secondButton == firstButton);
                do{
                    thirdButton = r.nextInt(list.size());
                }while(thirdButton == firstButton || thirdButton == secondButton);
                do {
                    fourthButton = r.nextInt(list.size());
                }while (fourthButton == firstButton || fourthButton == secondButton || fourthButton == thirdButton);
                b_answer2.setText(list.get(secondButton).getName());
                b_answer1.setText(list.get(thirdButton).getName());
                b_answer4.setText(list.get(fourthButton).getName());
                break;
            case 4:
                b_answer4.setText(list.get(firstButton).getName());
                do{
                    secondButton = r.nextInt(list.size());
                }while (secondButton == firstButton);
                do{
                    thirdButton = r.nextInt(list.size());
                }while(thirdButton == firstButton || thirdButton == secondButton);
                do {
                    fourthButton = r.nextInt(list.size());
                }while (fourthButton == firstButton || fourthButton == secondButton || fourthButton == thirdButton);
                b_answer2.setText(list.get(secondButton).getName());
                b_answer3.setText(list.get(thirdButton).getName());
                b_answer1.setText(list.get(fourthButton).getName());
                break;
        }
    }
    public  void getResults () {
        Intent intent = new Intent(getApplicationContext(),activity_result.class);
        intent.putExtra("rightAnswers",rightAnswers);
        startActivity(intent);
    }
}
