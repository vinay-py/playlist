package com.galvanize.playlist;

import lombok.*;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PlaylistDto {
    String playListName;
    List<String> songs;
}
