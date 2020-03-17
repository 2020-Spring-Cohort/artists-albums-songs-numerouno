package org.wcci.apimastery.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    @RequestMapping("")
    public Collection<Artist> retrievedArtists() {
        return (Collection<Artist>) artistRepository.findAll();
    }

    @GetMapping("/{artistId}")
    public Artist displayArtistFromPostPage(@PathVariable long artistId){
        Artist retrievedArtist = artistStorage.findArtistById(artistId);
        return retrievedArtist;

    }


}
