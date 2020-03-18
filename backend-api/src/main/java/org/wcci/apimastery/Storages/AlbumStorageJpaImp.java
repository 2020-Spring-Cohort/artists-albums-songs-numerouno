package org.wcci.apimastery.Storages;

import org.springframework.stereotype.Service;
import org.wcci.apimastery.Model.Album;
import org.wcci.apimastery.Storages.Repositories.AlbumRepository;

import java.util.Collection;

@Service
public class AlbumStorageJpaImp implements AlbumStorage {

    AlbumRepository albumRepository;

    public AlbumStorageJpaImp(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public Collection<Album> getAll() {
        return (Collection<Album>) albumRepository.findAll();
    }

    @Override
    public void store(Album album) {

        albumRepository.save(album);

    }

//    @Override
//    public Album findAlbumByName(String name) {
//        return albumRepository.findAlbumByName(name).get();
//    }

    @Override
    public Album findAlbumById(long id) {
        return albumRepository.findById(id).get();
    }
}
