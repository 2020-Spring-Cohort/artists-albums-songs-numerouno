package org.wcci.apimastery.Controller;


import org.springframework.web.bind.annotation.*;
import org.wcci.apimastery.Artist;
import org.wcci.apimastery.ArtistRepository;
import org.wcci.apimastery.ArtistStorage;

import java.util.Collection;

@RestController
@RequestMapping("artists")
public class ArtistController {
    private ArtistStorage artistStorage;

    private ArtistRepository artistRepository;

    public ArtistController(ArtistRepository artistRepository,ArtistStorage artistStorage) {
        this. artistRepository = artistRepository;
        this.artistStorage = artistStorage;
    }

    @GetMapping("")
    public Collection<Artist> retrievedArtists() {
        return (Collection<Artist>) artistRepository.findAll();
    }

    @GetMapping("/{id}")
    public Artist displayArtistFromPostPage(@PathVariable long id){
        Artist retrievedArtist = artistStorage.findArtistById(id);
        return retrievedArtist;

    }
    @PostMapping("add")
    public Artist AddArtistForm(@RequestParam String name, int age, String hometown, String recordLabel){
        Artist addArtist = artistStorage.add(new Artist(name, age, hometown, recordLabel));
        return addArtist;
    }



}
