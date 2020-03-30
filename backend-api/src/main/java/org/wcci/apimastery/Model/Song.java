package org.wcci.apimastery.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Song {

    private String title;
    private String duration;

    @Id
    @GeneratedValue
    private Long id;
    @JsonIgnore
    @ManyToOne
    private Album album;




    protected Song() {
    }

    public Song(String title, String duration, Album album){
        this.title = title;
        this.duration = duration;
        this.album = album;

    }

    public String getTitle() {
        return title;
    }

    public String getDuration() {
        return duration;
    }

    public Long getId() {
        return id;
    }

    public Album getAlbum() {
        return album;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Song song = (Song) o;

        if (title != null ? !title.equals(song.title) : song.title != null) return false;
        if (duration != null ? !duration.equals(song.duration) : song.duration != null) return false;
        if (id != null ? !id.equals(song.id) : song.id != null) return false;
        return album != null ? album.equals(song.album) : song.album == null;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (album != null ? album.hashCode() : 0);
        return result;
    }
}
