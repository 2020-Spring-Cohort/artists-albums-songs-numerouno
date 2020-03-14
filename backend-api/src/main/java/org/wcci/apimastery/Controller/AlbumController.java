package org.wcci.apimastery.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wcci.apimastery.Album;
import org.wcci.apimastery.AlbumRepository;

import java.util.Collection;

@RestController
public class AlbumController {
    private AlbumRepository albumRepository;

    public AlbumController (AlbumRepository albumRepository) {

        this.albumRepository = albumRepository;
    }
    @RequestMapping("/albums")
    public Collection<Album> retrieveAlbums() {
         return (Collection<Album>) albumRepository.findAll();
    }

}
