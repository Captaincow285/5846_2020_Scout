package room_database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Match")
public class Match
{
    @PrimaryKey
    @ColumnInfo(name = "Match Number") @NonNull
    private int matchNum;
    @ColumnInfo(name = "Scout Initials") @NonNull
    private String scoutInit;

    @ColumnInfo(name = "Preloaded Cells") @NonNull
    private int preloadCount;
    @ColumnInfo(name = "Sector Boundary Crossed") @NonNull
    private boolean crossedSector;
    @ColumnInfo(name = "Cells Scored, Low Goal, Autonomous") @NonNull
    private int autoLowGoal;
    @ColumnInfo(name = "Cells Scored, High Outer Goal, Autonomous") @NonNull
    private int autoHighOuterGoal;
    @ColumnInfo(name = "Cells Scored, High Outer Goal, Autonomous") @NonNull
    private int autoHighInnerGoal;

    @ColumnInfo(name = "Control Panel Enabled") @NonNull
    private boolean controlPanelEnabled;
    @ColumnInfo(name = "Control Panel Activated") @NonNull
    private boolean controlPanelActivated;
    @ColumnInfo(name = "Cells Scored, Low Goal, TeleOp") @NonNull
    private int teleLowGoal;
    @ColumnInfo(name = "Cells Scored, High Outer Goal, TeleOp") @NonNull
    private int teleHighOuterGoal;
    @ColumnInfo(name = "Cells Scored, High Inner Goal, TeleOp") @NonNull
    private int teleHighInnerGoal;

    @ColumnInfo(name = "Endgame Park") @NonNull
    private boolean endPark;
    @ColumnInfo(name = "Endgame Climb") @NonNull
    private boolean endClimb;
    @ColumnInfo(name = "Hang Position") @NonNull
    private int hangPosition;

    public Match()
    {

    }


}
