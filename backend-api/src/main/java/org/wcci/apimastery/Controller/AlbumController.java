package org.wcci.apimastery.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wcci.apimastery.Album;
import org.wcci.apimastery.AlbumRepository;
import org.wcci.apimastery.Artist;
import org.wcci.apimastery.SongStorage;

import java.util.Collection;

@RestController
@RequestMapping("albums")
public class AlbumController {
    private AlbumRepository albumRepository;



    public AlbumController (AlbumRepository albumRepository) {

        this.albumRepository = albumRepository;
    }
    @GetMapping("")
    public Collection<Album> retrieveAlbums() {
         return (Collection<Album>) albumRepository.findAll();
    }


}
