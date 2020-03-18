package org.wcci.apimastery.ControllerTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.wcci.apimastery.Model.Artist;
import org.wcci.apimastery.Storages.Repositories.ArtistRepository;
import org.wcci.apimastery.Storages.ArtistStorage;

import java.util.Collection;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ArtistControllerTest {

    private ArtistRepository artistRepository;
    private ArtistStorage artistStorage;
    private ArtistController underTest;
    private Artist testArtist;

    @BeforeEach
    void setUp(){
        artistRepository = mock(ArtistRepository.class);

        underTest = new ArtistController(artistRepository,artistStorage);

        underTest = new ArtistController(artistRepository, artistStorage);

        testArtist = new Artist("test",20,"test","test");
        when(artistRepository.findAll()).thenReturn(Collections.singletonList(testArtist));
    }

    @Test
    public void retrievedArtistsReturnsListOfArtistsFromMockRepo(){
        underTest.retrievedArtists();
        verify(artistRepository).findAll();
    }

    @Test
    public void retrievedArtistsReturnsListOfArtistsContainingMockArtist(){
        Collection<Artist> result = underTest.retrievedArtists();
        assertThat(result).contains(testArtist);

    }

    @Test
    public void underTestIsWiredCorrectlyWithAnnotations() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
        mockMvc.perform(get("/artists"))
                .andExpect(status().isOk());

    }
}
