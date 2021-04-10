package com.galvanize.playlist;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.galvanize.playlist.song.SongDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs
public class PlaylistIT {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    PlaylistRepository playlistRepository;

    @Test
    public void getPlaylist() throws Exception {

        //PlaylistDto playlistDto = new PlaylistDto();

        mockMvc.perform(get("/playlists"))
                .andExpect(status().isOk());
    }
    @Test
    public void addPlaylist() throws Exception {

        List<String> songsList = new ArrayList<String>();
        songsList.add("Song1");

        PlaylistDto playlistDto = new PlaylistDto("FirstPlayList", songsList);
        mockMvc.perform(post("/playlists")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(playlistDto)))
                .andExpect(status().isCreated())
                .andDo(document("AddPlaylist"));

        mockMvc.perform(get("/playlists"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("[0].playlistName").value("FirstPlayList"))
                .andDo(document("Playlists", responseFields(
                        fieldWithPath("[0].playlistName").description("FirstPlayList"),
                        fieldWithPath("[0].songs").description("Song1")
                        )
                ));
    }

    @Test
    public void addSongToPlaylist() throws Exception{

        List<String> songsList = new ArrayList<String>();
        songsList.add("Song1");

        playlistRepository.save(new PlaylistEntity("playlist1",songsList));

        mockMvc.perform(post("/playslists/playlist1/addSong/Song2"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/playlists"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("[0].playlistName").value("playlist1"))
                .andExpect(jsonPath("[0].songs[0]").value("Song1"))
                .andExpect(jsonPath("[0].songs[0]").value("Song2"));

    }

}
