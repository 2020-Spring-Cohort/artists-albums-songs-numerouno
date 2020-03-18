package org.wcci.apimastery.ControllerTests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.wcci.apimastery.Model.Album;
import org.wcci.apimastery.Model.Song;
import org.wcci.apimastery.Storages.AlbumStorage;
import org.wcci.apimastery.Storages.Repositories.AlbumRepository;
import org.wcci.apimastery.Storages.Repositories.SongRepository;

import javax.tools.FileObject;
import java.util.Collection;

@RestController

public class AlbumController {

    private AlbumStorage albumStorage;
    private AlbumRepository albumRepository;
    @Autowired
    private SongRepository songRepository;


    public AlbumController(AlbumRepository albumRepository, AlbumStorage albumStorage) {

        this.albumRepository = albumRepository;
        this.albumStorage = albumStorage;
    }

    @GetMapping("/albums/")
    public Collection<Album> retrieveAlbums() {

        return (Collection<Album>) albumRepository.findAll();
    }

    @GetMapping("/albums/{id}/")
    public Album displaySingleAlbum(@PathVariable long id) {
        Album retrievedAlbum = albumStorage.findAlbumById(id);
        return retrievedAlbum;

    }

    @DeleteMapping("/albums/{id}/")
    public void deleteAlbum(@PathVariable long id) {
        Album albumToRemove = albumRepository.findById(id).get();

        for (Song songToRemove : albumToRemove.getSongs()) {
            songRepository.delete(songToRemove);
        }
        albumRepository.deleteById(id);
    }

    //    @PostMapping("")
//    public Album createAlbum(@RequestBody Album albumToAdd ) {
//        return albumRepository.save(albumToAdd);
//    }
    @PostMapping("/albums/")
    public Album creatAlbum(@RequestBody Album albumToAdd) {
        return albumRepository.save(albumToAdd);
    }
}
