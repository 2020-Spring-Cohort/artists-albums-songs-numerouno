package org.wcci.apimastery.Storages;

import org.wcci.apimastery.Model.Song;

import java.util.Collection;

public interface SongStorage {

    Collection<Song> getAll();
    void store(Song song);
//    Song findSongByName(String name);
    Song findSongById(long id);



}
