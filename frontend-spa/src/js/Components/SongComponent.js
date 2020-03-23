const createSongView = (song) => {
    const songView = document.createElement('div');
    songView.classList.add('songs__list__single');
    addMusicIcon(songView);
    addSongName(song, songView);
    addSongTime(song, songView);
    addSongEditTag(song, songView);
    addSongDeleteTag(song, songView);

    return songView;

}

const addMusicIcon = (element) => {

    const iTag = document.createElement('i');
    iTag.classList.add('fas');
    iTag.classList.add('fa-music');
    element.appendChild(iTag);
}

const addSongName = (song, element) => {

    const songNameHolder = document.createElement('div');
    songNameHolder.classList.add('songs__list__song');
    const link = document.createElement('a');
    link.innerText = `${song.title}`;
    songNameHolder.appendChild(link);
    element.appendChild(songNameHolder);
}

const addSongTime = (song, element) => {
    const songTimeHolder = document.createElement('span');
    songTimeHolder.innerText = `${song.duration}`;
    element.appendChild(songTimeHolder);
}

const addSongEditTag = (song, element) => {

    const editTag = document.createElement('i');
    editTag.classList.add('far');
    editTag.classList.add('fa-edit');
    editTag.classList.add('fedit');
    editTag.setAttribute('name', song.id);
    element.appendChild(editTag);
}

const addSongDeleteTag = (song, element) => {

    const deleteTag = document.createElement('i');
    deleteTag.classList.add('far');
    deleteTag.classList.add('fa-trash-alt');
    deleteTag.classList.add('fdelete');
    deleteTag.setAttribute('name', song.id);
    element.appendChild(deleteTag);
}

export {
    createSongView
}