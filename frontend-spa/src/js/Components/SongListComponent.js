import {
    createSongView
} from './SongComponent.js';

const renderSongs = () => {
    const songList = document.querySelector('.songs');

    const title = document.createElement('div');
    title.classList.add('songs__title');
    title.innerHTML = `<h2>Songs</h2>`;
    songList.appendChild(title);
    const addButton = document.createElement('a');
    addButton.classList.add('add-song');
    addButton.innerText = 'Add New Song';
    addButton.addEventListener("click", () => {
        /*  body.style.background = "rgba(0,0,0,1)";
          formelement.style.transform = "translate(600px)";*/
    });

    songList.appendChild(addButton);
    const songListHolder = document.createElement('div');
    songListHolder.classList.add('songs__list');
    songList.appendChild(songListHolder);


    fetch('http://localhost:8080/songs')
        .then(response => response.json())
        .then(songs => {
            songs.forEach(song => {
                const singleSong = createSongView(song);
                songListHolder.appendChild(singleSong);

            });

        }).catch(err => console.error(err));

    return songList;

}

export {
    renderSongs
}