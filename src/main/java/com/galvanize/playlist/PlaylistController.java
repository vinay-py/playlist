package com.galvanize.playlist;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlaylistController {

    PlaylistService playlistService;

    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @GetMapping("playlists")
    public List<PlaylistDto> getPlaylists(){
        return this.playlistService.fetchAll();
    }

    @PostMapping("playlists")
    @ResponseStatus(HttpStatus.CREATED)
    public void addPlaylists(@RequestBody PlaylistDto playlistDto){
        this.playlistService.create(playlistDto);

    }
}
