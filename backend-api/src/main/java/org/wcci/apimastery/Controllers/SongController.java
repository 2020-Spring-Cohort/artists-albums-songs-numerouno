package org.wcci.apimastery.Controllers;

import org.springframework.web.bind.annotation.*;
import org.wcci.apimastery.Model.Album;
import org.wcci.apimastery.Model.Song;
import org.wcci.apimastery.Storages.Repositories.AlbumRepository;
import org.wcci.apimastery.Storages.Repositories.SongRepository;

import java.util.Collection;

@RestController
@RequestMapping("songs")
public class SongController {

    private SongRepository songRepository;
    private AlbumRepository albumRepository;

    public SongController(SongRepository songRepository, AlbumRepository albumRepository) {
        this.songRepository = songRepository;
        this.albumRepository = albumRepository;

    }

    @RequestMapping("")
    public Collection<Song> retrieveSongs() {

        return (Collection<Song>) songRepository.findAll();
    }

    @GetMapping("/{id}")
    public Song displaySingleSong(@PathVariable long id) {
        return songRepository.findById(id).get();
    }

    @DeleteMapping("/{id}")
    public Album deleteSongs(@PathVariable Long id) {
        Song songToDelete = songRepository.findById(id).get();
        songRepository.deleteById(id);

        return songToDelete.getAlbum();

    }

    @PostMapping("")
    public Song createSong(@RequestBody Song songToAdd) {
        return songRepository.save(songToAdd);
    }

    @PatchMapping("/{id}")
    public Song updateAlbumSongs(@PathVariable Long id, @RequestBody Song requestBodySong) {
        requestBodySong.setId(id);
        return songRepository.save(requestBodySong);
    }


}



