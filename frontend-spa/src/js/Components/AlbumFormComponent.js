import {
    renderArtistDetails
} from './ArtistDetailsComponent.js';



const renderNewAlbumForm = (artist) => {

    const title = document.createElement('p');
    title.innerText = 'Add a new Album';

    const albumTitle = document.createElement('input');
    albumTitle.setAttribute('placeholder', 'Album Title');
    const albumRecordLabel = document.createElement('input');
    albumRecordLabel.setAttribute('placeholder', 'Record Label');
    const albumImage = document.createElement('input');
    albumImage.setAttribute('placeholder', 'Album Image');
    /*  const albumArtist = document.createElement('input');
      albumArtist.setAttribute('placeholder', 'Album Artist');*/

    const submitBtn = document.createElement('button');
    submitBtn.innerText = 'Save';

    title.appendChild(albumTitle);
    title.appendChild(albumRecordLabel);
    title.appendChild(albumImage);
    /* title.appendChild(albumArtist);*/
    title.appendChild(submitBtn);

    submitBtn.addEventListener('click', () => {
        collectData();

    });

    const collectData = () => {

        const album = {
            "title": albumTitle.value,
            "recordLabel": albumRecordLabel.value,
            "image": albumImage.value,
            "artist": {
                "name": artist.name,
                "age": artist.age,
                "homeTown": artist.homeTown,
                "recordLabel": artist.recordLabel
            }

        };
        fetch(`http://localhost:8080/artists/${artist.id}/albums`, {
            method: 'PATCH',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(album)
        }).then(() => renderArtistDetails(artist));

    }

    return title;
}

export {
    renderNewAlbumForm
}