package com.dian.amuseme.DadJokesApi;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DadJokesApiResponse {
    @SerializedName("body")
    List<JokeDTO> listOfJokes;

    public List<JokeDTO> getJokeDTO() {
        return listOfJokes;
    }
}
