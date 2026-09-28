let equipo = [];
let seleccionados = [];

document.querySelector("form").onsubmit = async e => {
    e.preventDefault();
    equipo = [];
    seleccionados = [];
    document.getElementById("acciones").style.display = "none";
    document.getElementById("arena").innerHTML = "";
    
    let nombres = Array.from(document.querySelectorAll("input")).map(i => i.value.trim()).filter(Boolean);
    
    let promesas = nombres.map(async n => {
        let res = await fetch(`https://pokeapi.co/api/v2/pokemon/${n.toLowerCase()}`);
        if (!res.ok) return null;
        let p = await res.json();
        return { nombre: p.name, img: p.sprites.front_default, danio: p.stats[1].base_stat };
    });

    equipo = (await Promise.all(promesas)).filter(p => p !== null);

    document.getElementById("equipo").innerHTML = equipo.map((p, i) => `
        <article onclick="seleccionar(${i}, this)">
            <b>#${i+1} ${p.nombre}</b><br>
            <img src="${p.img}"><br>
            Daño: ${p.danio}
        </article>
    `).join("");
};

window.seleccionar = (i, el) => {
    let pos = seleccionados.indexOf(i);
    if (pos > -1) {
        seleccionados.splice(pos, 1);
        el.classList.remove("seleccionado");
    } else if (seleccionados.length < 2) {
        seleccionados.push(i);
        el.classList.add("seleccionado");
    }
    
    document.getElementById("acciones").style.display = seleccionados.length === 2 ? "block" : "none";
    document.getElementById("arena").innerHTML = "";
};

document.getElementById("btn-pelear").onclick = () => {
    let p1 = equipo[seleccionados[0]];
    let p2 = equipo[seleccionados[1]];
    let ganador = p1.danio > p2.danio ? p1.nombre : (p2.danio > p1.danio ? p2.nombre : "Nadie (Empate)");
    
    document.getElementById("arena").innerHTML = `
        <article><img src="${p1.img}"></article> 
        <h2>VS</h2> 
        <article><img src="${p2.img}"></article>
        <h3 style="width:100%">🏆 Gana: ${ganador}</h3>
    `;
};