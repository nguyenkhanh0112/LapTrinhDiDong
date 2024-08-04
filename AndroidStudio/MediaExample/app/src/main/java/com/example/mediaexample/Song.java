package com.example.mediaexample;

public class Song {
    private String id;
    private String title;
    private String artist;

    public Song(Long id, String title, String artist) {
        this.id = id;
        this.title = title;
        this.artist = artist;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }
}
