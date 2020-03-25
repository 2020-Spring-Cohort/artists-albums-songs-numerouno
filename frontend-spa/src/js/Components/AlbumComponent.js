const createAlbumView = (album) => {
    const albumView = document.createElement('div');
    albumView.classList.add('single-album');
    appendAlbumTitle(album,albumView);
    addEditTag(album,albumView);
    addDeleteTag(album,albumView);

    return albumView;
}


const appendAlbumTitle = (album,element) => {
    const albumTitle = document.createElement('a');
    albumTitle.innerText = `{album.title}`;
    element.appendChild(albumTitle);

}

const addEditTag = (album, element) => {

    const iTag = document.createElement('i');
    iTag.classList.add('far');
    iTag.classList.add('fa-edit');
    iTag.classList.add('fedit');
    iTag.innerText = "";
    iTag.setAttribute('title', artist.id);
    element.appendChild(iTag);
}

const addDeleteTag = (album, element) => {

    const iTag = document.createElement('i');
    iTag.classList.add('far');
    iTag.classList.add('fa-trash-alt');
    iTag.classList.add('fdelete');
    iTag.innerText = "";
    iTag.setAttribute('title', album.id);
    element.appendChild(iTag);
}

export {
    createAlbumView
}

