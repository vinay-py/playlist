package com.galvanize.playlist;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PlaylistIT {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void getPlaylist() throws Exception {

        //PlaylistDto playlistDto = new PlaylistDto();

        mockMvc.perform(get("/playlists"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("length()").value(1));
    }
    @Test
    public void addPlaylist() throws Exception {

        List<String> songs= new ArrayList<>();
        songs.add("song1");

        PlaylistDto playlistDto = new PlaylistDto("FirstPlayList",songs);
        mockMvc.perform(post("/playlists")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(playlistDto)))
                .andExpect(status().isCreated());

        mockMvc.perform(get("/playlists"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("[0].playListName").value("FirstPlayList"));
    }

}
