package com.example.mkhalid.quizapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.content.Intent;
import android.widget.EditText;
import android.text.Editable;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    int correctAnswers = 0;
    int incorrectAnswers = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onQ1Clicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        // Correct answer is Steve Rogers
        if (checked && view.getId() == R.id.q1_choice1) {
            correctAnswers++;
        }
        else {
            incorrectAnswers++;
        }
    }
    public void onQ2Clicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        // Correct answer is Dr. Abraham Erskine
        if (checked && view.getId() == R.id.q2_choice3) {
            correctAnswers++;
        }
        else {
            incorrectAnswers++;
        }
    }
    public void onQ3Clicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        // Correct answer is 2 Tons
        if (checked && view.getId() == R.id.q3_choice3) {
            correctAnswers++;
        }
        else {
            incorrectAnswers++;
        }
    }
    public void onQ4Clicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        // Correct answer is James 'Bucky' Barnes
        if (checked && view.getId() == R.id.q4_choice2) {
            correctAnswers++;
        }
        else {
            incorrectAnswers++;
        }
    }

    public void submitAnswers(View view) {
        Intent intent = new Intent(this, Answers.class);
        String message = "";
        EditText playerName = (EditText)findViewById(R.id.player);
        Editable player = playerName.getText();
        String thePlayer = player.toString();

        if (correctAnswers == 4) {
            message = "Congrats " + thePlayer + "!" + " You got " + correctAnswers + " out of 4 Correct!\n";
        }
        else if (correctAnswers == 0) {
            message = thePlayer + ", you didn't even try!";
        }
        else {
            message = "Sorry " + thePlayer + ", you only got " + correctAnswers + " correct. Please try again";
        }
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivity(intent);

    }

    public void resetQuestions(View view) {
        correctAnswers = 0;
        incorrectAnswers = 0;
        setContentView(R.layout.activity_main);
    }


}
