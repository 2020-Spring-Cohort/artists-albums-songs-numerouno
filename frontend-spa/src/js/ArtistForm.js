import {
    DomMaker
} from './DomMaker.js';
import {
    InputMaker
} from './InputMaker.js';

const createArtistFom = () => {

    const form = new DomMaker('form')
        .changeContent('Add New Artist')
        .appendChild(new InputMaker().changeInputType('text').addPlaceholder('Enter the Name').addClassName('song-form').render())
        .appendChild(new InputMaker().changeInputType('text').addPlaceholder('Enter the age').render())
        .appendChild(new InputMaker().changeInputType('text').addPlaceholder('Enter the hometown').render())
        .appendChild(new InputMaker().changeInputType('text').addPlaceholder('Enter the recordLabel').render())
        .appendChild(new DomMaker('button').changeContent('Add').addOnClickAction(() => {

            console.log('data sent');
        }).render()).render();

    return form;

}

export {
    createArtistFom
}