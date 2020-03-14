package org.wcci.apimastery.Controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.wcci.apimastery.Album;
import org.wcci.apimastery.AlbumRepository;
import org.wcci.apimastery.Artist;

import java.util.Collection;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AlbumControllerTest {

    private AlbumRepository albumRepository;
    private AlbumController underTest;
    private Album testAlbum;

    @BeforeEach
    void setUp(){
        albumRepository = mock(AlbumRepository.class);
        underTest = new AlbumController(albumRepository);
        Artist testArtist = new Artist("Test", 20, "test", "test");
        testAlbum = new Album("Test", "Test", testArtist);
        when(albumRepository.findAll()).thenReturn(Collections.singletonList(testAlbum));

    }
    @Test
    public void retrieveAlbumReturnsListOfAlbumFromMockRepo() {
        underTest.retrieveAlbums();
        verify(albumRepository).findAll();
    }
    @Test
    public void retrieveAlbumsReturnListOfAlbumsContainingMockAlbum(){
        Collection<Album> result = underTest.retrieveAlbums();
        assertThat(result).contains(testAlbum);
    }
    @Test
    public void underTestIsWiredCorrectlyWithoutAnnotations() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
        mockMvc.perform(get("/albums"))
                .andExpect(status().isOk());
    }
}
