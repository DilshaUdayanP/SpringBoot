package com.example.MusicApp.Repository;

import com.example.MusicApp.Model.Music;
import com.example.MusicApp.Model.PlayList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepository extends JpaRepository<PlayList, Long> {
}
