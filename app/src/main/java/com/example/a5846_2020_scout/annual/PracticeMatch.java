package com.example.a5846_2020_scout.annual;

public class PracticeMatch
{
    private int preloadCount;
    private boolean crossedSector;
    private int autoLowGoal;
    private int autoHighOuterGoal;
    private int autoHighInnerGoal;

    private boolean controlPanelEnabled;
    private boolean controlPanelActivated;
    private int teleLowGoal;
    private int teleHighOuterGoal;
    private int teleHighInnerGoal;

    private boolean endPark;
    private boolean endClimb;
    private int hangPosition;

    public PracticeMatch(){}

    public void setPreloadCount(int preloadCount) {
        this.preloadCount = preloadCount;
    }

    public void setCrossedSector(boolean crossedSector) {
        this.crossedSector = crossedSector;
    }

    public void setAutoLowGoal(int autoLowGoal) {
        this.autoLowGoal = autoLowGoal;
    }

    public void setAutoHighOuterGoal(int autoHighOuterGoal) {
        this.autoHighOuterGoal = autoHighOuterGoal;
    }

    public void setAutoHighInnerGoal(int autoHighInnerGoal) {
        this.autoHighInnerGoal = autoHighInnerGoal;
    }

    public void setControlPanelEnabled(boolean controlPanelEnabled) {
        this.controlPanelEnabled = controlPanelEnabled;
    }

    public void setControlPanelActivated(boolean controlPanelActivated) {
        this.controlPanelActivated = controlPanelActivated;
    }

    public void setTeleLowGoal(int teleLowGoal) {
        this.teleLowGoal = teleLowGoal;
    }

    public void setTeleHighOuterGoal(int teleHighOuterGoal) {
        this.teleHighOuterGoal = teleHighOuterGoal;
    }

    public void setTeleHighInnerGoal(int teleHighInnerGoal) {
        this.teleHighInnerGoal = teleHighInnerGoal;
    }

    public void setEndPark(boolean endPark) {
        this.endPark = endPark;
    }

    public void setEndClimb(boolean endClimb) {
        this.endClimb = endClimb;
    }

    public void setHangPosition(int hangPosition) {
        this.hangPosition = hangPosition;
    }

    public int score()
    {
        int score = 0;
        if(crossedSector)
        {
            score += 5;
        }
        score += autoLowGoal * 2;
        score += autoHighOuterGoal * 4;
        score += autoHighInnerGoal * 6;


        return score;
    }
}