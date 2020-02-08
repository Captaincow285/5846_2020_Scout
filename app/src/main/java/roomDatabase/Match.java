package roomDatabase;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import org.parceler.Parcel;

@Parcel
@Entity(tableName = "Match")
public class Match
{
    @PrimaryKey
    @ColumnInfo(name = "Team Number")
    int teamNumber;
    @ColumnInfo(name = "Match Number")
    int matchNum;
    @ColumnInfo(name = "Scout Initials")
    String scoutInit;

    @ColumnInfo(name = "Preloaded Cells")
    int preloadCount;
    @ColumnInfo(name = "Sector Boundary Crossed")
    boolean crossedSector;
    @ColumnInfo(name = "Cells Scored, Low Goal, Autonomous")
    int autoLowGoal;
    @ColumnInfo(name = "Cells Scored, High Outer Goal, Autonomous")
    int autoHighOuterGoal;
    @ColumnInfo(name = "Cells Scored, High Outer Goal, Autonomous")
    int autoHighInnerGoal;

    @ColumnInfo(name = "Control Panel Enabled")
    boolean controlPanelEnabled;
    @ColumnInfo(name = "Control Panel Activated")
    boolean controlPanelActivated;
    @ColumnInfo(name = "Cells Scored, Low Goal, TeleOp")
    int teleLowGoal;
    @ColumnInfo(name = "Cells Scored, High Outer Goal, TeleOp")
    int teleHighOuterGoal;
    @ColumnInfo(name = "Cells Scored, High Inner Goal, TeleOp")
    int teleHighInnerGoal;

    @ColumnInfo(name = "Endgame Park")
    boolean endPark;
    @ColumnInfo(name = "Endgame Climb")
    boolean endClimb;
    @ColumnInfo(name = "Hang Position")
    int hangPosition;

    public Match()
    {

    }

    @Ignore
    public int getTeamNumber()
    {
        return teamNumber;
    }

    public void setTeamNumber(int teamNumber)
    {
        this.teamNumber = teamNumber;
    }

    @Ignore
    public int getMatchNum() {
        return matchNum;
    }

    public void setMatchNum(int matchNum) {
        this.matchNum = matchNum;
    }

    @NonNull @Ignore
    public String getScoutInit() {
        return scoutInit;
    }

    public void setScoutInit(@NonNull String scoutInit) {
        this.scoutInit = scoutInit;
    }

    @Ignore
    public int getPreloadCount() {
        return preloadCount;
    }

    public void setPreloadCount(int preloadCount) {
        this.preloadCount = preloadCount;
    }

    @Ignore
    public boolean isCrossedSector() {
        return crossedSector;
    }

    public void setCrossedSector(boolean crossedSector) {
        this.crossedSector = crossedSector;
    }

    @Ignore
    public int getAutoLowGoal() {
        return autoLowGoal;
    }

    public void setAutoLowGoal(int autoLowGoal) {
        this.autoLowGoal = autoLowGoal;
    }

    @Ignore
    public int getAutoHighOuterGoal() {
        return autoHighOuterGoal;
    }

    public void setAutoHighOuterGoal(int autoHighOuterGoal) {
        this.autoHighOuterGoal = autoHighOuterGoal;
    }

    @Ignore
    public int getAutoHighInnerGoal() {
        return autoHighInnerGoal;
    }

    public void setAutoHighInnerGoal(int autoHighInnerGoal) {
        this.autoHighInnerGoal = autoHighInnerGoal;
    }

    @Ignore
    public boolean isControlPanelEnabled() {
        return controlPanelEnabled;
    }

    public void setControlPanelEnabled(boolean controlPanelEnabled) {
        this.controlPanelEnabled = controlPanelEnabled;
    }

    @Ignore
    public boolean isControlPanelActivated() {
        return controlPanelActivated;
    }

    public void setControlPanelActivated(boolean controlPanelActivated) {
        this.controlPanelActivated = controlPanelActivated;
    }

    @Ignore
    public int getTeleLowGoal() {
        return teleLowGoal;
    }

    public void setTeleLowGoal(int teleLowGoal) {
        this.teleLowGoal = teleLowGoal;
    }

    @Ignore
    public int getTeleHighOuterGoal() {
        return teleHighOuterGoal;
    }

    public void setTeleHighOuterGoal(int teleHighOuterGoal) {
        this.teleHighOuterGoal = teleHighOuterGoal;
    }

    @Ignore
    public int getTeleHighInnerGoal() {
        return teleHighInnerGoal;
    }

    public void setTeleHighInnerGoal(int teleHighInnerGoal) {
        this.teleHighInnerGoal = teleHighInnerGoal;
    }

    public boolean isEndPark() {
        return endPark;
    }

    public void setEndPark(boolean endPark) {
        this.endPark = endPark;
    }

    public boolean isEndClimb() {
        return endClimb;
    }

    public void setEndClimb(boolean endClimb) {
        this.endClimb = endClimb;
    }

    public int getHangPosition() {
        return hangPosition;
    }

    public void setHangPosition(int hangPosition) {
        this.hangPosition = hangPosition;
    }
}
