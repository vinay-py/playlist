package com.galvanize.playlist;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class PlaylistTest {

    @Mock
    PlaylistRepository mockPlaylistRepository;

    @InjectMocks
    PlaylistService subject;

    @Test
    void createPlaylist(){
        PlaylistDto playlistDto =
                new PlaylistDto("FirstPlayList", "song1");
        subject.create(playlistDto);

        verify(mockPlaylistRepository).save(
                new PlaylistEntity("FirstPlayList", "song1")
        );
    }
}
