package com.dian.amuseme;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CardStackAdapter extends RecyclerView.Adapter<CardStackAdapter.ViewHolder> {
    private List<ItemModel> items;

    public CardStackAdapter(List<ItemModel> items) {
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
        TextView textViewJokeSetup, textViewJokePunchline, textViewJokeAuthor;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewJokeSetup = itemView.findViewById(R.id.textViewJokeSetup);
            textViewJokePunchline = itemView.findViewById(R.id.textViewJokePunchline);
            textViewJokeAuthor = itemView.findViewById(R.id.textViewJokeAuthor);
        }

        public void setData(ItemModel itemModel) {
            textViewJokeSetup.setText(itemModel.getSetup());
            textViewJokePunchline.setText(itemModel.getPunchline());
            textViewJokeAuthor.setText(itemModel.getAuthor());
        }
    }

    public void setItems(List<ItemModel> items) {
        this.items = items;
    }

    public List<ItemModel> getItems() {
        return items;
    }
}
