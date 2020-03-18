package org.wcci.apimastery.Storages;

import org.wcci.apimastery.Model.Artist;

import java.util.Collection;

public interface ArtistStorage {
    Collection<Artist> getAll();
    void store(Artist artist);
    Artist findArtistByName(String name);
    Artist findArtistById(long artistId);

    Artist add(Artist artist);
}

