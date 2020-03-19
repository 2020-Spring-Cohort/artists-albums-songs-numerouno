package org.wcci.apimastery;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.wcci.apimastery.Model.Album;
import org.wcci.apimastery.Model.Artist;
import org.wcci.apimastery.Storages.Repositories.AlbumRepository;
import org.wcci.apimastery.Storages.Repositories.ArtistRepository;


import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class JpaMappingTest {
    @Autowired
    private ArtistRepository artistRepo;
    @Autowired
    private AlbumRepository albumRepo;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void albumShouldHaveArtist(){


        Artist testArtist = new Artist("Drake", 21, "Houston", "Ovo");
        artistRepo.save(testArtist);


        Album testAlbum1 = new Album("test", "test","imgUrl",testArtist);
        Album testAlbum2 = new Album("test2", "test2","imgUrl",testArtist);
        albumRepo.save(testAlbum1);
        albumRepo.save(testAlbum2);

        entityManager.flush();
        entityManager.clear();

        Artist retrieveArtist = artistRepo.findById(testArtist.getId()).get();
        Album retrieveAlbum1 = albumRepo.findById(testAlbum1.getId()).get();
        Album retrieveAlbum2 = albumRepo.findById(testAlbum2.getId()).get();
        assertThat(retrieveArtist.getAlbums()).contains(retrieveAlbum1,retrieveAlbum2);
    }

}
