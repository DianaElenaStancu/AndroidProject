package com.dian.amuseme.DiscoverJokes.DadJokesApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DadJokesRepository {
    private static final String BASE_DAD_JOKES_API_URL = "https://dad-jokes.p.rapidapi.com/";
    private static DadJokesRepository repository = null;
    private static DadJokesApi api = null;

    private DadJokesRepository() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_DAD_JOKES_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(DadJokesApi.class);
    }

    public static DadJokesRepository getInstance() {
        if(repository == null)
            repository = new DadJokesRepository();
        return repository;
    }

    public void getRandomJokes(OnGetRandomJokeCallback callback) {
        api     .getRandomJoke()
                .enqueue(new Callback<DadJokesApiResponse>() {
                    @Override
                    public void onResponse(Call<DadJokesApiResponse> call, Response<DadJokesApiResponse> response) {
                        if(response.isSuccessful()) {
                            List<JokeDTO> list = response.body().getJokeDTO();
                            if(list != null) {
                                callback.onSuccess(list);
                                return;
                            }
                        }
                        callback.onError();
                    }

                    @Override
                    public void onFailure(Call<DadJokesApiResponse> call, Throwable t) {
                        callback.onError();
                    }
                });

    }


}
