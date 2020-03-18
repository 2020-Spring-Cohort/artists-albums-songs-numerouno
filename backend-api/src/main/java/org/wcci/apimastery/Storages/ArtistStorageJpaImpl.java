package org.wcci.apimastery.Storages;

import org.springframework.stereotype.Service;
import org.wcci.apimastery.Model.Artist;
import org.wcci.apimastery.Storages.Repositories.ArtistRepository;

import java.util.Collection;

@Service
public class ArtistStorageJpaImpl implements ArtistStorage {

    ArtistRepository artistRepository;

    public ArtistStorageJpaImpl(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public Collection<Artist> getAll() {

        return (Collection<Artist>) artistRepository.findAll();
    }

    @Override
    public void store(Artist artist) {

        artistRepository.save(artist);
    }

    @Override
    public Artist findArtistByName(String name) {

        return artistRepository.findByName(name).get();
    }

    @Override
    public Artist findArtistById(long id) {

        return artistRepository.findById(id).get();
    }

    @Override
    public Artist add(Artist artist) {
        artistRepository.save(artist);

        return artist;
    }

}
