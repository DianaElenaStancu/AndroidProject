package com.dian.amuseme;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dian.amuseme.DiscoverJokes.DadJokesApi.JokeDTO;
import com.dian.amuseme.LocalDatabase.FavoriteJokesRoomDatabase;
import com.dian.amuseme.R;

import java.util.ArrayList;
import java.util.List;

public class YourJokesFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_your_jokes, container, false);
    }

}