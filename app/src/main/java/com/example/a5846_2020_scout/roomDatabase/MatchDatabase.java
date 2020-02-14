package com.example.a5846_2020_scout.roomDatabase;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(version = 1, entities = Match.class)
public abstract class MatchDatabase extends RoomDatabase
{
    abstract public MatchDAO getMatchDAO();
}
