package com.dian.amuseme.FavoriteJoke;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dian.amuseme.R;

public class FavoriteJokeHolder extends RecyclerView.ViewHolder{

    private final TextView textViewTextJoke;

    public FavoriteJokeHolder(@NonNull View itemView) {
        super(itemView);
        textViewTextJoke = itemView.findViewById(R.id.textJoke);
    }

    public TextView getTextViewTextJoke() {
        return textViewTextJoke;
    }
}
