package com.dian.amuseme.LocalDatabase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.dian.amuseme.DiscoverJokes.DadJokesApi.JokeDTO;

import java.util.List;

@Dao
public interface JokeDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(JokeDTO jokeDTO);

    @Query("Select * from favorite_jokes")
    LiveData<List<JokeDTO>> getAll();

    @Delete
    void delete(JokeDTO jokeDTO);
}
