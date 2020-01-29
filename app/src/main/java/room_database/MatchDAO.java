package room_database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;

@Dao
public interface MatchDAO
{
    @Insert
    public void insert(Match... Match);

    @Update
    public void update(Match... Match);

    @Delete
    public void delete(Match Match);
}
