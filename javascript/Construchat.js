document.addEventListener("DOMContentLoaded", () => {
  let contactoActual = "";

  document.querySelectorAll(".sugerencia").forEach((item) => {
    item.addEventListener("click", () => {
      contactoActual = item.querySelector(".descripcion h4").innerText;
      const foto = item.querySelector(".picture img").src;

      const chatContent = document.getElementById("chatContent");
      if (chatContent) {
        const contactInfo = `
            <div class="contact-info" style="display: flex; align-items: center; margin-bottom: 10px;">
              <img src="${foto}" alt="Foto del contacto" style="width: 50px; height: 50px; border-radius: 50%; margin-right: 10px;">
              <h4>${contactoActual}</h4>
            </div>
          `;

        const contactInfoContainer = chatContent.querySelector(".contact-info");
        if (contactInfoContainer) {
          contactInfoContainer.outerHTML = contactInfo;
        } else {
          chatContent.insertAdjacentHTML("afterbegin", contactInfo);
        }

        const messageInput = document.getElementById("message-input");
        if (messageInput) {
          messageInput.value = "";
        }

        const chatBox = document.getElementById("chat-box");
        if (chatBox) {
          chatBox.innerHTML = "";
        }
      }

      const chatContainer = document.querySelector(".scrollspy-example");
      if (chatContainer) {
        chatContainer.scrollIntoView({ behavior: "smooth" });
      }
    });
  });

  const chatForm = document.getElementById("chat-form");
  if (chatForm) {
    chatForm.addEventListener("submit", (event) => {
      event.preventDefault();

      const messageInput = document.getElementById("message-input");
      const chatBox = document.getElementById("chat-box");

      if (messageInput && chatBox) {
        const mensaje = messageInput.value.trim();
        if (mensaje) {
          const newMessage = document.createElement("div");
          newMessage.classList.add("chat-message", "user-message");
          newMessage.innerHTML = `<p>${mensaje}</p>`;
          chatBox.appendChild(newMessage);

          const autoReply = document.createElement("div");
          autoReply.classList.add("chat-message", "auto-reply");
          autoReply.innerHTML = `<p>Gracias por escribir. En cuanto ${contactoActual} esté disponible, te enviará un mensaje.</p>`;
          chatBox.appendChild(autoReply);

          messageInput.value = "";

          chatBox.scrollTop = chatBox.scrollHeight;
        }
      }
    });
  }
});
