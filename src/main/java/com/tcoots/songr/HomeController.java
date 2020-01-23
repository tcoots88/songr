package com.tcoots.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    SongRepository songRepository;

    @GetMapping("/")
    public String getRoot(Model m) {
        return "home";
    }

    @GetMapping("/albums")
    public String getAlbums(Model m) {
        Album[] albums = new Album[]{new Album("Traveller", "Chris Stapleton", 14, 3784, "https://upload.wikimedia.org/wikipedia/en/d/d2/Traveller_%28Chris_Stapleton_album%29.jpg"),
                new Album("Jekyll + Hyde", "Zac Brown Band", 16, 3962, "https://upload.wikimedia.org/wikipedia/en/d/d8/JekyllHyde.jpg"),
                new Album("Chris Cornell", "Chris Cornell", 17, 4606, "https://upload.wikimedia.org/wikipedia/en/a/aa/Chris_Cornell_%E2%80%93_Chris_Cornell_album.png")};
        m.addAttribute("albumArray", albums);
        return "albums";
    }
//Should direct to page showing all albums
    @GetMapping("/allAlbums")
    public String getAllAlbums(Model m) {
        List<Album> albums = albumRepository.findAll();
        m.addAttribute("albums",albums);
        return "allAlbums";
    }

    @GetMapping("/newAlbum")
    public String albumForm(Model m){
        m.addAttribute("album", new Album());
        return "newAlbum";
    }

    @PostMapping("/newAlbum")
    public String albumNew(@ModelAttribute("album") Album album) {
        albumRepository.save(album);
        return "newAlbum";
    }

//    Mapping for songs

    @GetMapping("/songs")
    public String getAllSongs(Model m) {
        List<Song> songs = songRepository.findAll();
        m.addAttribute("songs", songs);
        return "allSongs";
    }

    @GetMapping("/songs/new")
    public String getNewSongForm(Model m){
        m.addAttribute("songs", new Song());
        m.addAttribute("songs", new Album());
        return "newSong";
    }

    @PostMapping("/songs/new")
    public RedirectView addSong(@RequestParam String title, @RequestParam String album, @RequestParam Integer trackNumber, @RequestParam Integer length){
        List<Album> albumsWithMatchingTitle = albumRepository.findByTitle(album);
        if(albumsWithMatchingTitle.size() > 0) {
            Song song = new Song(title, length, trackNumber, albumsWithMatchingTitle.get(0));
            songRepository.save(song);
        } else {
            Album newAlbumToSave = new Album();
            albumRepository.save(newAlbumToSave);
            Song song = new Song(title, length, trackNumber, newAlbumToSave);
            songRepository.save(song);
        }
        return new RedirectView("/songs");
    }
}


