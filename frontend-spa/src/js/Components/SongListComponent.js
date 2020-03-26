import {
    createSongView
} from './SongComponent.js';

const renderSongs = () => {
    const songListElement = document.querySelector('.main');

    const title = document.createElement('div');
    title.classList.add('songs__title');
    title.innerHTML = `<h2>Songs</h2>`;
    songListElement.appendChild(title);
    const addButton = document.createElement('a');
    addButton.classList.add('add-song');
    addButton.innerText = 'Add New Song';
    addButton.addEventListener("click", () => {
        /*  body.style.background = "rgba(0,0,0,1)";
          formelement.style.transform = "translate(600px)";*/
    });

    songListElement.appendChild(addButton);
    const songListHolder = document.createElement('div');
    songListHolder.classList.add('songs__list');
    songListElement.appendChild(songListHolder);


    fetch('http://localhost:8080/songs')
        .then(response => response.json())
        .then(songs => {
            songs.forEach(song => {
                const singleSong = createSongView(song);
                songListHolder.appendChild(singleSong);

            });

        }).catch(err => console.error(err));

    return songListElement;

}

export {
    renderSongs
}