package com.dian.amuseme.DiscoverJokes.DadJokesApi;

import java.util.List;

public interface OnGetRandomJokeCallback {
    // happy path
    void onSuccess(List<JokeDTO> list);
    // sad path
    void onError();
}
