package com.galvanize.playlist.song;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SongsRepository extends JpaRepository<SongEntity, Long> {
}
