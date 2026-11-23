-- Script completo de creación y población de la base de datos 'videojuegos' (PostgreSQL)

-- Eliminar tablas previas en orden seguro por claves foráneas
DROP TABLE IF EXISTS listas_videojuegos, listas, jugadores, videojuegos CASCADE;

-- 1. Tabla de videojuegos
CREATE TABLE videojuegos (
    id      SERIAL PRIMARY KEY,
    titulo  VARCHAR(150) NOT NULL,
    genero  VARCHAR(80) NOT NULL,
    anio    INTEGER NOT NULL,
    nota    DOUBLE PRECISION NOT NULL
);

-- 2. Tabla de jugadores
CREATE TABLE jugadores (
    id      SERIAL PRIMARY KEY,
    nombre  VARCHAR(100) NOT NULL,
    email   VARCHAR(150) NOT NULL UNIQUE
);

-- 3. Tabla de listas (cada lista pertenece a un jugador)
CREATE TABLE listas (
    id_lista    SERIAL PRIMARY KEY,
    nombre      VARCHAR(100) NOT NULL,
    id_jugador  INTEGER NOT NULL,
    FOREIGN KEY (id_jugador) REFERENCES jugadores(id) ON DELETE CASCADE
);

-- 4. Tabla intermedia entre listas y videojuegos
CREATE TABLE listas_videojuegos (
    id_lista       INTEGER NOT NULL,
    id_videojuego  INTEGER NOT NULL,
    fecha_anadido  VARCHAR(20) NOT NULL,
    PRIMARY KEY (id_lista, id_videojuego),
    FOREIGN KEY (id_lista) REFERENCES listas(id_lista) ON DELETE CASCADE,
    FOREIGN KEY (id_videojuego) REFERENCES videojuegos(id) ON DELETE CASCADE
);

-- ==========================================
-- Inserción de datos iniciales de prueba
-- ==========================================

-- 5 videojuegos iniciales
INSERT INTO videojuegos (titulo, genero, anio, nota) VALUES
    ('The Legend of Zelda: Breath of the Wild', 'Aventura', 2017, 9.5),
    ('Red Dead Redemption 2', 'Acción', 2018, 9.7),
    ('Hades', 'Roguelike', 2020, 9.3),
    ('Hollow Knight', 'Plataformas', 2017, 9.1),
    ('Celeste', 'Plataformas', 2018, 8.9);

-- 3 jugadores iniciales
INSERT INTO jugadores (nombre, email) VALUES
    ('Iván', 'ivan@example.com'),
    ('Laura', 'laura@example.com'),
    ('Carlos', 'carlos@example.com');

-- 3 listas iniciales (una asignada a cada jugador)
INSERT INTO listas (nombre, id_jugador) VALUES
    ('Favoritos', 1),
    ('Pendientes', 2),
    ('Completados', 3);

-- Relaciones iniciales entre listas y videojuegos
INSERT INTO listas_videojuegos (id_lista, id_videojuego, fecha_anadido) VALUES
    (1, 1, '2026-11-22'),
    (1, 3, '2026-11-22'),
    (2, 2, '2026-11-22'),
    (3, 4, '2026-11-22'),
    (3, 5, '2026-11-22');
