package com.example.noone.buzzfeedquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    /* FOR TESTING PURPOSES
    public static void main(String[] args){

       Answers [][] x = Answers.getAnswers();
       Answers.printAnswers(x);

        Answers.printResults(Tie, Answers.total(Answers.parse(Questions.printQuestions(Questions.readQuestions(), System.in))));

    }
    */

    static boolean Tie = false;
    int i = 0;
    Questions [] display = Questions.getQuestions();
    Answers [][] choices = Answers.getAnswers();
    String [] result = new String [5];
    String message = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button A = findViewById(R.id.ChoiceA);
        Button B = findViewById(R.id.ChoiceB);
        Button C = findViewById(R.id.ChoiceC);
        Button D = findViewById(R.id.ChoiceD);

        TextView questDisplay = findViewById(R.id.Question);

        questDisplay.setText(Questions.printQuestions(display, i));

        A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i == 4){
                    result[i] = "a";
                    getResults();
                }

                else {
                    result[i] = "a";
                    i++;
                    updateActivity(i);
                }
            }
        });

        B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i == 4){
                    result[i] = "b";
                    getResults();
                }

                else {
                    result[i] = "b";
                    i++;
                    updateActivity(i);
                }
            }
        });

        C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i == 4){
                    result[i] = "c";
                    getResults();
                }

                else {
                    result[i] = "c";
                    i++;
                    updateActivity(i);
                }
            }
        });

        D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i == 4){
                    result[i] = "d";
                    getResults();
                }

                else {
                    result[i] = "d";
                    i++;
                    updateActivity(i);
                }
            }
        });

    }

    private void updateActivity (int currentChoice){

        Button A = findViewById(R.id.ChoiceA);
        Button B = findViewById(R.id.ChoiceB);
        Button C = findViewById(R.id.ChoiceC);
        Button D = findViewById(R.id.ChoiceD);

        TextView questDisplay = findViewById(R.id.Question);

        questDisplay.setText(Questions.printQuestions(display, currentChoice));
        A.setText(Answers.printAnswers(choices, currentChoice, 0));
        B.setText(Answers.printAnswers(choices, currentChoice, 1));
        C.setText(Answers.printAnswers(choices, currentChoice, 2));
        D.setText(Answers.printAnswers(choices, currentChoice, 3));
    }

    private void getResults (){
        message = Answers.getResults(Tie, Answers.total(Answers.parse(result)));
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

}
