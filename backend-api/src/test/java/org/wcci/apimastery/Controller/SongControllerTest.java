package org.wcci.apimastery.Controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.wcci.apimastery.Album;
import org.wcci.apimastery.Artist;
import org.wcci.apimastery.Song;
import org.wcci.apimastery.SongRepository;

import java.util.Collection;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class SongControllerTest {

    private SongRepository songRepository;
    private SongController underTest;
    private Song testSong;

    @BeforeEach
    void setUp() {
        songRepository = mock(SongRepository.class);
        underTest = new SongController(songRepository);
        Artist testArtist = new Artist("test",20,"test","test");
        Album testAlbum = new Album("test","test",testArtist);
        testSong = new Song ("Test", "Test", testArtist, testAlbum);
        when(songRepository.findAll()).thenReturn(Collections.singletonList(testSong));
    }
    @Test
    public void retrieveSongReturnsListofSongsFromMockRepo() {
        underTest.retrieveSongs();
        verify(songRepository).findAll();
    }
    @Test
    public void retrieveSongsReturnsListOfSongsContainingMockSongs(){
        Collection<Song> result = underTest.retrieveSongs();
        assertThat(result).contains(testSong);
    }
    @Test
    public void underTestIsWiredCorrectlyWithAnnotations() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
        mockMvc.perform(get("/songs"))
        .andExpect(status().isOk());
    }

}
