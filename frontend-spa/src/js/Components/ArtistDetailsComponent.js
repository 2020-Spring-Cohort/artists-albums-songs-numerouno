import {
    renderAlbumDetails
} from './AlbumDetailsComponent.js';
import {
    renderNewAlbumForm
} from './AlbumFormComponent.js';



const artistListElement = document.querySelector('.main');

const renderArtistDetails = (artist) => {
    console.log(artist)
    while (artistListElement.firstChild) {
        artistListElement.removeChild(artistListElement.firstChild)
    }
    const artistHolder = document.createElement('div');
    artistHolder.classList.add('singleArtist');
    const nameHolder = document.createElement('h3');
    nameHolder.innerText = 'Name:';
    const artistName = document.createElement('span');
    artistName.innerText = artist.name;
    const ageHolder = document.createElement('h3');
    ageHolder.innerText = 'Age:';
    const artistAge = document.createElement('span');
    artistAge.innerText = artist.age;
    const homeTownHolder = document.createElement('h3');
    homeTownHolder.innerText = 'Hometown:';
    const artistHomeTown = document.createElement('span');
    artistHomeTown.innerText = artist.homeTown;
    const recordLabelHolder = document.createElement('h3');
    recordLabelHolder.innerText = 'Record Label:';
    const artistRecordLabel = document.createElement('span');
    artistRecordLabel.innerText = artist.recordLabel;
    const albumHolder = document.createElement('ol');
    albumHolder.innerText = 'List of Albums';

    artist.albums.forEach((album) => {
        const singleAlbum = document.createElement('li');
        singleAlbum.innerText = album.title;
        const deleteBtn = document.createElement('button');
        deleteBtn.innerText = 'Delete';
        singleAlbum.appendChild(deleteBtn);
        albumHolder.appendChild(singleAlbum);

        deleteBtn.addEventListener('click', (e) => {
            e.stopPropagation();

            fetch(`http://localhost:8080/albums/${album.id}`, {
                    method: 'DELETE',
                }).then(response => response.json())
                .then(artistjson => artistListElement.appendChild(renderArtistDetails(artistjson)))

            console.log(`${album.id}`);


        })

        singleAlbum.addEventListener('click', (e) => {
            e.preventDefault();
            console.log('test');
            console.log(album);
            while (artistListElement.firstChild) {
                artistListElement.removeChild(artistListElement.firstChild);
            }
            artistListElement.appendChild(renderAlbumDetails(album));

        });

    });

    artistHolder.appendChild(nameHolder);
    artistHolder.appendChild(artistName);
    artistHolder.appendChild(ageHolder);
    artistHolder.appendChild(artistAge);
    artistHolder.appendChild(homeTownHolder);
    artistHolder.appendChild(artistHomeTown);
    artistHolder.appendChild(recordLabelHolder);
    artistHolder.appendChild(artistRecordLabel);
    artistHolder.appendChild(albumHolder);

    artistHolder.appendChild(renderNewAlbumForm(artist));

    return artistHolder;
};

export {
    renderArtistDetails
};