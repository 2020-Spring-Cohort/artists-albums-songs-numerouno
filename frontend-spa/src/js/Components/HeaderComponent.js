const renderHeader = () => {
    const headerElement = document.createElement('header');
    headerElement.innerHTML = ` <div class="title">

    
                <img src="./src/js/images/header1.png" alt="header picture">
            </div>`
    return headerElement;
}

export {
    renderHeader
}