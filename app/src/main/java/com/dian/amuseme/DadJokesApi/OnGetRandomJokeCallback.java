package com.dian.amuseme.DadJokesApi;

import java.util.List;

public interface OnGetRandomJokeCallback {
    // happy path
    void onSuccess(JokeDTO jokeDTO);
    // sad path
    void onError();
}
