package com.example.a5846_2020_scout.annual;

import org.parceler.Parcel;

@Parcel
public class PracticeMatch
{
    int preloadCount;
    boolean crossedSector;
    int autoLowGoal;
    int autoHighOuterGoal;
    int autoHighInnerGoal;

    boolean controlPanelEnabled;
    boolean controlPanelActivated;
    int teleLowGoal;
    int teleHighOuterGoal;
    int teleHighInnerGoal;

    boolean endPark;
    boolean endClimb;
    int hangPosition;
    boolean balanced;

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

    public void setBalanced(boolean balanced) {
        this.balanced = balanced;
    }

    public int autoScore()
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

    public int teleScore()
    {
        int score = 0;
        score += teleHighInnerGoal * 3;
        score += teleHighOuterGoal * 2;
        score += teleLowGoal;
        if(controlPanelEnabled)
        {
            score += 10;
        }
        if(controlPanelActivated)
        {
            score += 20;
        }
        return score;
    }

    public int endScore()
    {
        int score = 0;
        if(endPark)
        {
            score += 5;
        }
        if(endClimb)
        {
            score += 25;
        }
        if(balanced)
        {
            score += 15;
        }
        return score;
    }

    public int totalScore()
    {
        int score = 0;
        if(crossedSector)
        {
            score += 5;
        }
        score += autoLowGoal * 2;
        score += autoHighOuterGoal * 4;
        score += autoHighInnerGoal * 6;
        score += teleHighInnerGoal * 3;
        score += teleHighOuterGoal * 2;
        score += teleLowGoal;
        if(controlPanelEnabled)
        {
            score += 10;
        }
        if(controlPanelActivated)
        {
            score += 20;
        }
        if(endPark)
        {
            score += 5;
        }
        if(endClimb)
        {
            score += 25;
        }
        if(balanced)
        {
            score += 15;
        }

        return score;
    }
}