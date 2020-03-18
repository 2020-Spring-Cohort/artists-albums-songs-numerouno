package org.wcci.apimastery.ControllerTests;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wcci.apimastery.Model.Song;
import org.wcci.apimastery.Storages.Repositories.SongRepository;
import org.wcci.apimastery.Storages.SongStorage;

import java.util.Collection;

@RestController
@RequestMapping("songs")
public class SongController {

    private SongRepository songRepository;
    private SongStorage songStorage;

    public SongController(SongRepository songRepository,SongStorage songStorage) {
        this.songRepository = songRepository;
        this.songStorage = songStorage;

    }
    @RequestMapping ("")
    public Collection<Song> retrieveSongs() {

        return (Collection<Song>) songRepository.findAll();
    }

    @GetMapping("/{id}")
    public Song displaySingleSong(@PathVariable long id){
        Song retrievedSong = songStorage.findSongById(id);
        return retrievedSong;

    }


}
