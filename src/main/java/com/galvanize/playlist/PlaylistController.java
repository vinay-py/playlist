package com.galvanize.playlist;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlaylistController {
    List<PlaylistDto> playList;
    public PlaylistController(List<PlaylistDto> playList){
        this.playList=playList;
    }

    @GetMapping("playlists")
    public List<PlaylistDto> getPlaylists(){
        return playList;
    }

    @PostMapping("playlists")
    @ResponseStatus(HttpStatus.CREATED)
    public void addPlaylists(@RequestBody PlaylistDto playlistDto){
    playList.add(playlistDto);

    }
}
