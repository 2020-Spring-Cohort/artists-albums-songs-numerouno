import {
    renderArtist
} from './ArtistListComponent.js';



const createArtistView = (artist) => {
    const artistView = document.createElement('div');
    artistView.classList.add('single-artist');
    appendArtistName(artist, artistView);
    addEditTag(artist, artistView);
    addDeleteTag(artist, artistView);


    return artistView;

}







const appendArtistName = (artist, element) => {
    const artistName = document.createElement('a');
    artistName.innerText = `${artist.name}`;
    element.appendChild(artistName);
}

const addEditTag = (artist, element) => {

    const iTag = document.createElement('i');
    iTag.classList.add('far');
    iTag.classList.add('fa-edit');
    iTag.classList.add('fedit');
    iTag.innerText = "";
    iTag.setAttribute('name', artist.id);
    element.appendChild(iTag);
}

const addDeleteTag = (artist, element) => {

    const iTag = document.createElement('i');
    iTag.classList.add('far');
    iTag.classList.add('fa-trash-alt');
    iTag.classList.add('fdelete');
    iTag.innerText = "";
    iTag.setAttribute('artistId', artist.id);


    iTag.addEventListener('click', (e) => {
        e.stopPropagation();


        fetch(`http://localhost:8080/artists/${artist.id}`, {
            method: 'DELETE',
        }).then(() => renderArtist());
        console.log(`${artist.id}`);

    });

    element.appendChild(iTag);
}

export {
    createArtistView
}