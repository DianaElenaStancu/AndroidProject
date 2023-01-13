package com.dian.amuseme.DadJokesApi;

import java.util.List;

public interface OnGetRandomJokeCallback {
    // happy path
    void onSuccess(List<JokeDTO> list);
    // sad path
    void onError();
}
