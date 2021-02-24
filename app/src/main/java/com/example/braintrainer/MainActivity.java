package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    Button goButton;
    int locationOfCorrectAnswer;
    int score=0;
    int numberOfQuestions = 0;
    TextView sumTextView;
    TextView resultTextView ;
    TextView scoreTextView;
    TextView timerTextView;
    Button button0 ;
    Button button1 ;
    Button button2 ;
    Button button3;
    Button playAgain;
    TextView textView2;
    ConstraintLayout gameLayout;
    ArrayList<Integer>  answers = new ArrayList<Integer>();
        public void start(View view){                 //after clicking
            goButton.setVisibility(View.INVISIBLE);
            playAgain(findViewById((R.id.timerTextView)));
            gameLayout.setVisibility(View.VISIBLE);


        }
        public  void playAgain(View view){
            score = 0;
            numberOfQuestions=0;

            timerTextView.setText("30s");
            resultTextView.setText("");
            textView2.setVisibility(View.INVISIBLE);

            newQuestion();
            playAgain.setVisibility(View.INVISIBLE);
            scoreTextView.setVisibility(View.VISIBLE);
            scoreTextView.setText(Integer.toString(score) + "/" + Integer.toString(numberOfQuestions));
            new CountDownTimer(10100,1000){

                @Override
                public void onTick(long l) {
                    timerTextView.setText(String.valueOf(l/1000)+ "s");
                }

                @Override
                public void onFinish() {
                    resultTextView.setText(Integer.toString(score) + " correct out of " + Integer.toString(numberOfQuestions));
                    playAgain.setVisibility(View.VISIBLE);
                    textView2.setVisibility(View.VISIBLE);
                    scoreTextView.setVisibility(View.INVISIBLE);

                }
            }.start();


        }
        public  void newQuestion(){

            Random rand = new Random();
            int a= rand.nextInt(21);
            int b= rand.nextInt(21);

            sumTextView.setText(Integer.toString(a) + " + " + Integer.toString(b));
            locationOfCorrectAnswer = rand.nextInt(4);
            answers.clear();
            for(int i =0;i<4;i++){
                if(i==locationOfCorrectAnswer){
                    answers.add(a+b);
                }
                else {
                    int wrongAnswer = rand.nextInt(41);
                    while (wrongAnswer == a + b)
                        wrongAnswer = rand.nextInt(41);


                    answers.add(wrongAnswer);
                }
            }
            button0.setText(Integer.toString(answers.get(0)));
            button1.setText(Integer.toString(answers.get(2)));
            button2.setText(Integer.toString(answers.get(1)));
            button3.setText(Integer.toString(answers.get(3)));


        }
        public void chooseAnswer(View view) {

            if (Integer.toString(locationOfCorrectAnswer).equals(view.getTag().toString())) {
             //   resultTextView.setText("CORRECT!!!");
                score++;
            } //else
                // resultTextView.setText("WRONG :(");
            numberOfQuestions++;
            scoreTextView.setText(Integer.toString(score) + "/" + Integer.toString(numberOfQuestions));
            newQuestion();
        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        goButton = findViewById(R.id.goButton);

         sumTextView = findViewById(R.id.sumTextView);
        resultTextView = findViewById(R.id.resultTextView);
        timerTextView = findViewById(R.id.timerTextView);
        scoreTextView = findViewById(R.id.scoreTextView);
         button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button2);
         button2 = findViewById(R.id.button1);
        button3 = findViewById(R.id.button3);
        playAgain = findViewById((R.id.playAgainButton));
        gameLayout = findViewById(R.id.gameLayout);
        textView2= findViewById(R.id.textView2);

        goButton.setVisibility(View.VISIBLE);
        gameLayout.setVisibility(View.INVISIBLE);

            }


    }
