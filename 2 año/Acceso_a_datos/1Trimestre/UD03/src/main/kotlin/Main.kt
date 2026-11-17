fun main() {

    // Listar todos los videojuegos
    println("Lista de videojuegos:")
    VideojuegoDAO.listarVideojuegos().forEach {
        println(" - [${it.id}] ${it.titulo} (${it.genero}), año: ${it.anio}, nota: ${it.nota}")
    }

    // Consultar videojuego por ID
    val videojuego = VideojuegoDAO.consultarPorId(3)
    if (videojuego != null) {
        println("Videojuego encontrado: [${videojuego.id}] ${videojuego.titulo} (${videojuego.genero}), año: ${videojuego.anio}, nota: ${videojuego.nota}")
    } else {
        println("No se encontró ningún videojuego con ese ID.")
    }

    // Insertar videojuego nuevo
    VideojuegoDAO.insertarVideojuego(
        Videojuego(
            titulo = "Elden Ring",
            genero = "RPG",
            anio = 2022,
            nota = 9.6
        )
    )

    // Actualizar videojuego con id=1 (The Legend of Zelda: Breath of the Wild)
    VideojuegoDAO.actualizarVideojuego(
        Videojuego(
            id = 1,
            titulo = "The Legend of Zelda: Breath of the Wild",
            genero = "Aventura",
            anio = 2017,
            nota = 9.8
        )
    )

    // Eliminar videojuego con id=2 (Red Dead Redemption 2)
    VideojuegoDAO.eliminarVideojuego(2)
}
