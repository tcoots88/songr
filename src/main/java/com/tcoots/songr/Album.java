package com.tcoots.songr;

import javax.persistence.*;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    public String albumName;
    public String artistName;
    private int songCount;
    private long length;
    private String imageUrl;

    public Album(String albumName, String artistName, int songCount, long length, String imageUrl) {
        this.albumName = albumName;
        this.artistName = artistName;
        this.songCount = songCount;
        this.length = length;
        this.imageUrl = imageUrl;
    }

    public Album(){}

    public String getAlbumName(){
        return albumName;
    }
    public void setAlbumName(String albumName){
        this.albumName = albumName;
    }

    public String getArtistName(){
        return artistName;
    }
    public void setArtistName(String artistName){
        this.artistName = artistName;
    }

    public int getSongCount(){
        return songCount;
    }
    public void setSongCount(int songCount){
        this.songCount = songCount;
    }

    public long getLength() {
    return length;
    }
    public void setLength(long length){
        this.length = length;
    }

    public String getImageUrl(){
        return imageUrl;
    }
    public void setImageUrl(String imageUrl){
        this.imageUrl = imageUrl;
    }

    public long getId() {
        return id;
    }
}
