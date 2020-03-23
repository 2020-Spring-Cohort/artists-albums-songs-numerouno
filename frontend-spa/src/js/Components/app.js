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

const addSongBtn = document.querySelector(".add-song");
const formelement = document.querySelector(".song-form");
const body = document.querySelector("body");





const displayHome = () => {

    const container = document.querySelector('.container');

    container.appendChild(renderHeader());
    container.appendChild(renderFooter());
    renderArtist();
    renderSongs();
}

displayHome();