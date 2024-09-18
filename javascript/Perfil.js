const post = document.querySelector(".construPost");
const postList = document.getElementById('postList');
const botonDisabled = document.getElementById('publicarBoton');
post.addEventListener('submit', (event) => {
    event.preventDefault();
    const postContent = document.getElementById("postContent").value;

    console.log(postContent);

    const newPost = document.createElement('div');
    newPost.className = 'postItem';
    const respuesta = document.createElement('div');
    respuesta.className = 'respuesta';

    postList.appendChild(newPost);
    const postText = document.createElement('p');
    postText.className = 'postText';
    postText.textContent = postContent;
    newPost.appendChild(postText)

    const botonHeart = document.createElement('button');
    botonHeart.className = "heartButton";
    botonHeart.innerHTML = '♥ Mi Click';
    newPost.appendChild(botonHeart);

    const heartButtons = document.querySelectorAll('.heartButton');

    heartButtons.forEach(button => {
        button.addEventListener('click', () => {
            button.style.backgroundColor = 'darkred';
            button.style.color = "white";
        })
    })

    const comentar = document.createElement('button');
    comentar.innerHTML = "Comenta";
    comentar.className = "comenta";
    newPost.appendChild(comentar);

    const comparte = document.createElement('button');
    comparte.innerHTML = "» Comparte";
    comparte.className = "comparte";
    newPost.appendChild(comparte)

    postList.insertBefore(newPost, postList.firstChild);

    const cleanPost = document.getElementById("postContent");
    cleanPost.value = "";

})

const resena = document.querySelector('.resenaDestacado');
resena.hidden = true;

const usuarioDestacado = document.getElementById('destacado');
usuarioDestacado.addEventListener('mouseover', () => {
    resena.hidden = false
})
usuarioDestacado.addEventListener('mouseout', () => {
    resena.hidden = true;
})

const resenaPosition = document.querySelector(".resenaDestacado")

function ajusteResena() {
    resenaPosition.style.left = destacado.offsetLeft + 'px';
    resenaPosition.style.top = destacado.offsetTop + 'px';
}
ajusteResena();
window.addEventListener('resize', ajusteResena)

const descripcionLogro = document.querySelector('.descripcionLogro');
descripcionLogro.hidden = true;

const medallaUsuarioNuevo = document.getElementById('medallaUsuarioNuevo');

medallaUsuarioNuevo.addEventListener('click', () => {
    descripcionLogro.hidden = false;
    const descPosition = document.querySelector(".descripcionLogro");
function ajusteDesc (){
    descPosition.style.right = destacado.offsetLeft + 'px';
    descPosition.style.top = destacado.offsetTop + 'px';
}
ajusteDesc();
window.addEventListener('resize', ajusteDesc)
})
medallaUsuarioNuevo.addEventListener('mouseout', () => {
    descripcionLogro.hidden = true;
})

