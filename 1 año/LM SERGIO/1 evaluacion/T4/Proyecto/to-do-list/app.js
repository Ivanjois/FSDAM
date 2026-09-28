// 1. Cargamos la memoria. Si no hay nada, creamos un array vacío []
let tareas = JSON.parse(localStorage.getItem("datos")) || [];

// 2. FUNCIÓN PRINCIPAL: Dibuja la lista en la pantalla
function dibujar() {
  let contenidoHTML = ""; // Empezamos con el texto vacío

  // Recorremos el array. "t" es la tarea, "i" es su posición (0, 1, 2...)
  tareas.forEach(function(t, i) {

    // Si la tarea está completada, preparamos la clase CSS "hecha"
    let claseCSS = t.completada ? "class='hecha'" : "";

    // Escribimos el HTML de esta tarea directamente
    contenidoHTML += `
            <li ${claseCSS}>
                ${t.texto}
                <button onclick="tachar(${i})">✔️</button>
                <button onclick="borrar(${i})">🗑️</button>
            </li>
        `;
  });

  // Inyectamos todo ese texto en la lista del HTML
  document.getElementById("lista").innerHTML = contenidoHTML;

  // Guardamos en la memoria
  localStorage.setItem("datos", JSON.stringify(tareas));
}

// 3. FUNCIÓN: Añadir nueva tarea
function añadirTarea() {
  let input = document.getElementById("inputTarea");

  // Solo añadimos si el usuario ha escrito algo
  if (input.value !== "") {
    tareas.push({ texto: input.value, completada: false });
    input.value = ""; // Vaciamos la cajita
    dibujar(); // Volvemos a dibujar
  }
}

// 4. FUNCIÓN: Tachar o destachar
function tachar(i) {
  tareas[i].completada = !tareas[i].completada; // Cambia de true a false o viceversa
  dibujar();
}

// 5. FUNCIÓN: Borrar tarea
function borrar(i) {
  tareas.splice(i, 1); // Borra 1 elemento en la posición "i"
  dibujar();
}

// 6. Arrancar la web dibujando lo que haya guardado
dibujar();
