package org.wcci.apimastery.ControllerTests;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.*;
import org.wcci.apimastery.Model.Artist;
import org.wcci.apimastery.Storages.Repositories.ArtistRepository;
import org.wcci.apimastery.Storages.ArtistStorage;

import java.util.Collection;

@RestController
@RequestMapping("artists")
public class ArtistController {


    private ArtistStorage artistStorage;

    private ArtistRepository artistRepository;

    public ArtistController(ArtistRepository artistRepository, ArtistStorage artistStorage) {
        this.artistRepository = artistRepository;
        this.artistStorage = artistStorage;
    }

    @GetMapping("")
    public Collection<Artist> retrievedArtists() {
        return (Collection<Artist>) artistRepository.findAll();
    }

    @GetMapping("/{id}")
    public Artist displaySingleArtist(@PathVariable long id) {
        Artist retrievedArtist = artistStorage.findArtistById(id);
        return retrievedArtist;

    }

    @PostMapping("add")
    public Artist AddArtist(@RequestParam String name, int age, String hometown, String recordLabel) {
        Artist addArtist = artistStorage.add(new Artist(name, age, hometown, recordLabel));
        return addArtist;
    }

}



