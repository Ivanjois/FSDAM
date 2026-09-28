package U6.ActividadesAvanzadas.model;

import java.util.ArrayList;

public abstract class Personaje implements Atacable {
    protected String nombre;
    protected int vida;
    protected int nivel, agilidad, resistencia;
    protected ArrayList<Item> Mochila;

    public Personaje(String nombre, int vida, int nivel, int agilidad, int resistencia) {
        this.nombre = nombre;
        this.vida = vida;
        this.nivel = nivel;
        this.agilidad = agilidad;
        this.resistencia = resistencia;
        this.Mochila = new ArrayList<Item>();
    }

    public void cogerItem(Item item) {
        this.Mochila.add(item);
    }
    public String getNombre() {
        return this.nombre;
    }

    public abstract void atarcar(Personaje enemigo);

    @Override
    public boolean estaVivo() {
        if (this.vida <= 0) {
            this.vida = 0;
            return false;
        }else {
            return true;
        }
    }

    @Override
    public void recibirDano(int dano, int getAumentoDefensa) {
        dano -= this.resistencia;
        if (dano <= 0) {
            this.resistencia -= dano;
            dano = 0;
        } else {
            this.resistencia = 0;
            this.vida -= dano;
            estaVivo();
        }
        this.resistencia += getAumentoDefensa;
        System.out.println("El " + this.nombre + " recibe un ataque de " + dano + " y le queda de vida "+this.vida);
    }

    @Override
    public String toString() {
        return "Nombre: " + this.nombre + ", Vida: " + this.vida + ", Nivel: " + this.nivel + ", Agilidad: " + this.agilidad + ", Resistencia: " + this.resistencia;
    }
}
