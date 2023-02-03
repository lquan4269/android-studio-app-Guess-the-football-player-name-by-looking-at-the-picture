package com.example.project_group8;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import android.app.Activity;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class Quenstion_de extends  Activity{
    private static final long COUNTDOWN_IN_MILLIS = 30000;
    private ColorStateList textColorDefaultRb;
    private ColorStateList textColorDefaultCd;
    CountDownTimer countDownTimer;
    private long timeLeftInMillis;
    Button b_back,b_submit;
    RadioButton b_answer1, b_answer2,b_answer3,b_answer4;
    ImageButton btnplaysong;
    ImageView iv_player;
    List<StateModel> list;
    TextView textViewCountDown;
    Random r ;
    int turn =1;
    int rightAnswers=0;

    MediaPlayer mediaPlayer;



    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.de);
        r = new Random();
        iv_player =(ImageView) findViewById(R.id.iv_player);
        textViewCountDown= (TextView) findViewById(R.id.textViewTime);
        b_answer1 = (RadioButton) findViewById(R.id.RdbA);
        b_answer2 = (RadioButton) findViewById(R.id.RdbB);
        b_answer3 = (RadioButton) findViewById(R.id.RdbC);
        b_answer4 = (RadioButton) findViewById(R.id.RdbD);
        b_back = (Button) findViewById(R.id.BtnGameBack);
        btnplaysong=(ImageButton) findViewById((R.id.imgbtnPlay));
        b_submit = (Button) findViewById(R.id.Btnsubmit);
        textColorDefaultCd = textViewCountDown.getTextColors();


        list = new ArrayList<>();

        for(int i=0; i< new Database_de().answers.length;i++){
            list.add(new StateModel(new Database_de().answers[i],new Database_de().player[i]));
            Collections.shuffle(list);
            timeLeftInMillis=COUNTDOWN_IN_MILLIS;
            startCountDown();
        }
        newQuestion(turn);



        mediaPlayer = MediaPlayer.create(Quenstion_de.this, R.raw.edm2);
        mediaPlayer.start();
        mediaPlayer.setLooping(false);



        b_answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(b_answer1.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){
                    rightAnswers = rightAnswers +1;
                    Toast.makeText(Quenstion_de.this,"Đúng",Toast.LENGTH_SHORT).show();
                    turn++;
                    newQuestion(turn);
                    if(turn<list.size()){
                        turn++;
                        newQuestion(turn);
                        countDownTimer.start();
                    }
                }else{
                    Toast.makeText(Quenstion_de.this,"SAI",Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(Quenstion_de.this,"Đúng",Toast.LENGTH_SHORT).show();
                    turn++;
                    newQuestion(turn);
                    if(turn<list.size()){
                        turn++;
                        newQuestion(turn);
                    }
                }else{
                    Toast.makeText(Quenstion_de.this,"SAI",Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(Quenstion_de.this,"Đúng",Toast.LENGTH_SHORT).show();
                    turn++;
                    newQuestion(turn);
                    if(turn<list.size()){
                        turn++;
                        newQuestion(turn);
                    }
                }else{
                    Toast.makeText(Quenstion_de.this,"SAI",Toast.LENGTH_SHORT).show();
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
        b_answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b_answer4.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){
                    rightAnswers = rightAnswers +1;
                    Toast.makeText(Quenstion_de.this,"Đúng",Toast.LENGTH_SHORT).show();
                    turn++;
                    newQuestion(turn);

                    if(turn<list.size()){
                        turn++;
                        newQuestion(turn);
                    }
                }else{
                    Toast.makeText(Quenstion_de.this,"SAI",Toast.LENGTH_SHORT).show();
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
                Intent intent = new Intent(Quenstion_de.this,activity_result.class);
                startActivity(intent);
                countDownTimer.cancel();
                getResults();
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.reset();
                    mediaPlayer.stop();
                }
            }
        });
        b_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Quenstion_de.this, choingay_next.class);
                startActivity(intent);
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.reset();
                    mediaPlayer.stop();
                }
            }
        });

    }
    private void startCountDown(){
        countDownTimer = new CountDownTimer(timeLeftInMillis,1000){
            @Override
            public void onTick(long millisUntilFinished){
                timeLeftInMillis=millisUntilFinished;
                updateCountDownText();

            }
            @Override
            public void onFinish(){
                timeLeftInMillis=0;
                updateCountDownText();
                countDownTimer.start();
                newQuestion(turn);
            }
        }.start();
    }

    private void updateCountDownText(){
        int minutes=(int)(timeLeftInMillis/1000)/60;
        int seconds = (int)(timeLeftInMillis/1000)%60;
        String timeFormatted = String.format(Locale.getDefault(),"%02d:%02d",minutes,seconds);
        textViewCountDown.setText(timeFormatted);
        if (timeLeftInMillis<10000){
            textViewCountDown.setTextColor(Color.RED);
        }else{
            textViewCountDown.setTextColor(Color.GREEN);
        }
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        if(countDownTimer!=null){
            countDownTimer.start();
        }
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



    public void getResults () {
        Intent intent = new Intent(getApplicationContext(),activity_result.class);
        intent.putExtra("rightAnswers",rightAnswers);
        startActivity(intent);
    }
    }

