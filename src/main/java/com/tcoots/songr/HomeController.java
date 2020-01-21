package com.tcoots.songr;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @GetMapping("/")
    public String getRoot(Model m) {
        return "home";
    }

    @GetMapping("/albums")
    public String getAlbums(Model m) {
        Album[] albums = new Album[]{new Album("Traveller", "Chris Stapleton", 14, 3784, "https://upload.wikimedia.org/wikipedia/en/d/d2/Traveller_%28Chris_Stapleton_album%29.jpg"),
                new Album("Jekyll + Hyde", "Zac Brown Band", 16, 3962, "https://upload.wikimedia.org/wikipedia/en/d/d8/JekyllHyde.jpg"),
                new Album("Chris Cornell", "Chris Cornell", 17, 4606, "https://upload.wikimedia.org/wikipedia/en/a/aa/Chris_Cornell_%E2%80%93_Chris_Cornell_album.png")};
        m.addAttribute("Album-Array", albums);
        return "albums";
    }
}


