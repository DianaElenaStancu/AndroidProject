package com.dian.amuseme.JokeOfTheDay;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dian.amuseme.DiscoverJokes.DadJokesApi.DadJokesRepository;
import com.dian.amuseme.DiscoverJokes.DadJokesApi.JokeDTO;
import com.dian.amuseme.DiscoverJokes.DadJokesApi.OnGetRandomJokeCallback;
import com.dian.amuseme.R;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class JokeOfTheDayFragment extends Fragment {
    private static final String TAG = "JokeOfTheDayFragment";
    private static final String APP_KEY = "joke_app_key";

    private TextView textViewDate, textViewJokeOfTheDaySetup, textViewJokeOfTheDayPunchline, textViewJokeOfTheDayCategory;
    private DadJokesRepository repository;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_joke_of_the_day, container, false);

        setupViews(view);
        repository = DadJokesRepository.getInstance();

        loadJokeOfTheDay(view.getContext().getApplicationContext());

        return view;
    }

    private void loadJokeOfTheDay(Context applicationContext) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        try {
            String dateString = getStringValueFromSharedPreferences(applicationContext, "joke_date");

            if (dateString.isEmpty()) throw new OldJokeException();

            LocalDate date = LocalDate.parse(dateString, formatter);

            if (!date.equals(LocalDate.now())) throw new OldJokeException();

            loadJokeOfTheDayFromSharedPreferences(applicationContext);

        } catch (OldJokeException e) {
            e.printStackTrace();

            repository.getRandomJokes(new OnGetRandomJokeCallback() {
                @Override
                public void onSuccess(List<JokeDTO> list) {
                    Log.d(TAG, "onsucc=");
                    JokeDTO jokeOfTheDay = list.get(0);

                    LocalDate date = LocalDate.now();
                    String dateString = date.format(formatter);

                    setStringValueInSharedPreferences(applicationContext, "joke_date", dateString, APP_KEY);
                    setStringValueInSharedPreferences(applicationContext, "joke_setup", jokeOfTheDay.getSetup(), APP_KEY);
                    setStringValueInSharedPreferences(applicationContext, "joke_punchline", jokeOfTheDay.getPunchline(), APP_KEY);
                    setStringValueInSharedPreferences(applicationContext, "joke_category", jokeOfTheDay.getCategory(), APP_KEY);

                    loadJokeOfTheDayFromSharedPreferences(applicationContext);
                }

                @Override
                public void onError() {
                    Log.d(TAG, "onerr=");
                }
            });
        }
    }

    private void loadJokeOfTheDayFromSharedPreferences(Context context) {
        String jokeDate = getStringValueFromSharedPreferences(context, "joke_date");
        String jokeSetup = getStringValueFromSharedPreferences(context, "joke_setup");
        String jokePunchline = getStringValueFromSharedPreferences(context, "joke_punchline");
        String jokeCategory = getStringValueFromSharedPreferences(context, "joke_category");

        textViewJokeOfTheDaySetup.setText(jokeSetup);
        textViewJokeOfTheDayPunchline.setText(jokePunchline);
        textViewJokeOfTheDayCategory.setText(jokeCategory);
        textViewDate.setText(jokeDate);
    }

    // save a String value by key and appkey
    public static void setStringValueInSharedPreferences(Context context, String key, String value, String AppKey) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(AppKey,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    // get a String value by key
    public static String getStringValueFromSharedPreferences(Context context, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(APP_KEY,
                Context.MODE_PRIVATE);
        return sharedPreferences.getString(key, "");
    }

    private void setupViews(View view) {
        textViewDate = view.findViewById(R.id.textViewDate);
        textViewJokeOfTheDaySetup = view.findViewById(R.id.textViewJokeOfTheDaySetup);
        textViewJokeOfTheDayPunchline = view.findViewById(R.id.textViewJokeOfTheDayPunchline);
        textViewJokeOfTheDayCategory = view.findViewById(R.id.textViewJokeOfTheDayCategory);
    }




}