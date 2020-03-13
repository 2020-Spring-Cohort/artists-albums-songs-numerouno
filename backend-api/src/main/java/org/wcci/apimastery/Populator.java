package org.wcci.apimastery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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

      Album scorpion = new Album("Scorpion", "Ovo", drake);
      albumRepository.save(scorpion);
      Album anti = new Album("Anti", "Roc Nation", rhianna);
      albumRepository.save(anti);
      Album uprising = new Album("Uprising", "Beverly", bobMarley);
      albumRepository.save(uprising);
      Album mapOftheSoul7 = new Album("Map of the Soul:7", "Big Hit", bts);
      albumRepository.save(mapOftheSoul7);

      Song nonStop = new Song("Nonstop", "3:58", drake, scorpion);
      songRepository.save(nonStop);
      Song work = new Song("Work", "3:39", rhianna, anti);
      songRepository.save(work);
      Song badCard = new Song("Bad Card", "2:47", bobMarley, uprising);
      songRepository.save(badCard);
      Song on = new Song("on", "4:07", bts, mapOftheSoul7);
      songRepository.save(on);
    }
}
