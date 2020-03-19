package org.wcci.apimastery.ControllerTests;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.*;
import org.wcci.apimastery.Model.Album;
import org.wcci.apimastery.Model.Artist;
import org.wcci.apimastery.Storages.Repositories.AlbumRepository;
import org.wcci.apimastery.Storages.Repositories.ArtistRepository;


import java.util.Collection;

@RestController
@RequestMapping("artists")
public class ArtistController {


   private AlbumRepository albumRepository;

    private ArtistRepository artistRepository;

    public ArtistController(ArtistRepository artistRepository, AlbumRepository albumRepository) {
        this.artistRepository = artistRepository;
        this.albumRepository = albumRepository;
    }

    @GetMapping("")
    public Collection<Artist> retrievedArtists() {
        return (Collection<Artist>) artistRepository.findAll();
    }

    @GetMapping("/{id}")
    public Artist displaySingleArtist(@PathVariable long id) {
        return artistRepository.findById(id).get();

    }

    @DeleteMapping("/{id}")
    public void deleteArtist(@PathVariable Long id) {
        Artist artistToRemove = artistRepository.findById(id).get();

        for (Album albumToRemove : artistToRemove.getAlbums()) {
            albumRepository.delete(albumToRemove);
        }
        artistRepository.deleteById(id);
    }

    @PostMapping("")
    public Artist createArtist(@RequestBody Artist artistToAdd) {
        return artistRepository.save(artistToAdd);
    }

    @PatchMapping("/{id}/albums")
    public Artist updateArtistAlbums(@PathVariable Long id, @RequestBody Album requestBodyAlbum) {
        Artist artistToPatch = artistRepository.findById(id).get();
       Album albumToAdd = new Album(requestBodyAlbum.getTitle(), requestBodyAlbum.getRecordLabel(), requestBodyAlbum.getImage(),artistToPatch);
        albumRepository.save(albumToAdd);
        return artistRepository.save(artistToPatch);
    }

//    @PutMapping("/{id}")
//    public Artist editArtist(@PathVariable Long id,@RequestBody Artist requestBodyArtist) {
//        requestBodyArtist = artistRepository.findById(id).get();
//        return artistRepository.save(requestBodyArtist);
//    }

}



