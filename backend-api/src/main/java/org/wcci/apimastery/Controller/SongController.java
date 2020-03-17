package org.wcci.apimastery.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wcci.apimastery.Artist;
import org.wcci.apimastery.Song;
import org.wcci.apimastery.SongRepository;
import org.wcci.apimastery.SongStorage;

import java.util.Collection;

@RestController
public class SongController {
    private SongRepository songRepository;
    private SongStorage songStorage;

    public SongController(SongRepository songRepository) {

        this.songRepository = songRepository;

    }
    @RequestMapping ("/songs")
    public Collection<Song> retrieveSongs() {

        return (Collection<Song>) songRepository.findAll();
    }

    @GetMapping("/{id}")
    public Song displaySongFromPostPage(@PathVariable long id){
        Song retrievedSong = songStorage.findSongById(id);
        return retrievedSong;

    }


}
