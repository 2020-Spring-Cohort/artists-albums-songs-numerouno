const renderFooter = () => {
    const footerElement = document.createElement('footer');
    const footerText = document.createElement('p');
    footerText.innerText = `copyright Numerouno &copy 2020`;
    footerElement.appendChild(footerText);
    return footerElement;
}

export {
    renderFooter
}