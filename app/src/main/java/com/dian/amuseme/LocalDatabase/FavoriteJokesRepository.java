package com.dian.amuseme.LocalDatabase;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.dian.amuseme.DiscoverJokes.DadJokesApi.JokeDTO;

import java.util.ArrayList;
import java.util.List;

public class FavoriteJokesRepository {
    private JokeDAO jokeDAO;
    private LiveData<List<JokeDTO>> favoriteJokes;

    public FavoriteJokesRepository(Context context) {
        FavoriteJokesRoomDatabase favoriteJokesRoomDatabase = FavoriteJokesRoomDatabase.getInstance(context);
        jokeDAO = favoriteJokesRoomDatabase.jokeDAO();
        favoriteJokes = jokeDAO.getAll();
    }

    public void insert(JokeDTO jokeDTO) {
        FavoriteJokesRoomDatabase.databaseWriterExecutor.execute(()->jokeDAO.insert(jokeDTO));
    }

    public LiveData<List<JokeDTO>> getFavoriteJokes() {
        return favoriteJokes;
    }

    public void delete(JokeDTO currentFavoriteJoke) {
        FavoriteJokesRoomDatabase.databaseWriterExecutor.execute(()->jokeDAO.delete(currentFavoriteJoke));
    }
}
