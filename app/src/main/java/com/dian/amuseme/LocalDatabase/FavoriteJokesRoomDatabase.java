package com.dian.amuseme.LocalDatabase;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.dian.amuseme.DiscoverJokes.DadJokesApi.JokeDTO;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Database(entities = {JokeDTO.class}, version = 3)
public abstract class FavoriteJokesRoomDatabase extends RoomDatabase {
    public abstract JokeDAO jokeDAO();

    private static FavoriteJokesRoomDatabase database;

    public static FavoriteJokesRoomDatabase getInstance(Context context) {
        if(database == null) {
            database = Room.databaseBuilder(context.getApplicationContext(), FavoriteJokesRoomDatabase.class, "jokes_database").fallbackToDestructiveMigration().build();
        }
        return database;
    }

    static final Executor databaseWriterExecutor = Executors.newFixedThreadPool(4);
}