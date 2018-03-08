package com.example.android.quizproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Method pulled from Submit Button
    public void onSubmit(View view) {
        // Declaration of error boolean
        boolean errorOccured=false;

        // Declaration for running total of correct answers
        float correctAnswer = 0;

        // Declare final score which could either be a whole number or fractional
        float finalScore = 0;

        // Setting up question one EditText
        EditText et = findViewById(R.id.question_one);

        // Setting up all radiogroups 2 through 9
        RadioGroup mRadioGroupQ2 = findViewById(R.id.radio_group_two);
        RadioGroup mRadioGroupQ3 = findViewById(R.id.radio_group_three);
        RadioGroup mRadioGroupQ4 = findViewById(R.id.radio_group_four);
        RadioGroup mRadioGroupQ5 = findViewById(R.id.radio_group_five);
        RadioGroup mRadioGroupQ6 = findViewById(R.id.radio_group_six);
        RadioGroup mRadioGroupQ7 = findViewById(R.id.radio_group_seven);
        RadioGroup mRadioGroupQ8 = findViewById(R.id.radio_group_eight);
        RadioGroup mRadioGroupQ9 = findViewById(R.id.radio_group_nine);

        // Setting up the 4 checkboxes for question 10
        CheckBox cb1 = findViewById(R.id.checkbox_one);
        CheckBox cb2 = findViewById(R.id.checkbox_two);
        CheckBox cb3 = findViewById(R.id.checkbox_three);
        CheckBox cb4 = findViewById(R.id.checkbox_four);

        // Testing answer for question one
        if (et.getText().toString().equalsIgnoreCase("pointer")) {
            correctAnswer++;
        } else if (et.getText().toString().equalsIgnoreCase("pointers")) {
            correctAnswer++;
        }

        // calling the pChoice method to get the player's choice
        String Q2Answer = pChoice(mRadioGroupQ2);

        // Test if player's choice is correct and update the correctAnswer variable
        if (Q2Answer.equals("Cross Platform Independent")) {
            correctAnswer++;
        }

        // calling the pChoice method to get the player's choice
        String Q3Answer = pChoice(mRadioGroupQ3);

        // Test if player's choice is correct and update the correctAnswer variable
        if (Q3Answer.equals("HyperText Markup Language")) {
            correctAnswer++;
        }

        // calling the pChoice method to get the player's choice
        String Q4Answer = pChoice(mRadioGroupQ4);

        // Test if player's choice is correct and update the correctAnswer variable
        if (Q4Answer.equals("<HTML>")) {
            correctAnswer++;
        }

        // calling the pChoice method to get the player's choice
        String Q5Answer = pChoice(mRadioGroupQ5);

        // Test if player's choice is correct and update the correctAnswer variable
        if (Q5Answer.equals("Dynamic Polymorphism")) {
            correctAnswer++;
        }

        // calling the pChoice method to get the player's choice
        String Q6Answer = pChoice(mRadioGroupQ6);

        // Test if player's choice is correct and update the correctAnswer variable
        if (Q6Answer.equals("Inheritance")) {
            correctAnswer++;
        }

        // calling the pChoice method to get the player's choice
        String Q7Answer = pChoice(mRadioGroupQ7);

        // Test if player's choice is correct and update the correctAnswer variable
        if (Q7Answer.equals("float")) {
            correctAnswer++;
        }

        // calling the pChoice method to get the player's choice
        String Q8Answer = pChoice(mRadioGroupQ8);

        // Test if player's choice is correct and update the correctAnswer variable
        if (Q8Answer.equals("It will store a fixed number of values")) {
            correctAnswer++;
        }

        // calling the pChoice method to get the player's choice
        String Q9Answer = pChoice(mRadioGroupQ9);

        // Test if player's choice is correct and update the correctAnswer variable
        if (Q9Answer.equals("True")) {
            correctAnswer++;
        }

        // Testing for question 10
        if (!cb2.isChecked()) {
            if (!cb3.isChecked()) {
                if (!cb4.isChecked()) {
                    if (cb1.isChecked()) {
                        correctAnswer++;
                    }
                }
            }
        }

        // Determing finalscore
        finalScore = correctAnswer / 10;
        finalScore = finalScore * 100;

        // Test if any errors were found
        if (errorOccured)
        {
            Toast.makeText(getApplicationContext(), "Error occurred, please verify all questions have been answered",
                    Toast.LENGTH_LONG).show();
        }
        else
        {
            // Outputting the final score
            String output = "Your quiz grade is: " + finalScore + "%";
            Toast.makeText(getApplicationContext(), output,
                    Toast.LENGTH_LONG).show();
        }

    }

    private String pChoice(RadioGroup radiogroup) {
        // declaring return RadioButton
        RadioButton whichButton;
        // get selected radio button from radioGroup
        int question2Answer = radiogroup.getCheckedRadioButtonId();
        // find the radiobutton by returned id
        whichButton = findViewById(question2Answer);

        // Returns the text of the selected button
        return whichButton.getText().toString();
    }
}
