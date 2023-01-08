package com.dian.amuseme;

public class ItemModel {
    private String setup, punchline, author;


    public ItemModel() {
    }

    public ItemModel(String setup, String punchline, String author) {
        this.setup = setup;
        this.punchline = punchline;
        this.author = author;
    }

    public String getSetup() {
        return setup;
    }

    public String getPunchline() {
        return punchline;
    }

    public String getAuthor() {
        return author;
    }
}
