const nameAlert = document.getElementById("name--alert");
nameAlert.hidden = true;

const correoAlert = document.getElementById("email--alert");
correoAlert.hidden = true;

const telefonoAlert = document.getElementById("phone--alert");
telefonoAlert.hidden = true;

const contrasenaAlert = document.getElementById("password--alert");
contrasenaAlert.hidden = true;

const contrasenaCoincide = document.getElementById("password2--alert");
contrasenaCoincide.hidden = true;

const savedAlert = document.getElementById("saved--alert");
 savedAlert.hidden = true;

const formServices = document.getElementById('RegistroPrestador');

// Evento del formulario
formServices.addEventListener('click', (event) => {
    event.preventDefault();

    // Lectura de los datos del usuario e implementación de las regex
    const nombre = document.getElementById("userName").value;
    const nombreRegex = /^[a-zA-ZáéíóúüñÁÉÍÓÚÜÑ\s]+$/;
    
    const email = document.getElementById("userEmail").value;
    const emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    
    const telefono = document.getElementById("userPhone").value;
    const telefonoRegex = /^\d{10}$/;

    const contrasena = document.getElementById("contrasena").value;
    const contrasenaRegex = /^(?=.*[0-9])(?=.*[!@#$%^&*])(?=.*[A-Z])[a-zA-Z0-9!@#$%^&*]{8,16}$/;

    const confirmaContrasena = document.getElementById("confirmaContrasena").value;

    let validacion = true;

    // Validación de los campos del formulario
    if (!nombreRegex.test(nombre)) {
        nameAlert.hidden = false;
        validacion = false
    } else {
        nameAlert.hidden = true;
    }

    if (!emailRegex.test(email)) {
        correoAlert.hidden = false;
        validacion = false;
        
    } else {
        correoAlert.hidden = true;
    }

    if (!contrasenaRegex.test(contrasena)) {
        contrasenaAlert.hidden = false;
        validacion = false;

    } else {
        contrasenaAlert.hidden = true;
    }

    if (contrasena !== confirmaContrasena) {
        contrasenaCoincide.hidden = false;
        validacion = false;
        
    } else {
        contrasenaCoincide.hidden = true;
    }

    if (!telefonoRegex.test(telefono)) {
        telefonoAlert.hidden = false;
        validacion = false;
    } else {
        telefonoAlert.hidden = true;
    }

    // Si todas las validaciones son correctas, procede con el envío de los datos
    if (validacion) {
        const user = {
            username: nombre,
            email: email,
            password: contrasena,
            phone: telefono,
            //category: document.getElementById('placeOption').value
        };

        fetch('http://localhost:8080/contratarServicio/r1', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(user)
        })
        .then(response => response.json())
        .then(data => {
            console.log('Guardado', data);
            savedAlert.hidden = false; // Muestra alerta de guardado exitoso
            loginMessage.hidden = false; // Muestra el mensaje de "Por favor inicia sesión"
        })
        .catch(error => {
            console.error('Error:', error);
        });
    }
});

