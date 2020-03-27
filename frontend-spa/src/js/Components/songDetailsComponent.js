const renderSongDetails = (song) => {
    const singleSongElement = document.createElement('div');
    singleSongElement.classList.add('singleSong');
    const songHolder = document.createElement('h3');
    songHolder.innerText = 'Title: ';
    const songTitle = document.createElement('span');
    songTitle.innerText = song.title;
    songHolder.appendChild(songTitle);
    const durationHolder = document.createElement('h3');
    durationHolder.innerText = 'Duration: ';
    const songDuration = document.createElement('span');
    songDuration.innerText = song.duration;
    durationHolder.appendChild(songDuration);
    songHolder.appendChild(durationHolder);
    singleSongElement.appendChild(songHolder)





    return singleSongElement;
}


export {
    renderSongDetails
}