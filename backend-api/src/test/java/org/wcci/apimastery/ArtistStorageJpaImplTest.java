package org.wcci.apimastery;

import org.junit.jupiter.api.Test;
import org.wcci.apimastery.Model.Artist;
import org.wcci.apimastery.Storages.ArtistStorage;
import org.wcci.apimastery.Storages.ArtistStorageJpaImpl;
import org.wcci.apimastery.Storages.Repositories.ArtistRepository;

import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ArtistStorageJpaImplTest {

    @Test
    public void shouldStoreArtist() {
        ArtistRepository artistRepository = mock(ArtistRepository.class);
        ArtistStorage storage = new ArtistStorageJpaImpl(artistRepository);
        Artist testArtist = new Artist("user", 33,"test","test");
        when(artistRepository.findAll()).thenReturn(Collections.singletonList(testArtist));
        storage.store(testArtist);
        verify(artistRepository).save(testArtist);
        assertThat(storage.getAll()).contains(testArtist);
    }
    @Test
    public void shouldRetrieveSingleArtistByName() {
        ArtistRepository mockRepo = mock(ArtistRepository.class);
        Artist testArtist1 = new Artist("user",33,"test","test");
        Artist testArtist2 = new Artist("user2",33,"test","test");
        ArtistStorage underTest = new ArtistStorageJpaImpl(mockRepo);
        underTest.store(testArtist1);
        underTest.store(testArtist2);
        Optional<Artist> testArtist1Optional = Optional.of(testArtist1);
        when(mockRepo.findByName("user")).thenReturn(testArtist1Optional);
        Optional<Artist> testArtist2Optional = Optional.of(testArtist2);
        when(mockRepo.findByName("user2")).thenReturn(testArtist2Optional);
        Artist retrievedArtist1 = underTest.findArtistByName("user");
        Artist retrievedArtist2 = underTest.findArtistByName("user2");
        assertThat(retrievedArtist1).isEqualTo(testArtist1);
        assertThat(retrievedArtist2).isEqualTo(testArtist2);
    }
}
