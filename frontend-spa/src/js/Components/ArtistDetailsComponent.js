import {
    renderAlbumDetails
} from './AlbumDetailsComponent.js';
import {
    renderNewAlbumForm
} from './AlbumFormComponent.js';

const artistListElement = document.querySelector('.main');

const renderArtistDetails = (artist) => {
    const artistHolder = document.createElement('div');
    const nameHolder = document.createElement('h3');
    nameHolder.innerText = 'Name';
    const artistName = document.createElement('h4');
    artistName.innerText = artist.name;
    const ageHolder = document.createElement('h3');
    ageHolder.innerText = 'Age';
    const artistAge = document.createElement('h4');
    artistAge.innerText = artist.age;
    const homeTownHolder = document.createElement('h3');
    homeTownHolder.innerText = 'Hometown';
    const artistHomeTown = document.createElement('h4');
    artistHomeTown.innerText = artist.homeTown;
    const recordLabelHolder = document.createElement('h3');
    recordLabelHolder.innerText = 'Record Label';
    const artistRecordLabel = document.createElement('h4');
    artistRecordLabel.innerText = artist.recordLabel;
    const albumHolder = document.createElement('ul');

    artist.albums.forEach((album) => {
        const singleAlbum = document.createElement('li');
        singleAlbum.innerText = album.title;
        albumHolder.appendChild(singleAlbum);





        singleAlbum.addEventListener('click', (e) => {
            e.preventDefault();
            artistListElement.innerHTML = '';

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