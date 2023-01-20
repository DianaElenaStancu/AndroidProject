package com.dian.amuseme.LocalDatabase;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.dian.amuseme.DiscoverJokes.DadJokesApi.JokeDTO;
import com.dian.amuseme.YourJokes.OwnJoke;

import java.util.List;

public class OwnJokeViewModel extends AndroidViewModel {
    private OwnJokesRepository jokesRepository;
    private LiveData<List<OwnJoke>> jokes;

    public OwnJokeViewModel(@NonNull Application application) {
        super(application);
        jokesRepository = new OwnJokesRepository(application);
        jokes = jokesRepository.getOwnJokes();
    }

    public void insert(OwnJoke ownJoke) {
        jokesRepository.insert(ownJoke);
    }

    public LiveData<List<OwnJoke>> getOwnJokes(){
        return jokes;
    }

    public void update(OwnJoke ownJoke) {
        jokesRepository.update(ownJoke);
    }

    public LiveData<OwnJoke> getOwnJoke(int jokeId) {
        return jokesRepository.getOwnJoke(jokeId);
    }
}
