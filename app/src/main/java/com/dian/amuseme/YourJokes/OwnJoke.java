package com.dian.amuseme.YourJokes;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "own_jokes")
public class OwnJoke {
    @ColumnInfo(name = "title")
    private String title;
    @ColumnInfo(name = "text")
    private String text;
    @ColumnInfo(name = "time_added")
    private String timeAdded;
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id = 0;

    public OwnJoke(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTimeAdded() {
        return timeAdded;
    }

    public String toString() {
        return  "id=" + id + '\n' +
                "title=" + title + '\n' +
                "text=" + text + '\n' +
                "time=" + timeAdded + '\n';
    }

    public void setTimeAdded(String timeAdded) {
        this.timeAdded = timeAdded;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
