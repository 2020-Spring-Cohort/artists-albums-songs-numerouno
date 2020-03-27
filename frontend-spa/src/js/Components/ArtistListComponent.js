import {
    createArtistView
} from './ArtistComponent.js';

import {
    renderArtistDetails
} from './ArtistDetailsComponent.js';

import {
    renderNewArtsitForm
} from './ArtistFormComponent.js';

const artistListElement = document.querySelector('.main');



const renderArtist = () => {

    artistListElement.innerHTML = '';
    const title = document.createElement('div');
    title.classList.add('artist__title');
    const titleText = document.createElement('h2');
    titleText.innerText = 'Artists';
    title.appendChild(titleText)
    artistListElement.appendChild(title);




    fetch('http://localhost:8080/artists')
        .then(response => response.json())
        .then(artists => {
            artists.forEach(artist => {

                const singleArtist = createArtistView(artist);
                singleArtist.addEventListener('click', (e) => {
                    e.preventDefault();
                    while (artistListElement.firstChild) {
                        artistListElement.removeChild(artistListElement.firstChild);

                    }
                    artistListElement.appendChild(renderArtistDetails(artist));

                });
                artistListElement.appendChild(singleArtist);
            });
            artistListElement.appendChild(renderNewArtsitForm());
        })
        .catch(err => console.error(err));
    return artistListElement;


}

export {
    renderArtist
}