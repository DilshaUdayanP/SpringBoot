package com.example.MusicApp.Repository;

import com.example.MusicApp.Model.Music;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicRepository extends JpaRepository<Music,Long>{

}
