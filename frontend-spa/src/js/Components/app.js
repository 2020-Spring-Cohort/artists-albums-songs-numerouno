import {
    renderHeader
} from './HeaderComponent.js';

import {
    renderFooter
} from './FooterComponent.js';

import {
    renderArtist
} from './ArtistListComponent.js';

import {
    renderSongs
} from './SongListComponent.js';
import {
    renderAlbum
} from './AlbumListComponent.js';

const addSongBtn = document.querySelector(".add-song");
const formelement = document.querySelector(".song-form");
const body = document.querySelector("body");





const displayHome = () => {

    const container = document.querySelector('.container');
    const mainSection = document.querySelector('.main');
    container.prepend(renderHeader());
    container.appendChild(renderFooter());
    renderArtist();
    renderSongs();
    renderAlbum();
}

displayHome();