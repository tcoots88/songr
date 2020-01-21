package com.tcoots.songr;

public class Album {

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

    public String getAlbumName(){
        return albumName;
    }

    public String getArtistName(){
        return artistName;
    }

    public int getSongCount(){
        return songCount;
    }

    public long getLength() {
    return length;
    }

    public String getImageUrl(){
        return imageUrl;

    }
    

//Need An Album has a title, an artist, a songCount, a length (in seconds), and an imageUrl that is a link to that album’s art.

}
