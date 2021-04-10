package com.galvanize.playlist;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
@EqualsAndHashCode
public class PlaylistEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String playListName;
    List<String> songs;

    public PlaylistEntity(String playlistName, List<String> songs){
        this.playListName=playlistName;
        this.songs=songs;
    }
}
