package com.example.scorekeeper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

//public class MainActivity extends AppCompatActivity implements View.OnClickListener {
public class MainActivity extends AppCompatActivity {

    // buttons and text views
    // team a views
    private TextView scoreTeamA;
    private Button teamAScore0Btn;
    private Button teamAScore1Btn;
    private Button teamAFreeThrowBtn;

    // team b views
    private TextView scoreTeamB;
    private Button teamBScore0Btn;
    private Button teamBScore1Btn;
    private Button teamBFreeThrowBtn;

    // the score reset button
    private Button scoreResetBtn;

    // the score keeper variable
    private int teamAScore;
    private int teamBScore;

    // updates the score in the specific team text view
    private void updateScore(int score, TextView view) {
        view.setText("" + score);
    }

    private void resetScore() {
        teamAScore = 0;
        teamBScore = 0;

        updateScore(teamAScore, scoreTeamA);
        updateScore(teamBScore, scoreTeamB);
    }

    // display a short toast message
    private void displayToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize buttons and text views
        // team a
        scoreTeamA = findViewById(R.id.TEAM_A_SCORE);
        teamAScore0Btn = findViewById(R.id.TEAM_A_SCORE_0_BTN);
        teamAScore1Btn = findViewById(R.id.TEAM_A_SCORE_1_BTN);
        teamAFreeThrowBtn = findViewById(R.id.TEAM_A_FREE_THROW_BTN);

        // team b
        scoreTeamB = findViewById(R.id.TEAM_B_SCORE);
        teamBScore0Btn = findViewById(R.id.TEAM_B_SCORE_0_BTN);
        teamBScore1Btn = findViewById(R.id.TEAM_B_SCORE_1_BTN);
        teamBFreeThrowBtn = findViewById(R.id.TEAM_B_FREE_THROW_BTN);

        scoreResetBtn = findViewById(R.id.SCORE_RESET_BTN);


        // add onClickListener
        // onClickListener for team a
        teamAScore0Btn.setOnClickListener(view -> {
            updateScore(teamAScore, scoreTeamA);
        });

        teamAScore1Btn.setOnClickListener(view -> {
            teamAScore += 3;
            updateScore(teamAScore, scoreTeamA);
        });

        teamAFreeThrowBtn.setOnClickListener(view -> displayToast("This is a free throw"));

        // onClickListener for team b
        teamBScore0Btn.setOnClickListener(view -> {
            updateScore(teamBScore, scoreTeamB);
        });

        teamBScore1Btn.setOnClickListener(view -> {
            teamBScore += 3;
            updateScore(teamBScore, scoreTeamB);
        });

        scoreResetBtn.setOnClickListener(view -> resetScore());

        teamBFreeThrowBtn.setOnClickListener(view -> displayToast("This is a free throw"));
    }

}