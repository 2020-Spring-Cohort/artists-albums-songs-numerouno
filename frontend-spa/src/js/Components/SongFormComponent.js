import {
    renderSongs
} from './SongListComponent.js';
import {
    renderAlbumDetails
} from './AlbumDetailsComponent.js';

const artistListElement = document.querySelector('.main');
const renderNewSongForm = (album) => {

    const title = document.createElement('p');
    title.classList.add('songFormTitle');
    title.innerText = 'Add a New Song';

    const songTitle = document.createElement('input');
    songTitle.setAttribute('placeholder', 'Song Title');
    const songDuration = document.createElement('input');
    songDuration.setAttribute('placeholder', 'Song Duration');

    const submitBtn = document.createElement('button');
    submitBtn.innerText = 'Save';

    title.appendChild(songTitle);
    title.appendChild(songDuration);
    title.appendChild(submitBtn);


    submitBtn.addEventListener('click', () => {
        collectData();
        while (artistListElement.firstChild) {
            artistListElement.removeChild(artistListElement.firstChild)
        }
    })

    const collectData = () => {

        const song = {

            "title": songTitle.value,
            "duration": songDuration.value

        }

        fetch(`http://localhost:8080/albums/${album.id}/songs`, {
                method: 'PATCH',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(song)
            }).then(response => response.json())
            .then(album => artistListElement.appendChild(renderAlbumDetails(album)))
            .catch(err => console.eeror(err));



    }



    return title;


}

export {
    renderNewSongForm
}