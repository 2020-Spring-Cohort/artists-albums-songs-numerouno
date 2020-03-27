import {
    renderSongDetails
} from './songDetailsComponent.js';

import {
    renderNewSongForm
} from './SongFormComponent.js';


const albumListElement = document.querySelector('.main');
const renderAlbumDetails = (album) => {
    console.log(album)
    while(albumListElement.firstChild) {
        albumListElement.removeChild(albumListElement.firstChild)
    }

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
            const deleteBtn = document.createElement('button');
            deleteBtn.innerText = 'Delete';
            singleSong.appendChild(deleteBtn);
            songHolder.appendChild(singleSong);

            deleteBtn.addEventListener('click', (e) => {
                e.stopPropagation();
    
                fetch(`http://localhost:8080/songs/${song.id}`, {
                method: 'DELETE',
            }).then(response => response.json())
              .then(albumjson => albumListElement.appendChild(renderAlbumDetails(albumjson)))
              
            console.log(`${song.id}`);


        
    
    
            })

            singleSong.addEventListener('click', (e) => {
                e.preventDefault();
                while (albumListElement.firstChild) {
                    albumListElement.removeChild(albumListElement.firstChild);
                }
                albumListElement.appendChild(renderSongDetails(song));
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