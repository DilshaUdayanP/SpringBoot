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
@Table(name = "PlayList_Details")
public class PlayList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Playlist_Ids")
    private String playlist_Ids;

    @Column(name = "user_name")
    private String UserName;

    @Column(name = "playList_name")
    private String PlayList_Name;
}
