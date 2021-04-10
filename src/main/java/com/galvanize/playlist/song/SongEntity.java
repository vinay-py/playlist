package com.galvanize.playlist.song;

import com.galvanize.playlist.PlaylistEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SongEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long song_id;
    String songName;
}
