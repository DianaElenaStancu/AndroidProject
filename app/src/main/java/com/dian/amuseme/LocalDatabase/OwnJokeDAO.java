package com.dian.amuseme.LocalDatabase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.dian.amuseme.DiscoverJokes.DadJokesApi.JokeDTO;
import com.dian.amuseme.YourJokes.OwnJoke;

import java.util.List;

@Dao
public interface OwnJokeDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(OwnJoke ownJoke);

    @Query("Select * from own_jokes")
    LiveData<List<OwnJoke>> getAll();

    @Delete
    void delete(OwnJoke ownJoke);

    @Update
    void update(OwnJoke ownJoke);

    @Query("Select * from own_jokes where id = :id")
    LiveData<OwnJoke> getOne(int id);

}
