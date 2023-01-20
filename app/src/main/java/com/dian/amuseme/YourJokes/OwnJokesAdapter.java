package com.dian.amuseme.YourJokes;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.dian.amuseme.R;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class OwnJokesAdapter extends RecyclerView.Adapter<OwnJokeViewHolder> {
    static final String JOKE_ID_TAG = "joke_id";
    private List<OwnJoke> jokeList;

    public OwnJokesAdapter(List<OwnJoke> jokeList) {
        this.jokeList = jokeList;
    }

    @NonNull
    @Override
    public OwnJokeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.own_joke_item, parent, false);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        return new OwnJokeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull OwnJokeViewHolder holder, int position) {
        OwnJoke currentJoke = jokeList.get(position);

        //TODO remove these
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate date = LocalDate.now();
        String dateString = date.format(formatter);
        currentJoke.setTimeAdded(dateString);

        holder.getTextViewOwnJokeTitle().setText(currentJoke.getTitle());
        holder.getTextViewOwnJokeText().setText(currentJoke.getText());
        holder.getTextViewOwnJokeDate().setText(currentJoke.getTimeAdded());

        //holder.getAbsoluteAdapterPosition();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt(JOKE_ID_TAG, jokeList.get(holder.getAbsoluteAdapterPosition()).getId());

//                FragmentManager.findFragment(view).getActivity().getSupportFragmentManager().beginTransaction()
//                        .setReorderingAllowed(true)
//                        .replace(R.id.frameLayout, EditJokeFragment.class, bundle)
//                        .addToBackStack(null)
//                        .commit();

//                FragmentManager fragmentManager = FragmentManager.findFragment(view).getActivity().getSupportFragmentManager();
//
//                FragmentTransaction transaction = fragmentManager.beginTransaction();
//                transaction.setReorderingAllowed(true);
//
//                transaction.add(R.id.drawer_layout, EditJokeFragment.class, bundle);
//                transaction.commit();

                Intent intent = new Intent(view.getContext(), EditJokeActivity.class);
                intent.putExtra(JOKE_ID_TAG, jokeList.get(holder.getAbsoluteAdapterPosition()).getId());
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return jokeList.size();
    }
}
