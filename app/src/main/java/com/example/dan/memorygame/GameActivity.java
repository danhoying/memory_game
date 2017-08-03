package com.example.dan.memorygame;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextClock;
import android.widget.TextView;

import java.io.IOException;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    // initialize sound variables
    private SoundPool soundPool;
    int sample1 = -1;
    int sample2 = -1;
    int sample3 = -1;
    int sample4 = -1;

    // for the UI
    TextView textScore;
    TextView textDifficulty;
    TextView textWatchGo;

    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button buttonReplay;

    // Some variables for the thread
    int difficultyLevel = 3;
    // An array to hold the randomly generated sequence
    int[] sequenceToCopy = new int[100];

    private Handler myHandler;
    // Is a sequence playing at the moment?
    boolean playSequence = false;
    // And which element of the sequence are we on?
    int elementToPlay = 0;

    // For checking player's answer
    int playerResponses;
    int playerScore;
    boolean isResponding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        try {
            // Create objects of the 2 required classes
            AssetManager assetManager = getAssets();
            AssetFileDescriptor descriptor;

            // create our four fx in memory for use
            descriptor = assetManager.openFd("sample1.ogg");
            sample1 = soundPool.load(descriptor, 0);

            descriptor = assetManager.openFd("sample2.ogg");
            sample2 = soundPool.load(descriptor, 0);

            descriptor = assetManager.openFd("sample3.ogg");
            sample3 = soundPool.load(descriptor, 0);

            descriptor = assetManager.openFd("sample4.ogg");
            sample4 = soundPool.load(descriptor, 0);
        } catch (IOException e) {
            // catch exceptions
        }

        // Reference all the elements of the UI
        textScore = (TextView) findViewById(R.id.textScore);
        textScore.setText("Score: " + playerScore);
        textDifficulty = (TextView) findViewById(R.id.textDifficulty);
        textDifficulty.setText("Level " + difficultyLevel);

        button1 = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);
        buttonReplay = (Button)findViewById(R.id.buttonReplay);

        // Now set all the buttons to listen for clicks
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        buttonReplay.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}
