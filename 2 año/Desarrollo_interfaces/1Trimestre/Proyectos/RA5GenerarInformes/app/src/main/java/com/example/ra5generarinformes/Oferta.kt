package com.example.ra5generarinformes

/**
 * Modelo de datos que representa una oferta de empleo leída desde ofertas.json.
 *
 * @property id Identificador numérico único de la oferta.
 * @property puesto Nombre del puesto ofertado.
 * @property empresa Nombre de la empresa que publica la oferta.
 * @property ciudad Ciudad donde se ubica el puesto.
 * @property salario Salario bruto anual en euros.
 */
data class Oferta(
    val id: Int,
    val puesto: String,
    val empresa: String,
    val ciudad: String,
    val salario: Int
)
