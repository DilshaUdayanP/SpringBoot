package com.example.MusicApp.Controller;

import com.example.MusicApp.Exception.ResourceNotFoundException;
import com.example.MusicApp.Model.Music;
import com.example.MusicApp.Model.User;
import com.example.MusicApp.Repository.MusicRepository;
import com.example.MusicApp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/UserMusic")
public class AdminController {
    @Autowired
    private MusicRepository music_repository;
    private UserRepository user_repository;

    //Get all music details
    @GetMapping("/ListAllSong")
    public List<Music> getAllmusicDetails(){
        return music_repository.findAll();
    }

    //create a new music
    //@Conditional(VerifyTheUserCondition.class)
    @PostMapping("/createMusic/UserId/{id}")
    public ResponseEntity<Music> createNewmusic(@RequestBody Music music, @PathVariable long id)
    {
        User user = user_repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found to update your changes"));
        if(user.getRole()=="Admin")
        {
           return ResponseEntity.ok(music);
        }
        else
        {
            throw new ResourceNotFoundException("You have no permission to add new song");
        }
    }

    //show selected music
    @GetMapping("selectedmusic/{id}")
    public ResponseEntity<Music> getmusicById(@PathVariable long id)
    {
        Music music = music_repository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("music not exist. Please check the ID"));
        return ResponseEntity.ok(music);
    }

    //delete the music
    @DeleteMapping("deletemusic/{id}")
    public ResponseEntity<HttpStatus> deletemusic(@PathVariable long id)
    {
        User user = user_repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found to update your changes"));
        Music music = music_repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Music not found to update your changes"));

        if(user.getRole()=="Admin")
        {
            music_repository.delete(music);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else
        {
            throw new ResourceNotFoundException("You have no permission to delete the existing song");
        }
    }

    //update music role
    @PutMapping("updatemusic/{id}")
    public ResponseEntity<Music> updatemusic(@PathVariable long id, @RequestBody Music musicdetails)
    {
        User user = user_repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found to update your changes"));
        Music music = music_repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Music not found to update your changes"));

        if(user.getRole()=="Admin")
        {
            music.setSongName(musicdetails.getSongName());
            music.setSingerName(musicdetails.getSingerName());
            music.setSongType(musicdetails.getSongType());
            music.setUserName(musicdetails.getUserName());
            music_repository.save(music);
            return ResponseEntity.ok(music);
        }
        else
        {
            throw new ResourceNotFoundException("You have no permission to update the existing song");
        }
    }
}
