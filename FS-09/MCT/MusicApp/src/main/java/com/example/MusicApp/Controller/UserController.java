package com.example.MusicApp.Controller;

import com.example.MusicApp.Exception.ResourceNotFoundException;
import com.example.MusicApp.Model.Music;
import com.example.MusicApp.Model.PlayList;
import com.example.MusicApp.Model.User;
import com.example.MusicApp.Repository.MusicRepository;
import com.example.MusicApp.Repository.PlaylistRepository;
import com.example.MusicApp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/SongList")
public class UserController {
    @Autowired
    private MusicRepository music_repository;
    private UserRepository user_repository;
    private PlaylistRepository playlist_repository;

    //Get all music details
    @GetMapping("/ListAllSong")
    public List<Music> getAllmusicDetails(){
        return music_repository.findAll();
    }

    @GetMapping("/ListAllPlayList")
    public List<PlayList> getAllplaylist(){
        return playlist_repository.findAll();
    }

    //create a new music
    @PostMapping("/createPlayList/UserId/{id}")
    public ResponseEntity<PlayList> createNewplaylist(@RequestBody PlayList playlist, @PathVariable long id)
    {
        User user = user_repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found to update your changes"));
        if(user.getRole()=="User")
        {
            return ResponseEntity.ok(playlist);
        }
        else
        {
            throw new ResourceNotFoundException("You have no permission to create new playlist");
        }
    }

    //show selected music
    @GetMapping("selectedmusic/{id}")
    public ResponseEntity<Music> getmusicById(@PathVariable long id)
    {
        Music music = music_repository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Music not exist. Please check the ID"));
        return ResponseEntity.ok(music);
    }

    @GetMapping("selectedplaylist/{id}")
    public ResponseEntity<PlayList> getplaylistyId(@PathVariable long id)
    {
        PlayList playlist = playlist_repository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Playlist not exist. Please check the ID"));
        return ResponseEntity.ok(playlist);
    }

    //delete the music
    @DeleteMapping("deleteplaylist/{id}")
    public ResponseEntity<HttpStatus> deleteplaylist(@PathVariable long id)
    {
        User user = user_repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found to update your changes"));
        PlayList playlist = playlist_repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Playlist not found to update your changes"));

        if(user.getRole()=="User")
        {
            playlist_repository.delete(playlist);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else
        {
            throw new ResourceNotFoundException("You have no permission to delete the existing playlist");
        }
    }

    //update music role
    @RequestMapping(value = "/updateplaylist/{id}",
            produces = "application/json",
            method=RequestMethod.PUT)
    public ResponseEntity<PlayList> updateplaylist(@PathVariable long id, @RequestBody PlayList playlistdetails)
    {
        User user = user_repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found to update your changes"));
        PlayList playlist = playlist_repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Playlist not found to update your changes"));

        if(user.getRole()=="Admin")
        {
            playlist.setPlayList_Name(playlistdetails.getPlayList_Name());
            playlist.setPlaylist_Ids(playlistdetails.getPlaylist_Ids());
            playlist.setUserName(playlistdetails.getUserName());
            playlist_repository.save(playlist);
            return ResponseEntity.ok(playlist);
        }
        else
        {
            throw new ResourceNotFoundException("You have no permission to update the existing playlist");
        }
    }
}
