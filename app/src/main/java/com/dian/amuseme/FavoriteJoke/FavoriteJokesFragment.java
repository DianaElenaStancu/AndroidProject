package com.dian.amuseme.FavoriteJoke;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dian.amuseme.DiscoverJokes.DadJokesApi.JokeDTO;
import com.dian.amuseme.LocalDatabase.FavoriteJokesRoomDatabase;
import com.dian.amuseme.R;

import java.util.ArrayList;
import java.util.List;

public class FavoriteJokesFragment extends Fragment {

    private List<JokeDTO> favoriteJokeList;
    private FavoriteJokesRoomDatabase favoriteJokesRoomDatabase;
    private RecyclerView favoriteJokesRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorite_jokes, container, false);
        favoriteJokesRecyclerView = view.findViewById(R.id.recyclerViewFavoriteJokes);
        setupRecyclerView();
        
        return view;
    }

    // 0 -- add RecyclerView in xml file and define the item template
    // 1 -- data source
    // 1.1. create dedicated class for favorite joke
    // 1.2. populate the data source

    private void setFavoriteJokeList() {
        favoriteJokeList = new ArrayList<>();
        favoriteJokeList.add(new JokeDTO("aaaa", "bbbb", "ssss"));
        favoriteJokeList.add(new JokeDTO("aaaa", "bbbb", "ssss"));
        favoriteJokeList.add(new JokeDTO("aaaa", "bbbb", "ssss"));
        favoriteJokeList.add(new JokeDTO("aaaa", "bbbb", "ssss"));
        favoriteJokeList.add(new JokeDTO("aaaa", "bbbb", "ssss"));
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
        favoriteJokesRecyclerView.setAdapter(new FavoriteJokeAdapter(favoriteJokeList));
    }

    private void setupRecyclerView() {
        setFavoriteJokeList();
        setFavoriteJokesLayoutManager();;
        setFavoriteJokesAdapter();
    }
}
