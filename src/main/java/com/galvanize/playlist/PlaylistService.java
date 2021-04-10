package com.galvanize.playlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaylistService {

    public final PlaylistRepository playlistRepository;

    @Autowired
    public PlaylistService(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    public void create(PlaylistDto playlistDto) {
        playlistRepository.save(
                new PlaylistEntity(playlistDto.getPlayListName(),
                        playlistDto.getSongs())
        );
    }
}
