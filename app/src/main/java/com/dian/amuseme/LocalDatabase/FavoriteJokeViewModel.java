package com.dian.amuseme.LocalDatabase;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.dian.amuseme.DiscoverJokes.DadJokesApi.JokeDTO;

import java.util.List;

public class FavoriteJokeViewModel extends AndroidViewModel {
    private FavoriteJokesRepository jokesRepository;
    private LiveData<List<JokeDTO>>jokes;

    public FavoriteJokeViewModel(@NonNull Application application) {
        super(application);
        jokesRepository = new FavoriteJokesRepository(application);
        jokes = jokesRepository.getFavoriteJokes();
    }

    public void insert(JokeDTO jokeDTO) {
        jokesRepository.insert(jokeDTO);
    }

    public LiveData<List<JokeDTO>> getFavoriteJokes(){
        return jokes;
    }
}
