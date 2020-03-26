package org.wcci.apimastery.Controllers;

import org.springframework.web.bind.annotation.*;
import org.wcci.apimastery.Model.Album;
import org.wcci.apimastery.Model.Artist;
import org.wcci.apimastery.Model.Song;
import org.wcci.apimastery.Storages.Repositories.AlbumRepository;
import org.wcci.apimastery.Storages.Repositories.SongRepository;

import java.util.Collection;

@RestController
@RequestMapping("albums")
public class AlbumController {


    private AlbumRepository albumRepository;

    private SongRepository songRepository;


    public AlbumController(AlbumRepository albumRepository, SongRepository songRepository) {

        this.albumRepository = albumRepository;
        this.songRepository = songRepository;

    }

    @GetMapping("")
    public Collection<Album> retrieveAlbums() {
        return (Collection<Album>) albumRepository.findAll();
    }

    @GetMapping("/{id}")
    public Album displaySingleAlbum(@PathVariable long id) {
        return albumRepository.findById(id).get();

    }

    @DeleteMapping("/{id}")
    public Artist deleteAlbum(@PathVariable long id) {
        Album albumToDelete = albumRepository.findById(id).get();

        for (Song songToDelete : albumToDelete.getSongs()) {
            songRepository.delete(songToDelete);
        }

        albumRepository.delete(albumToDelete);

        return albumToDelete.getArtist();

    }

    @PostMapping("")
    public Album creatAlbum(@RequestBody Album albumToAdd) {
        return albumRepository.save(albumToAdd);
    }


    @PatchMapping("/{id}/songs")
    public Album updateAlbum(@RequestBody Song requestBodySong, @PathVariable Long id) {
        Album albumToUpdate = albumRepository.findById(id).get();
        Song songToAdd = new Song(requestBodySong.getTitle(), requestBodySong.getDuration(),albumToUpdate);
        songRepository.save(songToAdd);
        return albumRepository.save(albumToUpdate);

    }

}
