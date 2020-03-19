package org.wcci.apimastery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wcci.apimastery.Model.Album;
import org.wcci.apimastery.Model.Artist;
import org.wcci.apimastery.Model.Song;
import org.wcci.apimastery.Storages.Repositories.AlbumRepository;
import org.wcci.apimastery.Storages.Repositories.ArtistRepository;
import org.wcci.apimastery.Storages.Repositories.SongRepository;

@Component
public class Populator implements CommandLineRunner {
    @Autowired
    private ArtistRepository artistRepository;
    @Autowired
    private AlbumRepository albumRepository;
    @Autowired
    private SongRepository songRepository;

    @Override
    public void run(String... args) throws Exception {
      Artist drake = new Artist("Aubrey Graham", 33, "Ontario", "Ovo");
      artistRepository.save(drake);
      Artist rhianna = new Artist("Robyn Rihanna Fenty", 32, "Barbados", "Roc Nation");
      artistRepository.save(rhianna);
      Artist bobMarley = new Artist("Bob Marley", 36, "Jamaica", "Beverly");
      artistRepository.save(bobMarley);
      Artist bts = new Artist("Bantan Sonyeonban", 24, "Korea", "Big Hit");
      artistRepository.save(bts);

      Album scorpion = new Album("Scorpion", "Ovo", "url",drake);
      albumRepository.save(scorpion);
      Album views = new Album("Views", "Ovo", "url",drake);
      albumRepository.save(views);
      Album anti = new Album("Anti", "Roc Nation", "url",rhianna);
      albumRepository.save(anti);
      Album uprising = new Album("Uprising", "Beverly", "url",bobMarley);
      albumRepository.save(uprising);
      Album mapOftheSoul7 = new Album("Map of the Soul:7", "Big Hit", "url",bts);
      albumRepository.save(mapOftheSoul7);

      Song nonStop = new Song("Nonstop", "3:58");
      songRepository.save(nonStop);
      Song work = new Song("Work", "3:39");
      songRepository.save(work);
      Song badCard = new Song("Bad Card", "2:47");
      songRepository.save(badCard);
      Song on = new Song("on", "4:07");
      songRepository.save(on);
    }
}
