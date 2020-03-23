const renderFooter = () => {
    const footerElement = document.createElement('footer');
    footerElement.innerHTML = `  <p>copyright Numerouno &copy 2020</p>`
    return footerElement;
}

export {
    renderFooter
}