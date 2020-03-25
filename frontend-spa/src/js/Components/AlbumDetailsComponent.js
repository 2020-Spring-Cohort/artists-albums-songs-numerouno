const renderAlbumDetails = (album) => {
    const albumHolder = document.createElement('div');
    const titleHolder = document.createElement('h3');
    titleHolder.innerText = "Title";
    const albumTitle = document.createElement('h3');
    albumTitle.innerText = album.title;
    const recordLabelHolder = document.createElement('h3');
    recordLabelHolder.innerText = 'Record Label';
    const albumRecordLabel = document.createElement('h3');
    albumRecordLabel.innerText = album.recordLabel;
    const imageHolder = document.createElement('h2');
    imageHolder.innerText = 'Image';
    const albumImage = document.createElement('h2');
    albumImage.innerText = album.image;
    const artistHolder = document.createElement('h3');
    artistlHolder.innerText = 'Artist';
    const albumArtist = document.createElement('h3');
    albumArtist.innerText = album.artist;
    const songHolder = document.createElement('ul');
    albums.songs.forEach(song => {
        const singleSong = document.createElement('li');
        singleSong.innerText = song.title;
        songHolder.appendChild(singleSong);
    });

    albumHolder.appendChild(titleHolder);
    albumHolder.appendChild(albumTitle);
    albumHolder.appendChild(recordLabelHolder);
    albumHolder.appendChild(albumRecordLabel);
    albumHolder.appendChild(imageHolder);
    albumHolder.appendChild(albumImage);
    albumHolder.appendChild(artistlHolder);
    albumHolder.appendChild(albumArtist);
    albumHolder.appendChild(songHolder);

    return albumHolder;
}

export {
    renderAlbumDetails
}

