


// using DOM API

const card = document.querySelector('.card');
const cardBody = document.querySelector('.card-body');
const primaryBtn = document.querySelector('.btn-primary');
const secondaryBtn = document.querySelector('.btn-secondary');

primaryBtn.addEventListener('click', () => {
    cardBody.innerText = " using Playwright";
});

secondaryBtn.addEventListener('click', () => {
    const display = card.style.display;
    card.style.display = display === 'none' ? 'none' : 'block';
});

// usiing fetch Api

const top5TodosBtn = document.querySelector('#top5-todos');
const todosBody = document.querySelector('#todos-body');

top5TodosBtn.addEventListener('click', async () => {
    const response = await fetch('https://jsonplaceholder.typicode.com/todos?_limit=5');
    const todos = await response.json();
    todosBody.innerHTML = '';
    todos.forEach(todo => {
        const tr = document.createElement('tr');
        tr.innerHTML = `
            <td>${todo.id}</td>
            <td>${todo.title}</td>
            <td>${todo.completed}</td>
        `;
        todosBody.appendChild(tr);
    });
})