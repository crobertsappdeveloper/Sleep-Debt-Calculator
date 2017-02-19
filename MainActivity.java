package com.example.android.sleepdebtcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /* Sets the global variables */
    int weekdaySleep; int weekendSleep; int totalSleep; int sleepDebt; int overSlept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayCalculation(View view) {
        /* Runs methods below that calculate the appropriate values and display them in the relevant textviews */
        displaySleepamount(createSleepamount());
        displaySleepdebt(createSleepdebt());
        displayOverslept(createOverslept());
    }

    private String createSleepamount() {
        /* Gets the content of the text box and converts it from a string to an integer */
        EditText textbox = (EditText) findViewById(R.id.weekday);
        String convert = textbox.getText().toString();

        /* Detects if there is a null value in the text box entered and informs the user then returns if this is the case */
        try{
            weekdaySleep = Integer.parseInt(convert);
        } catch (NumberFormatException pp1) {
            Toast.makeText(this, "You did not enter amount of hours", Toast.LENGTH_SHORT).show();
            weekdaySleep = 0; weekendSleep = 0; totalSleep = 0;
            return "Hours you actually sleep per week = 0";
        }

        /* Converts the String from the edit textbox into an integer numeric variable */
        weekdaySleep = Integer.parseInt(convert);

        /* Detects if the value entered in the edit textbox is 0 or below and informs the user then returns if this is the case */
        if (weekdaySleep <= 0) {
            Toast.makeText(this, "You need to enter a value higher than 0", Toast.LENGTH_SHORT).show();
            weekdaySleep = 0; weekendSleep = 0; totalSleep = 0;
            return "Hours you actually sleep per week = 0";
        }

        /* Detects if the value entered in the edit textbox is more than 24 hours and informs the user then returns if this is the case */
        if (weekdaySleep >= 25) {
            Toast.makeText(this, "You need to enter a value of 24 or less", Toast.LENGTH_SHORT).show();
            weekdaySleep = 0; weekendSleep = 0; totalSleep = 0;
            return "Hours you actually sleep per week = 0";
        }

        textbox = (EditText) findViewById(R.id.weekend);
        convert = textbox.getText().toString();

        try{
            weekendSleep = Integer.parseInt(convert);
        } catch (NumberFormatException pp1) {
            Toast.makeText(this, "You did not enter amount of hours", Toast.LENGTH_SHORT).show();
            weekdaySleep = 0; weekendSleep = 0; totalSleep = 0;
            return "Hours you actually sleep per week = 0";
        }

        weekendSleep = Integer.parseInt(convert);

        if (weekendSleep <= 0) {
            Toast.makeText(this, "You need to enter a value higher than 0", Toast.LENGTH_SHORT).show();
            weekdaySleep = 0; weekendSleep = 0; totalSleep = 0;
            return "Hours you actually sleep per week = 0";
        }

        if (weekendSleep >= 25) {
            Toast.makeText(this, "You need to enter a value of 24 or less", Toast.LENGTH_SHORT).show();
            weekdaySleep = 0; weekendSleep = 0; totalSleep = 0;
            return "Hours you actually sleep per week = 0";
        }

        /* Calculates the user's total amount of sleep per week based on values entered */
        totalSleep = (weekdaySleep * 5) + (weekendSleep * 2);

        /* Returns this value in the appropriate textview */
        return "Hours you actually sleep per week = " + totalSleep;
    }

    private String createSleepdebt () {
        /* Returns if the user did not enter any values or 0 to prevent errors */
        if (totalSleep <= 0) {
            return "Hours sleep debt you have = 0";
        }

        /* Calculates the sleep debt by subtracting amount of sleep from optimal hours 8 hours 7 days a week which is 56 */
        sleepDebt = 56 - totalSleep;

        /* If the amount of sleep debt is lower than or equal to 0 then a value of 0 is returned in the textview and the method ends */
        if (sleepDebt <= 0) {
            return "Hours sleep debt you have = 0";
        }

        /* Displays the amount of sleep debt in the appropriate textview */
        return "Hours sleep debt you have = " + sleepDebt;

    }

    private String createOverslept () {
        if (totalSleep <= 0) {
            return "Hours that you overslept = 0";
        }

        overSlept = totalSleep - 56;

        if (overSlept <= 0) {
            return "Hours that you overslept = 0";
        }

        return "Hours that you overslept = " + overSlept;
    }

    private void displaySleepamount(String message) {
        /* Method for displaying the appropriate text and value in the amount of hours slept textview*/
        TextView displayText = (TextView) findViewById(R.id.sleephours);
        displayText.setText(message);
    }
    private void displaySleepdebt(String message) {
        TextView displayText = (TextView) findViewById(R.id.sleepdebt);
        displayText.setText(message);
    }
    private void displayOverslept(String message) {
        TextView displayText = (TextView) findViewById(R.id.overslept);
        displayText.setText(message);
    }

    public void ResetValues(View view) {
        /* Clears the text boxes */
        EditText emptyText = (EditText) findViewById(R.id.weekday);
        emptyText.setText("");
        emptyText = (EditText) findViewById(R.id.weekend);
        emptyText.setText("");

        /* Clears the values of the global variables */
        weekdaySleep = 0; weekendSleep = 0; totalSleep = 0; sleepDebt = 0; overSlept = 0;

        /* Resets the textviews back to the values that they originally were */
        TextView textView = (TextView) findViewById(R.id.sleephours);
        textView.setText("Hours you actually sleep per week = 0");

        textView = (TextView) findViewById(R.id.sleepdebt);
        textView.setText("Hours sleep debt you have = 0");

        textView = (TextView) findViewById(R.id.overslept);
        textView.setText("Hours that you overslept = 0");
    }
}
