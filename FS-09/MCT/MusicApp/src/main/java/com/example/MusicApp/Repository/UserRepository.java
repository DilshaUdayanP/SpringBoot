package com.example.MusicApp.Repository;

import com.example.MusicApp.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
