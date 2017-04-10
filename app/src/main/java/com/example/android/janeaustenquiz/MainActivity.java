package com.example.android.janeaustenquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int scores = 0;
    // question1_MaxAnswers is max number of checked checkboxes: 3
    int question_1_MaxAnswers = 0;
    // question_1_Scores is the scores from answers to question #1
    int question_1_Scores = 0;
    // question5MaxAnswers is max number of checked checkboxes: 3
    int question_5_MaxAnswers = 0;
    // question_5_Scores is the scores from answers to question #5
    int question_5_Scores = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void scoreSummarize(View view) {

        // Checking the answers on question #1
        // Allows only three checked checkboxes, for not trying all answers
        // Right answer is worth of 3 scores for the 3 movies:
        // Mansfield park,Northanger Abbey, Love and Friendship

        CheckBox question_1_check1 = (CheckBox) findViewById(R.id.q1a1);
        CheckBox question_1_check2 = (CheckBox) findViewById(R.id.q1a2);
        CheckBox question_1_check3 = (CheckBox) findViewById(R.id.q1a3);
        CheckBox question_1_check4 = (CheckBox) findViewById(R.id.q1a4);
        CheckBox question_1_check5 = (CheckBox) findViewById(R.id.q1a5);
        CheckBox question_1_check6 = (CheckBox) findViewById(R.id.q1a6);
        CheckBox question_1_check7 = (CheckBox) findViewById(R.id.q1a7);

        if (question_1_check1.isChecked()) {
            question_1_MaxAnswers += 1;
        }
        if (question_1_check2.isChecked()) {
            question_1_MaxAnswers += 1;
            question_1_Scores += 1;
        }
        if (question_1_check3.isChecked()) {
            question_1_MaxAnswers += 1;
        }
        if (question_1_check4.isChecked()) {
            question_1_MaxAnswers += 1;
            question_1_Scores += 1;
        }
        if (question_1_check5.isChecked()) {
            question_1_MaxAnswers += 1;
        }
        if (question_1_check6.isChecked()) {
            question_1_MaxAnswers += 1;
        }
        if (question_1_check7.isChecked()) {
            question_1_MaxAnswers += 1;
            question_1_Scores += 1;
        }
        if (question_1_MaxAnswers > 3) {
            question_1_Scores = 0;
        }

        // Checking the answer on question #2
        // The right answer is Emma
        // Right answer is worth 4 scores for the 4 characters

        EditText textQuestionTwo = (EditText) findViewById(R.id.emma);
        if (textQuestionTwo.getText().toString().equals(getString(R.string.q2answer))) {
            scores += 4;
        }

        // Checking the answers on question #3
        // There is only one right answer, Mr. Darcy : radiobutton #2
        // Right answer is worth 4 scores for the 4 movies

        RadioButton radioButton_q3a2 = (RadioButton) findViewById(R.id.q3a2);
        if (radioButton_q3a2.isChecked()) {
            scores += 4;
        }

        // Checking the answers on question #4
        // The right answer is Austenland radiobutton #5
        // Right answer is worth of 10 scores for the difficult question

        RadioButton radioButton_q4a5 = (RadioButton) findViewById(R.id.q4a5);
        if (radioButton_q4a5.isChecked()) {
            scores += 10;
        }

        // Checking the answers on question #5
        // question_5_Scores is current score of the player
        // question5MaxAnswers is number of checked checkboxes: max 3
        // Allows only three checked checkboxes, for not trying all answers
        // Total scores: 9

        CheckBox question_5_check1 = (CheckBox) findViewById(R.id.q5a1);
        CheckBox question_5_check2 = (CheckBox) findViewById(R.id.q5a2);
        CheckBox question_5_check3 = (CheckBox) findViewById(R.id.q5a3);
        CheckBox question_5_check4 = (CheckBox) findViewById(R.id.q5a4);
        CheckBox question_5_check5 = (CheckBox) findViewById(R.id.q5a5);

        if (question_5_check1.isChecked()) {
            question_5_MaxAnswers += 1;
            question_5_Scores += 2;
        }
        if (question_5_check2.isChecked()) {
            question_5_MaxAnswers += 1;
        }
        if (question_5_check3.isChecked()) {
            question_5_MaxAnswers += 1;
            question_5_Scores += 4;
        }
        if (question_5_check4.isChecked()) {
            question_5_MaxAnswers += 1;
        }
        if (question_5_check5.isChecked()) {
            question_5_MaxAnswers += 1;
            question_5_Scores += 3;
        }

        if (question_5_MaxAnswers > 3) {
            question_5_Scores = 0;
        }

        // Checking the answers on question #6
        // The right answer is 2: radioButton #2
        // Right answer is worth of 2 scores for two oscars:
        // Emma: music, Sense and Sensibility: screenplay adaptation of the novel

        RadioButton radioButton_q6a3 = (RadioButton) findViewById(R.id.q6a3);
        if (radioButton_q6a3.isChecked()) {
            scores += 2;
        }

        // Summary of scores after the six questions:
        scores = scores + question_1_Scores + question_5_Scores;

        if (scores < 21) {
            Toast.makeText(getApplicationContext(), "Your scores: " + scores + " out of 32.\nTry again?", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "Your scores: " + scores + " out of 32!\nCongratulations!", Toast.LENGTH_LONG).show();
        }
        // Resets the scores to zero without beginning new game

        question_1_MaxAnswers = 0;
        question_1_Scores = 0;
        question_5_MaxAnswers = 0;
        question_5_Scores = 0;
        scores = 0;

    }

    // Begins new game and resets scores to zero.

    public void newGame(View v) {
        question_1_MaxAnswers = 0;
        question_1_Scores = 0;
        question_5_MaxAnswers = 0;
        question_5_Scores = 0;
        scores = 0;
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}
