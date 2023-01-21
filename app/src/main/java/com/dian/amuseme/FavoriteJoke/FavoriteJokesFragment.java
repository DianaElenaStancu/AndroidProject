package com.dian.amuseme.FavoriteJoke;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dian.amuseme.DiscoverJokes.DadJokesApi.JokeDTO;
import com.dian.amuseme.LocalDatabase.FavoriteJokeViewModel;
import com.dian.amuseme.R;

import java.util.ArrayList;
import java.util.List;

public class FavoriteJokesFragment extends Fragment {

    private List<JokeDTO> favoriteJokesList=new ArrayList<>();
    private FavoriteJokeViewModel favoriteJokeViewModel;
    private RecyclerView favoriteJokesRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorite_jokes, container, false);
        favoriteJokesRecyclerView = view.findViewById(R.id.recyclerViewFavoriteJokes);

        favoriteJokeViewModel = new ViewModelProvider(this).get(FavoriteJokeViewModel.class);
        favoriteJokeViewModel.getFavoriteJokes().observe(getViewLifecycleOwner(), favoriteJokesList -> setupRecyclerView(favoriteJokesList));


        return view;
    }

    // 0 -- add RecyclerView in xml file and define the item template
    // 1 -- data source
    // 1.1. create dedicated class for favorite joke
    // 1.2. populate the data source

    private void setupRecyclerView(List<JokeDTO> favoriteJokesList) {
        this.favoriteJokesList = favoriteJokesList;
        setFavoriteJokesLayoutManager();
        setFavoriteJokesAdapter();
    }

    // 2 -- get custom adapter
    // 2.1. define the ViewHolder
    // 2.2. define the Adapter
    // 3 -- setup adapter for the RecyclerView
    // 3.1. setup LayoutManager
    // 3.2. set the adapter
    private void setFavoriteJokesLayoutManager() {
        favoriteJokesRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
    }

    private void setFavoriteJokesAdapter() {
        favoriteJokesRecyclerView.setAdapter(new FavoriteJokeAdapter(favoriteJokesList, this));
    }
}
