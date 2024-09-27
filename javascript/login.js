const mostrarInfo = document.getElementById('form--publication');

// Alertas ocultas por defecto
const welcomeUser = document.getElementById("welcomeUser");
welcomeUser.hidden = true;

const wrongMail = document.getElementById("wrongMail--alert");
wrongMail.hidden = true;

const wrongPassword = document.getElementById("wrongPassword--alert");
wrongPassword.hidden = true;

const unexistingUser = document.getElementById("unexistingUser--alert");
unexistingUser.hidden = true;



mostrarInfo.addEventListener('submit', (event) => {
    event.preventDefault(); // Evitar el comportamiento predeterminado


// Obtener valores del formulario
    const correoElectronico = document.getElementById('emailUser').value;
    const password = document.getElementById('passwordUser').value;

    // Información del formulario
    const loginForm = document.getElementById("form--publication");

    // Validación de correo electrónico
    const emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    if (!emailRegex.test(correoElectronico)) {
        wrongMail.hidden = false;
        setTimeout(() => { wrongMail.hidden = true; }, 4500);
        return;
    }

    // Validación de la contraseña
    const passwordRegex = /^[a-zA-Z0-9!@#$%&*_+¿? -]{6,}$/; // Al menos 6 caracteres
    if (!passwordRegex.test(password)) {
        wrongPassword.hidden = false;
        setTimeout(() => { wrongPassword.hidden = true; }, 4500);
        return;
    }

    // Fetch para verificar si el correo está en la base de datos
    const url = `http://localhost:8080/contratarServicio/r1/construclick2/email?construemail=${correoElectronico}`;
    fetch(url)
        .then(response => {
            if (!response.ok) {
                throw new Error("Usuario no encontrado"); // Si no existe el correo
            }
            return response.json(); // Convertir a JSON si la respuesta es correcta
        })
        .then(data => {
            // Validar si la contraseña coincide
            if (data.password === password) {
                welcomeUser.hidden = false; // Mostrar mensaje de bienvenida
                setTimeout(() => {
                    window.location.href = "./perfil.html"; // Redirigir al perfil del usuario
                }, 3000);
            } else {
                wrongPassword.hidden = false; // Mostrar alerta de contraseña incorrecta
                setTimeout(() => { wrongPassword.hidden = true; }, 4500);
            }
        })
        .catch(error => {
            console.error("Error:", error);
            unexistingUser.hidden = false; // Mostrar alerta de usuario no existente
            setTimeout(() => { unexistingUser.hidden = true; }, 4500);
        });

    loginForm.reset(); // Reiniciar el formulario
});



