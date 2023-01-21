package com.dian.amuseme.FavoriteJoke;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.dian.amuseme.DiscoverJokes.DadJokesApi.JokeDTO;
import com.dian.amuseme.LocalDatabase.FavoriteJokeViewModel;
import com.dian.amuseme.R;

import java.util.List;

public class FavoriteJokeAdapter extends RecyclerView.Adapter<FavoriteJokeHolder> {
    private final List<JokeDTO> favoriteJokesList;
    private FavoriteJokeViewModel favoriteJokeViewModel;
    private final Fragment parentFragment;

    public FavoriteJokeAdapter(List<JokeDTO> favoriteJokesList, Fragment parentFragment) {
        this.favoriteJokesList = favoriteJokesList;
        this.parentFragment=parentFragment;
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
        holder.getTextViewTextJoke().setText(currentFavoriteJoke.getSetup());
        holder.getPunchlineViewTextJoke().setText(currentFavoriteJoke.getPunchline());
        holder.getCategoryViewTextJoke().setText(currentFavoriteJoke.getCategory());

        favoriteJokeViewModel = new ViewModelProvider(parentFragment).get(FavoriteJokeViewModel.class);
        holder.getRemoveFavoriteJokeButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                favoriteJokeViewModel.delete(currentFavoriteJoke);
            }
        });
    }

    @Override
    public int getItemCount() {
        return favoriteJokesList.size();
    }
}
