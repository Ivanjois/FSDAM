CREATE DATABASE estacion_climatologica;

-- Recuerda, para conectar a la BD en Postgres
-- \c estacion_climatologica

CREATE TABLE temperatura (
    id_reg SERIAL PRIMARY KEY,
    poblacion VARCHAR(255) NOT NULL,
    min_temp FLOAT NOT NULL DEFAULT 0,
    max_temp FLOAT NOT NULL DEFAULT 0,
    fecha DATE NOT NULL DEFAULT CURRENT_DATE
);

INSERT INTO
    temperatura (
        poblacion,
        min_temp,
        max_temp,
        fecha
    )
VALUES (
        'Almenara',
        10.0,
        23.0,
        '2026-06-01'
    );

INSERT INTO
    temperatura (
        poblacion,
        min_temp,
        max_temp,
        fecha
    )
VALUES (
        'Almenara',
        11.0,
        25.0,
        '2026-06-02'
    );

INSERT INTO
    temperatura (
        poblacion,
        min_temp,
        max_temp,
        fecha
    )
VALUES (
        'Almenara',
        11.0,
        24.2,
        '2026-06-03'
    );

INSERT INTO
    temperatura (
        poblacion,
        min_temp,
        max_temp,
        fecha
    )
VALUES (
        'Sagunto',
        11.2,
        23.5,
        '2026-06-01'
    );

INSERT INTO
    temperatura (
        poblacion,
        min_temp,
        max_temp,
        fecha
    )
VALUES (
        'Sagunto',
        12.4,
        26,
        '2026-06-02'
    );

INSERT INTO
    temperatura (
        poblacion,
        min_temp,
        max_temp,
        fecha
    )
VALUES (
        'Sagunto',
        11.6,
        25,
        '2026-06-03'
    );

INSERT INTO
    temperatura (
        poblacion,
        min_temp,
        max_temp,
        fecha
    )
VALUES ('Faura', 10, 24, '2026-06-02');

INSERT INTO
    temperatura (
        poblacion,
        min_temp,
        max_temp,
        fecha
    )
VALUES ('Faura', 11, 25, '2026-06-03');