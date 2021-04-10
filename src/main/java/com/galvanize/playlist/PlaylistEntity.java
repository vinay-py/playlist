package com.galvanize.playlist;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlaylistEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String playlistName;
    String songs;

    public PlaylistEntity(String playlistName, String songs){
        this.playlistName=playlistName;
        this.songs=songs;
    }
}
