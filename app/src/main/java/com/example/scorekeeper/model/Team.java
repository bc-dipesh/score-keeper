package com.example.scorekeeper.model;

import android.widget.Button;
import android.widget.TextView;

public class Team {

    // basic attributes of a team
    private TextView scoreTxtView;
    private Button score3Btn;
    private Button freeThrowBtn;
    private int score;

    // constructor
    public Team(TextView scoreTxtView, Button score3Btn, Button freeThrowBtn) {
        this.scoreTxtView = scoreTxtView;
        this.score3Btn = score3Btn;
        this.freeThrowBtn = freeThrowBtn;
        this.score = 0;
    }

    // properties of a team

    // reset the score to 0
    public void resetScore() {
        score = 0;
    }

    // getters and setters for private fields
    public TextView getScoreTxtView() {
        return scoreTxtView;
    }

    public void setScoreTxtView(TextView scoreTxtView) {
        this.scoreTxtView = scoreTxtView;
    }

    public Button getScore3Btn() {
        return score3Btn;
    }

    public void setScore3Btn(Button score3Btn) {
        this.score3Btn = score3Btn;
    }

    public Button getFreeThrowBtn() {
        return freeThrowBtn;
    }

    public void setFreeThrowBtn(Button freeThrowBtn) {
        this.freeThrowBtn = freeThrowBtn;
    }

    public int getScore() {
        return score;
    }

    public void updateScore(int score) {
        this.score += score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
