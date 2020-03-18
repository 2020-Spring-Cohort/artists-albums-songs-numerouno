const addSongBtn = document.querySelector(".add-song");
const formelement = document.querySelector(".song-form");
const body = document.querySelector("body");

addSongBtn.addEventListener("click", () => {
    body.style.background = "rgba(0,0,0,1)";
    formelement.style.transform = "translate(600px)";
})