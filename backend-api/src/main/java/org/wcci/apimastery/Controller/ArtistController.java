package org.wcci.apimastery.Controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wcci.apimastery.Artist;
import org.wcci.apimastery.ArtistRepository;

import java.util.Collection;

@RestController
public class ArtistController {

    private ArtistRepository artistRepository;

    public ArtistController(ArtistRepository artistRepository) {
        this. artistRepository = artistRepository;
    }

    @RequestMapping("/artists")
    public Collection<Artist> retrievedArtists() {
        return (Collection<Artist>) artistRepository.findAll();
    }
}
