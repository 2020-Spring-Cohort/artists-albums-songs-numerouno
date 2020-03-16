package org.wcci.apimastery.Controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wcci.apimastery.Artist;
import org.wcci.apimastery.ArtistRepository;
import org.wcci.apimastery.ArtistStorage;

import java.util.Collection;

@RestController
public class ArtistController {
    private ArtistStorage artistStorage;

    private ArtistRepository artistRepository;

    public ArtistController(ArtistRepository artistRepository) {
        this. artistRepository = artistRepository;
    }

    @RequestMapping("/artists")
    public Collection<Artist> retrievedArtists() {
        return (Collection<Artist>) artistRepository.findAll();
    }

    @GetMapping("/{artistId}")
    public String displayArtistFromPostPage(@PathVariable long artistId, Model model){
        Artist retrievedArtist = artistStorage.findArtistById(artistId);
        model.addAttribute("artist", retrievedArtist);
        return "artist";
    }
}
