package room_database;

import androidx.room.Entity;

@Entity(tableName = "Match")
public class Match
{
    private int matchNum;
    private String scoutInit;
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

    public Match()
    {

    }


}
