package room_database;

import androidx.room.Entity;

@Entity(tableName = "Match")
public class Match
{
    private int matchNum;
    private String scoutInit;
    private int startPosition;

    public Match()
    {

    }
}
