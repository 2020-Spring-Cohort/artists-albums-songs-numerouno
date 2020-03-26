import {
    createAlbumView
} from './AlbumComponent.js';

import {
    renderAlbumDetails
} from './AlbumDetailsComponent.js';



const albumListElement = document.querySelector('.main');


const renderAlbum = () => {

    albumListElement.innerHTML = '';
    const title = document.createElement('div');
    title.classList.add('artists__albums');
    title.innerHTML = ` <h5>Album Title</h5>`;
    albumListElement.appendChild(title);



    fetch('http://localhost:8080/artists')
        .then(reponse => reponse.json())
        .then(albums => {
            console.log(albums);
            albums.forEach(album => {

                const singleAlbum = createAlbumView(album);
                singleAlbum.addEventListener('click', (e) => {
                    e.preventDefault();
                    while (albumListElement.firstChild) {
                        albumListElement.removeChild(albumListElement.firstChild);

                    }
                    albumListElement.appendChild(renderAlbumDetails(album));

                });
                albumListElement.appendChild(singleAlbum);
            });

        })
        .catch(err => console.error(err));

    return albumListElement;

}

export {
    renderAlbum
}