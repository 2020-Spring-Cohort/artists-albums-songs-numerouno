import {
    renderSong
} from './SongListComponent.js' ;

const renderNewSongForm = () => {

    const title = document.createElement('p');
    title.innerText = 'Add a New Song';

    const songTitle = document.createElement('input');
    songTitle.setAttribute('placeholder', 'Song Title');
    const songDuration = document.createElement('input');
    songDuration.setAttribute('placeholder', 'Song Duration');

    const submitBtn = document.createElement('button');
    submitBtn.innerText = 'Save';

    title.appendChild(songTitle);
    title.appendChild(songDuration);
    title.appendChild(submitBtn);
   
   
    submitBtn.addEventListener('click', () => {
        collectData();
    })

    const collectData = () => {

    const song = {

        "title": songTitle.value,
        "duration": songDuration.value
         
    }

    fetch('http://localhost:8080/songs', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(artist)
        }).then(() => renderSong());


    
    }



    return title;


}

export {
    renderNewSongForm
}