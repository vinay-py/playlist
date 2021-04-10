package com.galvanize.playlist;

import com.galvanize.playlist.song.SongEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
public class PlaylistEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String playlistName;

    @ElementCollection
    @CollectionTable(name="song", joinColumns=@JoinColumn(name="playlist_id"))
    @Column(name="songs")
    private List<String> songs;

    public PlaylistEntity(String playlistName, List<String> songs) {

        this.playlistName = playlistName;
        this.songs = songs;
    }

    public void addSong(String songName){
        this.songs.add(songName);
    }
}
