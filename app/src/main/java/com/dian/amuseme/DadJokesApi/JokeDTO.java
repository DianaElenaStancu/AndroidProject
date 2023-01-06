package com.dian.amuseme.DadJokesApi;

import com.google.gson.annotations.SerializedName;

public class JokeDTO {
    @SerializedName("setup")
    private String setup;

    @SerializedName("punchline")
    private String punchline;

    @SerializedName("type")
    private String category;

    public String getSetup() {
        return setup;
    }

    public String getPunchline() {
        return punchline;
    }

    public String getCategory() {
        return category;
    }


    @Override
    public String toString() {
        return  "setup=" + setup + '\n' +
                "punchline=" + punchline + '\n' +
                "category=" + category + '\n';
    }
}
