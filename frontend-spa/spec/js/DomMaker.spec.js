describe('DomMaker is a library of methods to help with making HTML elements.', () => {

    describe('render() should return the DomMaker object\'s HTML element.', () => {
        it('When render is called it return\'s an HTML element', () => {
            let underTest = new DomMaker('div');
            let result = underTest.render();
            expect(result.tagName).toBe('DIV');
        });
    });
    describe('changeContent() should affect the innerText of the DomMaker\'s element.', () => {
        it('When changeContent() is called the element\'s inner text is change to the passed text.', () => {
            let underTest = new DomMaker('div');
            underTest.changeContent('Hello, World!');
            expect(underTest.render().innerText).toBe('Hello, World!');
            underTest.changeContent('Hello World');
            expect(underTest.render().innerText).toBe('Hello World');
            underTest.changeContent('Hello, Nick!');
            expect(underTest.render().innerText).toBe('Hello, Nick!');
        });
    });
    describe('appendChild() should add the passed HTML element to the DomMaker\'s element\'s nodelist.', () => {
        it('When appendChild() is called it will add the element to the underTest\'s child elements', () => {
            let underTest = new DomMaker('ul');
            let testListItem = new DomMaker('li');
            underTest.appendChild(testListItem.render());
            expect(underTest.render().firstElementChild.tagName).toBe('LI');
        });
        it('Should work like a fluent API', () => {
            let underTest = new DomMaker('ul');
            underTest.appendChild(new DomMaker('li').changeContent('TEST').render());
            expect(underTest.render().firstElementChild.innerText).toBe('TEST');

        });
    });
});