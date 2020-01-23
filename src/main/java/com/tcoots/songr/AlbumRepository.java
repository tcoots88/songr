package com.tcoots.songr;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlbumRepository extends JpaRepository<Album, Long> {
    public List<Album> findByTitle(String albumName);
}
