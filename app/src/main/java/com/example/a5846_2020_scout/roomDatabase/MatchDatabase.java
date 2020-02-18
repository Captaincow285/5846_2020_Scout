package com.example.a5846_2020_scout.roomDatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(version = 1, entities = Match.class)
public abstract class MatchDatabase extends RoomDatabase
{
    static final String DATABASE_NAME = "MatchDatabase";

    abstract public MatchDAO getMatchDAO();

    private static MatchDatabase INSTANCE;

    static MatchDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (MatchDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), MatchDatabase.class, "MatchDatabase").build();
                }
            }
        }
        return INSTANCE;
    }
}
