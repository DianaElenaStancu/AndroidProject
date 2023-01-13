package com.dian.amuseme.DiscoverJokes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dian.amuseme.DiscoverJokes.DadJokesApi.JokeDTO;
import com.dian.amuseme.R;

import java.util.List;

public class CardStackAdapter extends RecyclerView.Adapter<CardStackAdapter.ViewHolder> {
    private List<JokeDTO> items;

    public CardStackAdapter(List<JokeDTO> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.tinder_item_card_view, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setData(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewJokeSetup, textViewJokePunchline, textViewJokeCategory;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewJokeSetup = itemView.findViewById(R.id.textViewJokeSetup);
            textViewJokePunchline = itemView.findViewById(R.id.textViewJokePunchline);
            textViewJokeCategory = itemView.findViewById(R.id.textViewJokeCategory);
        }

        public void setData(JokeDTO jokeDTO) {
            textViewJokeSetup.setText(jokeDTO.getSetup());
            textViewJokePunchline.setText(jokeDTO.getPunchline());
            textViewJokeCategory.setText(jokeDTO.getCategory());
        }
    }

    public void setItems(List<JokeDTO> items) {
        this.items = items;
    }

    public List<JokeDTO> getItems() {
        return items;
    }
}
