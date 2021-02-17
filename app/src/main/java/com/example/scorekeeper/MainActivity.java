package com.example.scorekeeper;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.example.scorekeeper.model.Team;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private int counter = 0;

    // team a
    Team teamA;

    // team b
    Team teamB;

    // common functions
    // display a short toast message
    public void displayToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    // updates the score in the specific team text view
    public void displayScore(TextView textView, int score) {
        textView.setText(String.valueOf(score));
    }


    @Override
    protected void onStop() {
        super.onStop();
        ++counter;
        Log.d(TAG, counter + ". onStop() called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        ++counter;
        Log.d(TAG, counter + ". onPause() called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        ++counter;
        Log.d(TAG, counter + ". onResume() called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        ++counter;
        Log.d(TAG, counter + ". onStart() called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ++counter;
        Log.d(TAG, counter + ". onDestroy() called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        ++counter;
        Log.d(TAG, counter + ". onRestart() called");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ++counter;
        Log.d(TAG, counter + ". onCreate() called");

        // get buttons and text views
        // team a
        TextView scoreTeamATxtView = findViewById(R.id.TEAM_A_SCORE);
        Button teamAScore3Btn = findViewById(R.id.TEAM_A_SCORE_3_BTN);
        Button teamAFreeThrowBtn = findViewById(R.id.TEAM_A_FREE_THROW_BTN);

        // team b
        TextView scoreTeamBTxtView = findViewById(R.id.TEAM_B_SCORE);
        Button teamBScore3Btn = findViewById(R.id.TEAM_B_SCORE_3_BTN);
        Button teamBFreeThrowBtn = findViewById(R.id.TEAM_B_FREE_THROW_BTN);

        Button scoreResetBtn = findViewById(R.id.SCORE_RESET_BTN);

        // initialize team a and team b with their respective views
        teamA = new Team(scoreTeamATxtView, teamAScore3Btn, teamAFreeThrowBtn);
        teamB = new Team(scoreTeamBTxtView, teamBScore3Btn, teamBFreeThrowBtn);

        // restore previous state score data
        if (savedInstanceState != null) {
            teamA.setScore(savedInstanceState.getInt("teamAScore"));
            teamB.setScore(savedInstanceState.getInt("teamBScore"));

            // display the score
            displayScore(teamA.getScoreTxtView(), teamA.getScore());
            displayScore(teamB.getScoreTxtView(), teamB.getScore());
        }


        // add onClickListener
        // onClickListener for team a
        teamA.getScore3Btn().setOnClickListener(view -> {
            teamA.updateScore(3);
            displayScore(teamA.getScoreTxtView(), teamA.getScore());
        });

        teamA.getFreeThrowBtn().setOnClickListener(view -> displayToast(this, "This is a free throw"));

        // onClickListener for team b
        teamB.getScore3Btn().setOnClickListener(view -> {
            teamB.updateScore(3);
            displayScore(teamB.getScoreTxtView(), teamB.getScore());
        });

        teamB.getFreeThrowBtn().setOnClickListener(view -> displayToast(this, "This is a free throw"));

        scoreResetBtn.setOnClickListener(view -> {
            teamA.resetScore();
            teamB.resetScore();
            displayScore(teamA.getScoreTxtView(), teamA.getScore());
            displayScore(teamB.getScoreTxtView(), teamB.getScore());
        });

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        ++counter;
        Log.d(TAG, counter + ". onSaveInstanceState() called");
        outState.putInt("teamAScore", teamA.getScore());
        outState.putInt("teamBScore", teamB.getScore());
    }
}