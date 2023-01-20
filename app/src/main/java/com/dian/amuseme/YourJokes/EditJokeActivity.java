package com.dian.amuseme.YourJokes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dian.amuseme.DiscoverJokes.DadJokesApi.DadJokesRepository;
import com.dian.amuseme.DiscoverJokes.DadJokesApi.JokeDTO;
import com.dian.amuseme.LocalDatabase.FavoriteJokeViewModel;
import com.dian.amuseme.LocalDatabase.OwnJokeViewModel;
import com.dian.amuseme.R;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;

public class EditJokeActivity extends AppCompatActivity {
    private static final String TAG = "MyEditJokeActivity";
    static final String JOKE_ID_TAG = "joke_id";

    EditText textViewEditJokeText, textViewEditJokeTitle;
    Button buttonEditJokeCancel, buttonEditJokeSave;

    private OwnJokeViewModel jokeViewModel;
    private int jokeId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_joke);

        Intent intent = getIntent();
        jokeId = intent.getIntExtra(JOKE_ID_TAG, -1);

        setupViews();

        jokeViewModel = new ViewModelProvider(this).get(OwnJokeViewModel.class);

        if(jokeId != -1)
            jokeViewModel.getOwnJoke(jokeId).observe(this, joke -> loadJokeInfo(joke));
    }

    private void loadJokeInfo(OwnJoke ownJoke) {
        textViewEditJokeTitle.setText(ownJoke.getTitle());
        textViewEditJokeText.setText(ownJoke.getText());
    }

    private void setupViews() {
        textViewEditJokeText = findViewById(R.id.textViewEditJokeText);
        textViewEditJokeTitle = findViewById(R.id.textViewEditJokeTitle);
        buttonEditJokeCancel = findViewById(R.id.buttonEditJokeCancel);
        buttonEditJokeSave = findViewById(R.id.buttonEditJokeSave);

        buttonEditJokeCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        if(jokeId == -1) {
            buttonEditJokeSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String title = textViewEditJokeTitle.getText().toString();
                    String text = textViewEditJokeText.getText().toString();

                    OwnJoke ownJoke = new OwnJoke(title, text);
                    DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
                    ownJoke.setTimeAdded(formatter.format(LocalDateTime.now()));

                    jokeViewModel.insert(ownJoke);
                    finish();
                }
            });
        }
        else {
            buttonEditJokeSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //TODO save changes to local db
                    String title = textViewEditJokeTitle.getText().toString();
                    String text = textViewEditJokeText.getText().toString();

                    OwnJoke ownJoke = new OwnJoke(title, text);
                    ownJoke.setId(jokeId);
                    DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
                    ownJoke.setTimeAdded(formatter.format(LocalDateTime.now()));

                    jokeViewModel.update(ownJoke);
                    finish();
                }
            });
        }

    }


}