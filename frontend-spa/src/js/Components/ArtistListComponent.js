import {
    createArtistView
} from './ArtistComponent.js';

import {
    renderArtistDetails
} from './ArtistDetailsComponent.js';

const artistListElement = document.querySelector('.main');



const renderArtist = () => {

    artistListElement.innerHTML = '';
    const title = document.createElement('div');
    title.classList.add('artist__title');
    title.innerHTML = `<h2>Artists</h2>`;
    artistListElement.appendChild(title);




    fetch('http://localhost:8080/artists')
        .then(response => response.json())
        .then(artists => {
            artists.forEach(artist => {
                console.log(artist);
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

        })
        .catch(err => console.error(err));
    return artistListElement;


}

export {
    renderArtist
}