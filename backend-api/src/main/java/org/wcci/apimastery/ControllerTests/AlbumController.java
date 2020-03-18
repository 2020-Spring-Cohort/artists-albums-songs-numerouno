package org.wcci.apimastery.ControllerTests;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wcci.apimastery.Model.Album;
import org.wcci.apimastery.Storages.AlbumStorage;
import org.wcci.apimastery.Storages.Repositories.AlbumRepository;

import java.util.Collection;

@RestController
@RequestMapping("albums")
public class AlbumController {

    private AlbumStorage albumStorage;
    private AlbumRepository albumRepository;



    public AlbumController (AlbumRepository albumRepository,AlbumStorage albumStorage) {

        this.albumRepository = albumRepository;
        this.albumStorage = albumStorage;
    }
    @GetMapping("")
    public Collection<Album> retrieveAlbums() {
         return (Collection<Album>) albumRepository.findAll();
    }

    @GetMapping("/{id}")
    public Album displaySingleAlbum(@PathVariable long id){
        Album retrievedAlbum = albumStorage.findAlbumById(id);
        return retrievedAlbum;

    }


}
