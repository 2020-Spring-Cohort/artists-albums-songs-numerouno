import {
    createArtistView
} from './ArtistComponent.js';

const renderArtist = () => {

    const artistListElement = document.querySelector('.artists');
    artistListElement.innerHTML = '';
    const title = document.createElement('div');
    title.classList.add('artist__title');
    title.innerHTML = `<h2>Artists</h2>`;
    artistListElement.appendChild(title);

    fetch('http://localhost:8080/artists')
        .then(response => response.json())
        .then(artists => {
            artists.forEach(artist => {
                const singleArtist = createArtistView(artist);
                artistListElement.appendChild(singleArtist);
            });

        })
        .catch(err => console.error(err));
    return artistListElement;


}

export {
    renderArtist
}