import {
    renderSongDetails
} from './songDetailsComponent.js';

import {
    renderNewSongForm
} from './SongFormComponent.js';


const songElement = document.querySelector('.main');
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

    const songHolder = document.createElement('ul');
    if (album.songs) {
        album.songs.forEach(song => {
            const singleSong = document.createElement('li');
            singleSong.innerText = song.title;
            songHolder.appendChild(singleSong);

            singleSong.addEventListener('click', (e) => {
                e.preventDefault();
                while (songElement.firstChild) {
                    songElement.removeChild(songElement.firstChild);
                }
                songElement.appendChild(renderSongDetails(song));
            })
        });
    }
    albumHolder.appendChild(titleHolder);
    albumHolder.appendChild(albumTitle);
    albumHolder.appendChild(recordLabelHolder);
    albumHolder.appendChild(albumRecordLabel);
    albumHolder.appendChild(imageHolder);
    albumHolder.appendChild(albumImage);

    albumHolder.appendChild(songHolder);
    albumHolder.appendChild(renderNewSongForm(album));

    return albumHolder;
}

export {
    renderAlbumDetails
}