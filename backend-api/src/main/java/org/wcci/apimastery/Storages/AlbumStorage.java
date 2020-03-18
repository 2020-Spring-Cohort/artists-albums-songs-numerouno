package org.wcci.apimastery.Storages;

import org.wcci.apimastery.Model.Album;

import java.util.Collection;

public interface AlbumStorage {

    Collection<Album> getAll();
    void store(Album album);
//    Album findAlbumByName(String name);
    Album findAlbumById(long id);

}
