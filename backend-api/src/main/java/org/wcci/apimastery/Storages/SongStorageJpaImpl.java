package org.wcci.apimastery.Storages;

import org.springframework.stereotype.Service;
import org.wcci.apimastery.Model.Song;
import org.wcci.apimastery.Storages.Repositories.SongRepository;

import java.util.Collection;

@Service
public class SongStorageJpaImpl implements SongStorage {

    SongRepository songRepository;

    public SongStorageJpaImpl(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public Collection<Song> getAll() {
        return (Collection<Song>) songRepository.findAll();
    }

    @Override
    public void store(Song song) {

        songRepository.save(song);

    }

//    @Override
//    public Song findSongByName(String name) {
//        return songRepository.findSongByName(name).get();
//    }

    @Override
    public Song findSongById(long id) {
        return songRepository.findById(id).get();
    }

}
