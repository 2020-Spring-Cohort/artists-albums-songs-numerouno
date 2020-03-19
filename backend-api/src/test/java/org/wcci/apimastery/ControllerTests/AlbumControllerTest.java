package org.wcci.apimastery.ControllerTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.wcci.apimastery.Model.Album;
import org.wcci.apimastery.Storages.AlbumStorage;
import org.wcci.apimastery.Storages.Repositories.AlbumRepository;
import org.wcci.apimastery.Model.Artist;
import org.wcci.apimastery.Storages.Repositories.SongRepository;

import java.util.Collection;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AlbumControllerTest {
    private SongRepository songRepository;
    private AlbumRepository albumRepository;
    private AlbumStorage albumStorage;
    private AlbumController underTest;
    private Album testAlbum;

    @BeforeEach
    void setUp(){
        albumRepository = mock(AlbumRepository.class);
        underTest = new AlbumController(albumRepository,songRepository);
        Artist testArtist = new Artist("Test", 20, "test", "test");
        testAlbum = new Album("Test", "Test", "imageUrl",testArtist);
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
        mockMvc.perform(get("/albums/"))
                .andExpect(status().isOk());
    }
}
