package com.dian.amuseme.YourJokes;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dian.amuseme.R;

public class OwnJokeViewHolder extends RecyclerView.ViewHolder {
    private TextView textViewOwnJokeTitle, textViewOwnJokeText, textViewOwnJokeDate;

    public OwnJokeViewHolder(@NonNull View itemView) {
        super(itemView);
        textViewOwnJokeTitle = itemView.findViewById(R.id.textViewOwnJokeTitle);
        textViewOwnJokeText = itemView.findViewById(R.id.textViewOwnJokeText);
        textViewOwnJokeDate = itemView.findViewById(R.id.textViewOwnJokeDate);
    }

    public TextView getTextViewOwnJokeTitle() {
        return textViewOwnJokeTitle;
    }

    public TextView getTextViewOwnJokeText() {
        return textViewOwnJokeText;
    }

    public TextView getTextViewOwnJokeDate() {
        return textViewOwnJokeDate;
    }
}
