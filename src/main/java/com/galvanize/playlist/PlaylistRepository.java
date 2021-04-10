package com.galvanize.playlist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistRepository extends JpaRepository<PlaylistEntity,Long>{

    PlaylistEntity findByName(String name);
}
