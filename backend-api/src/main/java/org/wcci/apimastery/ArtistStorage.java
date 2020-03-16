package org.wcci.apimastery;

import java.util.Collection;

public interface ArtistStorage {
    Collection<Artist> getAll();
    void store(Artist artist);
    Artist findArtistByName(String name);
    Artist findArtistById(long artistId);
}

