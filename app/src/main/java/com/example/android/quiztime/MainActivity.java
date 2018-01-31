package com.example.android.quiztime;

import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int scoreCount = 0;
    int answers = 0;

    //QUESTIONS
    RadioGroup question1;
    RadioGroup question2;
    RadioGroup question3;
    RadioGroup question4;
    RadioGroup question5;

    //ANSWERS (NO PEEKING)
    int chosenAnswer1;
    int chosenAnswer2;
    int chosenAnswer3;
    int chosenAnswer4;
    int chosenAnswer5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        question1 = (RadioGroup) findViewById(R.id.question_1);
        question2 = (RadioGroup) findViewById(R.id.question_2);
        question3 = (RadioGroup) findViewById(R.id.question_3);
        question4 = (RadioGroup) findViewById(R.id.question_4);
        question5 = (RadioGroup) findViewById(R.id.question_5);
    }

    //Displaying score comment
    public void displayComment(String comment) {
        TextView scoreComment = (TextView) findViewById(R.id.score_comment);
        scoreComment.setText(String.valueOf(comment));
    }

    private void chosenVScorrect() {

        //Question 1
        chosenAnswer1 = question1.getCheckedRadioButtonId();
        if (chosenAnswer1 == -1) {
        } else {
            View radioButton1 = question1.findViewById(chosenAnswer1);
            if (radioButton1.getId() == R.id.answer_1) {
                scoreCount ++;
            }
        }

        //Question 2
        chosenAnswer2 = question2.getCheckedRadioButtonId();
        if (chosenAnswer2 == -1) {
        } else {
            View radioButton2 = question2.findViewById(chosenAnswer2);
            if (radioButton2.getId() == R.id.answer_2) {
                scoreCount++;
            }
        }

        //Question 3
        chosenAnswer3 = question3.getCheckedRadioButtonId();
        if (chosenAnswer2 == -1) {
        } else {
            View radioButton2 = question3.findViewById(chosenAnswer3);
            if (radioButton2.getId() == R.id.answer_3) {
                scoreCount++;
            }
        }

        //Question 4
        chosenAnswer4 = question4.getCheckedRadioButtonId();
        if (chosenAnswer4 == -1) {
        } else {
            View radioButton4 = question4.findViewById(chosenAnswer4);
            if (radioButton4.getId() == R.id.answer_4) {
                scoreCount++;
            }
        }

        //Question 5
        chosenAnswer5 = question5.getCheckedRadioButtonId();
        if (chosenAnswer4 == -1) {
        } else {
            View radioButton4 = question5.findViewById(chosenAnswer5);
            if (radioButton4.getId() == R.id.answer_5) {
                scoreCount++;
            }
        }
    }

    public void answerChecker() {
        chosenVScorrect();

        //For question 1
        if (chosenAnswer1 != -1) {
            answers++;
        }

        //For question 2
        if (chosenAnswer2 != -1) {
            answers++;
        }

        //For question 3
        if (chosenAnswer3 != -1) {
            answers++;
        }

        //For question 4
        if (chosenAnswer4 != -1) {
            answers++;
        }

        //For question 5
        if (chosenAnswer5 != -1) {
            answers++;
        }
    }

    public void finalScore(View v) {

        //To prevent scores and answers from updating
        scoreCount = 0;
        answers = 0;
        answerChecker();

        //What toast appears and displaying total score
        if (scoreCount == 5) {
            Toast.makeText(this, getString(R.string.succeed) + scoreCount + "!", Toast.LENGTH_LONG).show();
            scoreComments();
        } else {
            Toast.makeText(this, getString(R.string.score) + scoreCount + "! " + getString(R.string.again), Toast.LENGTH_SHORT).show();
            scoreComments();
        }
    }

    public void scoreComments() {

        //Score Comment for 0 correct answers
        if (scoreCount == 0) {
            String comment = getString(R.string.zero);
            displayComment(comment);
        }

        //Score Comment for 1-2 correct answers
        if (scoreCount == 1 | scoreCount == 2) {
            String comment = getString(R.string.one_two);
            displayComment(comment);
        }

        //Score Comment for 3-4 correct answers
        if (scoreCount == 3 | scoreCount == 4) {
            String comment = getString(R.string.three_four);
            displayComment(comment);
        }

        //Score Comment for 5 correct answers
        if (scoreCount == 5) {
            String comment = getString(R.string.full_score);
            displayComment(comment);
        }
    }

    public void reset(View v) {

        //RESET
        scoreCount = 0;
        answers = 0;
        question1.clearCheck();
        question2.clearCheck();
        question3.clearCheck();
        question4.clearCheck();
        question5.clearCheck();
        String comment = "";
        displayComment(comment);
    }
}