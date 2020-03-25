import {
    renderAlbum
} from './AlbumListComponent.js';



const renderNewAlbumForm = () => {

    const title = document.createElement('p');
    title.innerText = 'Add a new Album';

    const albumTitle = document.createElement('input');
    albumTitle.setAttribute('placeholder', 'Album Title');
    const albumRecordLabel = document.createElement('input');
    albumRecordLabel.setAttribute('placeholder', 'Record Label');
    const albumImage = document.createElement('input');
    albumImage.setAttribute('placeholder', 'Album Image');
    const albumArtist = document.createElement('input');
    albumArtist.setAttribute('placeholder', 'Album Artist');

    const submitBtn = document.createElement('button');
    submitBtn.innerText = 'Save';

    title.appendChild(albumTitle);
    title.appendChild(albumRecordLabel);
    title.appendChild(albumImage);
    title.appendChild(albumArtist);
    title.appendChild(submitBtn);

    submitBtn.addEventListener('click', () => {
        collectData();
    })

    const collectData = () => {

        const artist = {
            "Title": albumTitle.value,
            "recordLabel": albumRecordLabel.value,
            "image": albumImage.value,
            "artist": albumArtist.value
        }
        fetch('http://localhost:8080/albums', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(album)
        }).then(() => renderAlbum());
    }

    return title;
}

export{
    renderNewAlbumForm
}