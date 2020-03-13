package org.wcci.apimastery;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Album {
    @Id
    @GeneratedValue
    private Long id;
    private String title;

    @JsonIgnore
    @OneToMany (mappedBy ="album")
    private Collection<Song> songs;
    private String recordLabel;
    @ManyToOne
    private Artist artist;
    protected Album() {}

    public Album(String title, String recordLabel, Artist artist) {
        this.title = title;
        this.recordLabel = recordLabel;
        this.artist = artist;
    }
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Album album = (Album) o;

        if (id != null ? !id.equals(album.id) : album.id != null) return false;
        if (title != null ? !title.equals(album.title) : album.title != null) return false;
        if (recordLabel != null ? !recordLabel.equals(album.recordLabel) : album.recordLabel != null) return false;
        return artist != null ? artist.equals(album.artist) : album.artist == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (recordLabel != null ? recordLabel.hashCode() : 0);
        result = 31 * result + (artist != null ? artist.hashCode() : 0);
        return result;
    }

    public String getRecordLabel() {
        return recordLabel;
    }


}
