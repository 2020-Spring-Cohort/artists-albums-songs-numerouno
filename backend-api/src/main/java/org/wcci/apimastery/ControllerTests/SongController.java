package org.wcci.apimastery.ControllerTests;

import org.springframework.web.bind.annotation.*;
import org.wcci.apimastery.Model.Song;
import org.wcci.apimastery.Storages.Repositories.AlbumRepository;
import org.wcci.apimastery.Storages.Repositories.SongRepository;
import org.wcci.apimastery.Storages.SongStorage;

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
    public void deleteSongs(@PathVariable Long id) {
        songRepository.deleteById(id);

    }

    @PostMapping("")
    public Song createSong(@RequestBody Song songToAdd) {
        return songRepository.save(songToAdd);
    }

    @PatchMapping("/{id}")
    public Song updateManufacturerProducts(@PathVariable Long id, @RequestBody Song requestBodySong) {
        requestBodySong.setId(id);
        return songRepository.save(requestBodySong);
    }


}



