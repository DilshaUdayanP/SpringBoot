package com.example.MusicApp.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Music_Details")
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "song_name")
    private String SongName;

    @Column(name = "song_type")
    private String SongType;

    @Column(name = "user_name")
    private String UserName;

    @Column(name = "singer_name")
    private String SingerName;
}
