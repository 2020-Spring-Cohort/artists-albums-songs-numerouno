package org.wcci.apimastery.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wcci.apimastery.Song;
import org.wcci.apimastery.SongRepository;

import java.util.Collection;

@RestController
public class SongController {
    private SongRepository songRepository;

    public SongController(SongRepository songRepository) {

        this.songRepository = songRepository;

    }
    @RequestMapping ("/songs")
    public Collection<Song> retrieveSongs() {

        return (Collection<Song>) songRepository.findAll();
    }


}
