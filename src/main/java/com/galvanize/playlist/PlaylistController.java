package com.galvanize.playlist;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlaylistController {

    @GetMapping("playlists")
    public String getPlaylists(){
        return "[{}]";
    }

    @PostMapping("playlists")
    @ResponseStatus(HttpStatus.CREATED)
    public void addPlaylists(){


    }
}
