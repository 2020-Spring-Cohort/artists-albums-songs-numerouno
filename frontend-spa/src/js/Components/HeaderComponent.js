const renderHeader = () => {
    const headerElement = document.createElement('header');
    headerElement.classList.add('header');
    const titleElemnt = document.createElement('div');
    titleElemnt.classList.add('title');
    const image = document.createElement('img');
    image.setAttribute('src', './src/js/images/header1.png');
    image.setAttribute('alt', 'header picture');
    titleElemnt.appendChild(image);
    headerElement.appendChild(titleElemnt);


    return headerElement;
}

export {
    renderHeader
}