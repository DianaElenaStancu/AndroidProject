package com.dian.amuseme.LocalDatabase;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.dian.amuseme.DiscoverJokes.DadJokesApi.JokeDTO;
import com.dian.amuseme.YourJokes.OwnJoke;

import java.util.List;

public class OwnJokesRepository {
    private OwnJokeDAO ownJokeDAO;
    private LiveData<List<OwnJoke>> ownJokes;
    private LiveData<OwnJoke> ownJoke;

    public OwnJokesRepository(Context context) {
        FavoriteJokesRoomDatabase ownJokesRoomDatabase = FavoriteJokesRoomDatabase.getInstance(context);
        ownJokeDAO = ownJokesRoomDatabase.ownJokeDAO();
        ownJokes = ownJokeDAO.getAll();
        ownJoke = ownJokeDAO.getOne(0);
    }

    public void insert(OwnJoke ownJoke) {
        FavoriteJokesRoomDatabase.databaseWriterExecutor.execute(()->ownJokeDAO.insert(ownJoke));
    }

    public LiveData<List<OwnJoke>> getOwnJokes() {
        return ownJokes;
    }

    public void update(OwnJoke ownJoke) {
        FavoriteJokesRoomDatabase.databaseWriterExecutor.execute(()->ownJokeDAO.update(ownJoke));
    }

    public LiveData<OwnJoke> getOwnJoke(int jokeId) {
        return ownJokeDAO.getOne(jokeId);
    }
}
