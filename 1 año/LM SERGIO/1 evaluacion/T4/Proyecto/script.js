// 1. CAPTURAR LOS ELEMENTOS DEL DOM
const botonTema = document.querySelector("#btn-tema"); // Captura el botón
const cuerpoWeb = document.body; // Captura todo el body

// 2. LEER LA MEMORIA (localStorage)
// Preguntamos: "¿El usuario guardó el tema oscuro la última vez?"
const modoGuardado = localStorage.getItem("temaOscuro");

// Si la respuesta es "activado", le ponemos la clase oscura directamente al cargar la página
if (modoGuardado === "activado") {
  cuerpoWeb.classList.add("dark-mode");
  botonTema.textContent = "☀️ Modo Claro"; // Cambiamos el texto del botón
}

// 3. CREAR EL EVENTO CLIC (El ciclo de vida del evento empieza aquí)
botonTema.addEventListener("click", function() {

  // classList.toggle hace la magia: Si NO tiene la clase 'dark-mode', se la pone. Si la tiene, se la quita.
  cuerpoWeb.classList.toggle("dark-mode");

  // 4. GUARDAR EN MEMORIA SEGÚN EL RESULTADO
  if (cuerpoWeb.classList.contains("dark-mode")) {
    // Si acabamos de poner el modo oscuro, lo guardamos en el localStorage
    localStorage.setItem("temaOscuro", "activado");
    botonTema.textContent = "☀️ Modo Claro";
  } else {
    // Si acabamos de quitarlo, guardamos "desactivado"
    localStorage.setItem("temaOscuro", "desactivado");
    botonTema.textContent = "🌙 Modo Oscuro";
  }
});
// --- EFECTO SCROLL PARA LAS TARJETAS ---

const seccionTarjetas = document.getElementById("fases");
// Seleccionamos TODAS las tarjetas que están dentro de la pila
const tarjetas = document.querySelectorAll(".fases-stack .fase-card");

window.addEventListener("scroll", function() {

  // Si no estamos en la página del Index (donde está esta sección), no hacemos nada
  if (!seccionTarjetas) return;

  let distanciaDesdeArriba = window.scrollY;
  let inicioZona = seccionTarjetas.offsetTop;
  let altoZona = seccionTarjetas.offsetHeight;
  let altoPantalla = window.innerHeight;

  // Si el usuario ha llegado a la zona gigante de las tarjetas...
  if (distanciaDesdeArriba > inicioZona - altoPantalla && distanciaDesdeArriba < inicioZona + altoZona) {

    // Calculamos del 0 al 100 qué porcentaje de la sección hemos bajado
    let progreso = ((distanciaDesdeArriba - inicioZona) / (altoZona - altoPantalla)) * 100;

    // Nos aseguramos de que no pase de 100 ni baje de 0
    if (progreso < 0) progreso = 0;
    if (progreso > 100) progreso = 100;

    // Como tenemos 5 tarjetas, cada una ocupa un 20% del progreso (100 / 5 = 20)
    // Averiguamos qué número de tarjeta toca mostrar (0, 1, 2, 3 o 4)
    let indiceTarjeta = Math.floor(progreso / 20);

    // Evitamos un pequeño fallo si el porcentaje llega a 100 exacto
    if (indiceTarjeta >= tarjetas.length) {
      indiceTarjeta = tarjetas.length - 1;
    }

    // 1. Escondemos TODAS las tarjetas quitándoles la clase 'activa'
    tarjetas.forEach(function(tarjeta) {
      tarjeta.classList.remove("activa");
    });

    // 2. Le ponemos la clase 'activa' SOLO a la tarjeta que nos toca ver
    tarjetas[indiceTarjeta].classList.add("activa");
  }
});
