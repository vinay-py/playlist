package com.galvanize.playlist;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlaylistController {



    @GetMapping("playlists")
    public String getPlaylists(){
        return "[{}]";
    }
}
