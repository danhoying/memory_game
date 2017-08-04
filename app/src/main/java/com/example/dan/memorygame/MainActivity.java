package com.example.dan.memorygame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // for our high score
    SharedPreferences prefs;
    String dataName = "MyData";
    String intName = "MyString";
    int defaultInt = 0;
    public static int hiScore; // Both activities can see this

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefs = getSharedPreferences(dataName, MODE_PRIVATE);
        hiScore = prefs.getInt(intName, defaultInt);

        // Make a reference to the Hi Score textview in the layout
        TextView textHiScore = (TextView) findViewById(R.id.textHiScore);
        textHiScore.setText("Hi Score: " + hiScore);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(this, GameActivity.class);
        startActivity(i);
    }
}
