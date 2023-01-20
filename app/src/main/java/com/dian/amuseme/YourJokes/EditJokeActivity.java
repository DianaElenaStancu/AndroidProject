package com.dian.amuseme.YourJokes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dian.amuseme.R;

public class EditJokeActivity extends AppCompatActivity {
    static final String JOKE_ID_TAG = "joke_id";

    EditText textViewEditJokeText, textViewEditJokeTitle;
    Button buttonEditJokeCancel, buttonEditJokeSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_joke);

        Intent intent = getIntent();
        int jokeId = intent.getIntExtra(JOKE_ID_TAG, -1);

        setupViews();
        loadJokeInfo(jokeId);
    }

    private void loadJokeInfo(int jokeId) {
        OwnJoke ownJoke = getJoke(jokeId);

        textViewEditJokeTitle.setText(ownJoke.getTitle());
        textViewEditJokeText.setText(ownJoke.getText());
    }

    private OwnJoke getJoke(int jokeId) {
        //TODO replace this with connection to local db
        OwnJoke ownJoke = new OwnJoke("Title" + jokeId, "SOME LONG text @tyczj ViewHolder.getPosition(), btw when you create a ViewHolder you dont know the position, position is set in onBindViewHolder");
        return ownJoke;
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

        buttonEditJokeSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO save changes to local db
                finish();
            }
        });

    }


}