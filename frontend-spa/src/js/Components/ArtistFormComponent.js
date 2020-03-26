import {
    renderArtist
} from './ArtistListComponent.js';
const artistListElement = document.querySelector('.main');
const renderNewArtsitForm = () => {

    const title = document.createElement('p');
    title.innerText = 'Add a New Artist';

    const artistName = document.createElement('input');
    artistName.setAttribute('placeholder', 'Artist Name');
    const artistAge = document.createElement('input');
    artistAge.setAttribute('placeholder', 'Artist Age');
    const artistHometown = document.createElement('input');
    artistHometown.setAttribute('placeholder', 'Artist Hometown');
    const artistRecordLabel = document.createElement('input');
    artistRecordLabel.setAttribute('placeholder', 'Artist Record label');

    const submitBtn = document.createElement('button');
    submitBtn.innerText = 'Save';

    title.appendChild(artistName);
    title.appendChild(artistAge);
    title.appendChild(artistHometown);
    title.appendChild(artistRecordLabel);
    title.appendChild(submitBtn);

    submitBtn.addEventListener('click', () => {
        collectData();
    })

    const collectData = () => {

        const artist = {
            "name": artistName.value,
            "age": artistAge.value,
            "hometown": artistHometown.value,
            "recordLabel": artistRecordLabel.value
        }

        fetch('http://localhost:8080/artists', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(artist)
        }).then(() => renderArtist());





    }



    return title;


}

export {
    renderNewArtsitForm
}