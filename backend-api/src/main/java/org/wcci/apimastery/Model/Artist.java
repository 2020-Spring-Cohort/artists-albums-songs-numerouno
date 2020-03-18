package org.wcci.apimastery.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
public class Artist {
    @Id
    @GeneratedValue
    private Long id;
    @OneToMany(mappedBy = "artist")
    private Collection<Album> albums;


    @OneToMany(mappedBy = "artist")
    private Collection<Song> songs;
    private String name;
    private int age;
    private String hometown;
    private String recordLabel;
    private String image;

    protected Artist() {}
    public Artist(String name, int age, String hometown, String recordLabel){
        this.name = name;
        this.age = age;
        this.hometown = hometown;
        this.recordLabel = recordLabel;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getHometown() {
        return hometown;
    }

    public String getRecordLabel() {
        return recordLabel;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Artist artist = (Artist) o;

        if (age != artist.age) return false;
        if (id != null ? !id.equals(artist.id) : artist.id != null) return false;
        if (name != null ? !name.equals(artist.name) : artist.name != null) return false;
        if (hometown != null ? !hometown.equals(artist.hometown) : artist.hometown != null) return false;
        return recordLabel != null ? recordLabel.equals(artist.recordLabel) : artist.recordLabel == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (hometown != null ? hometown.hashCode() : 0);
        result = 31 * result + (recordLabel != null ? recordLabel.hashCode() : 0);
        return result;
    }

    public Collection<Album> getAlbums() {
        return albums;
    }

    public Collection<Song> getSongs() {
        return songs;
    }
}
