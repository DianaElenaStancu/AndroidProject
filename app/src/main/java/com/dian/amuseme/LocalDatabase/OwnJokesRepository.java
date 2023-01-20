package com.dian.amuseme.LocalDatabase;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.dian.amuseme.DiscoverJokes.DadJokesApi.JokeDTO;
import com.dian.amuseme.YourJokes.OwnJoke;

import java.util.List;

public class OwnJokesRepository {
    private OwnJokeDAO ownJokeDAO;
    private LiveData<List<OwnJoke>> ownJokes;

    public OwnJokesRepository(Context context) {
        FavoriteJokesRoomDatabase ownJokesRoomDatabase = FavoriteJokesRoomDatabase.getInstance(context);
        ownJokeDAO = ownJokesRoomDatabase.ownJokeDAO();
        ownJokes = ownJokeDAO.getAll();
    }

    public void insert(OwnJoke ownJoke) {
        FavoriteJokesRoomDatabase.databaseWriterExecutor.execute(()->ownJokeDAO.insert(ownJoke));
    }

    public LiveData<List<OwnJoke>> getOwnJokes() {
        return ownJokes;
    }

}
