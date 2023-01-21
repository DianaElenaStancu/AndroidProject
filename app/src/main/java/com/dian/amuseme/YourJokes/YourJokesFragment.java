package com.dian.amuseme.YourJokes;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.dian.amuseme.LocalDatabase.OwnJokeViewModel;
import com.dian.amuseme.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Arrays;
import java.util.List;

public class YourJokesFragment extends Fragment {
    private static final String TAG = "YourJokesFragment";
    private RecyclerView recyclerViewYourJokes;
    private OwnJokeViewModel jokeViewModel;
    private FloatingActionButton fabAddNewJoke;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_your_jokes, container, false);
        recyclerViewYourJokes = view.findViewById(R.id.recyclerViewYourJokes);
        fabAddNewJoke = view.findViewById(R.id.fabAddNewJoke);
        fabAddNewJoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), EditJokeActivity.class);
                view.getContext().startActivity(intent);
            }
        });

        jokeViewModel = new ViewModelProvider(this).get(OwnJokeViewModel.class);
        jokeViewModel.getOwnJokes().observe(getViewLifecycleOwner(), jokes -> reloadJokeList(jokes));

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        //Toast.makeText(getContext(), "onResume: ", Toast.LENGTH_SHORT).show();
    }

    private void reloadJokeList(List<OwnJoke> jokes) {
        recyclerViewYourJokes.setLayoutManager(new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL));
        recyclerViewYourJokes.setAdapter(new OwnJokesAdapter(jokes));
    }
}