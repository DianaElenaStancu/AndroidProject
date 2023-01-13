package com.dian.amuseme.FavoriteJoke;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dian.amuseme.DiscoverJokes.DadJokesApi.JokeDTO;
import com.dian.amuseme.R;

import java.util.List;

public class FavoriteJokeAdapter extends RecyclerView.Adapter<FavoriteJokeHolder> {
    private final List<JokeDTO> favoriteJokesList;

    public FavoriteJokeAdapter(List<JokeDTO> favoriteJokesList) {
        this.favoriteJokesList = favoriteJokesList;
    }

    @NonNull
    @Override
    public FavoriteJokeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.favorite_joke_item, parent, false);
        return new FavoriteJokeHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteJokeHolder holder, int position) {
        JokeDTO currentFavoriteJoke = favoriteJokesList.get(position);
        holder.getTextViewTextJoke().setText(currentFavoriteJoke.getPunchline());
    }

    @Override
    public int getItemCount() {
        return favoriteJokesList.size();
    }
}
