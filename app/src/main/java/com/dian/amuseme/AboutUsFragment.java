package com.dian.amuseme;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class AboutUsFragment extends Fragment {
    ImageView imageViewDiana, imageViewAndrei;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about_us, container, false);
        setupViews(view);
        return view;
    }

    private void setupViews(View view) {
        imageViewDiana = view.findViewById(R.id.imageViewDiana);
        imageViewAndrei = view.findViewById(R.id.imageViewAndrei);

        Picasso.get()
                .load("https://github.com/DianaElenaStancu.png")
                .into(imageViewDiana);

        Picasso.get()
                .load("https://github.com/beji02.png")
                .into(imageViewAndrei);
    }
}