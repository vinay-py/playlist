package com.galvanize.playlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlaylistService {

    public final PlaylistRepository playlistRepository;

    @Autowired
    public PlaylistService(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    public void create(PlaylistDto playlistDto) {
        playlistRepository.save(
                new PlaylistEntity(playlistDto.getPlaylistName(),
                        playlistDto.getSongs())
        );
    }

    public List<PlaylistDto> fetchAll(){
        return playlistRepository.findAll()
                .stream()
                .map(playlistEntity -> {
                    return new PlaylistDto(playlistEntity.getPlaylistName()
                    ,playlistEntity.getSongs());
                        }

                ).collect(Collectors.toList());
    }
}
