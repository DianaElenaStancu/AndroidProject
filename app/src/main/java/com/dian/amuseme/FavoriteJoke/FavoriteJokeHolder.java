package com.dian.amuseme.FavoriteJoke;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.dian.amuseme.LocalDatabase.FavoriteJokeViewModel;
import com.dian.amuseme.R;

public class FavoriteJokeHolder extends RecyclerView.ViewHolder{

    private final TextView textViewTextJoke, punchlineViewTextJoke, categoryViewTextJoke;
    private final Button removeFavoriteJokeButton;

    public FavoriteJokeHolder(@NonNull View itemView) {
        super(itemView);
        textViewTextJoke = itemView.findViewById(R.id.textJoke);
        punchlineViewTextJoke=itemView.findViewById(R.id.punchlineJoke);
        categoryViewTextJoke=itemView.findViewById(R.id.categoryJoke);
        removeFavoriteJokeButton = itemView.findViewById(R.id.removeFavoriteJoke);


    }

    public Button getRemoveFavoriteJokeButton(){
        return removeFavoriteJokeButton;
    }

    public TextView getTextViewTextJoke() {
        return textViewTextJoke;
    }

    public TextView getPunchlineViewTextJoke() {
        return punchlineViewTextJoke;
    }

    public TextView getCategoryViewTextJoke() {
        return categoryViewTextJoke;
    }
}
