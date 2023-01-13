package com.dian.amuseme.FavoriteJoke;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dian.amuseme.R;

public class YourJokesFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_your_jokes, container, false);
    }

    // 0 -- add RecyclerView in xml file and define the item template
    // 1 -- data source
    // 1.1. create dedicated class for favorite joke
    // 1.2. populate the data source
    // 2 -- get custom adapter
    // 2.1. define the ViewHolder
    // 2.2. define the Adapter
    // 3 -- setup adapter for the RecyclerView
    // 3.1. setup LayoutManager
    // 3.2. set the adapter
}