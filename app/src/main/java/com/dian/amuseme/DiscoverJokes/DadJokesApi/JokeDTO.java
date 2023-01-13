package com.dian.amuseme.DiscoverJokes.DadJokesApi;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity(tableName = "favorite_jokes")
public class JokeDTO {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id = 0;

    @ColumnInfo(name = "setup")
    @SerializedName("setup")
    private String setup;

    @ColumnInfo(name = "punchline")
    @SerializedName("punchline")
    private String punchline;

    @ColumnInfo(name = "category")
    @SerializedName("type")
    private String category;

    @ColumnInfo(name = "time_added")
    private String timeAdded;

    public String getSetup() {
        return setup;
    }

    public String getPunchline() {
        return punchline;
    }

    public String getCategory() {
        return category;
    }

    public JokeDTO(String setup, String punchline, String category) {
        this.setup = setup;
        this.punchline = punchline;
        this.category = category;
    }

    @Override
    public String toString() {
        return  "setup=" + setup + '\n' +
                "punchline=" + punchline + '\n' +
                "category=" + category + '\n' +
                "time=" + timeAdded + '\n';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTimeAdded() {
        return timeAdded;
    }

    public void setTimeAdded(String timeAdded) {
        this.timeAdded = timeAdded;
    }
}
