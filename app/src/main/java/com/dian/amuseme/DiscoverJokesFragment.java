package com.dian.amuseme;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class DiscoverJokesFragment extends Fragment {
    private ImageButton imageButtonDiscardJoke, imageButtonSaveJokeToFavorites;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discover_jokes, container, false);

        setupViews(view);
        connectComponents();

        return view;
    }

    private void connectComponents() {
        imageButtonDiscardJoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Joke Discarded", Toast.LENGTH_SHORT).show();
            }
        });
        imageButtonSaveJokeToFavorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Joke Added To Favorites", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setupViews(View view) {
        imageButtonDiscardJoke = view.findViewById(R.id.imageButtonDiscardJoke);
        imageButtonSaveJokeToFavorites = view.findViewById(R.id.imageButtonSaveJokeToFavorites);
    }
}