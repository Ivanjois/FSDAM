package U5.ActividadesAvanzadas;

import javax.swing.*;

public class Persona {
    private String nombre;
    private int edad;
    private String DNI;
    private char sexo;
    private double peso;
    private double altura;

    public Persona() {
        this.nombre = "Ivan";
        this.edad = 22;
        this.generarDNI();
        this.sexo = 'M';
        this.peso = 22.5;
        this.altura = 1.4;
    }

    public Persona(String nombre, int edad, char sexo) {
        this.setNombre(nombre);
        this.setEdad(edad);
        this.setSexo(sexo);
        this.generarDNI();
        this.peso = 22.5;
        this.altura = 1.4;
    }

    public Persona(String nombre, int edad, String DNI, char sexo, double peso, double altura) {
        this.setNombre(nombre);
        this.setEdad(edad);
        this.DNI = DNI;
        this.setSexo(sexo);
        this.setPeso(peso);
        this.setAltura(altura);
    }

    public int calcularIMC(double peso, double altura) {
        double peso_imc = peso / (altura * altura);
        if (peso_imc < 20) {
            return -1;
        } else if (peso_imc >= 20 && peso_imc <= 25) {
            return 0;
        } else {
            return 1;
        }
    }

    public boolean esMayorDeEdad(int edad) {
        return edad >= 18;
    }

    public String toString() {
        return "[FICHA PERSONA] \n\n Persona 1: " + this.getNombre() + ".\n Resultado IMC: " + this.calcularIMC(peso, altura) + ".\n¿Es mayor de edad?: " + getEdad() + ".\n\n Información completa:\n [Nombre: " + getNombre() + ", Edad: " + getEdad() + ", DNI: " + getDNI() + ", Sexo: H, Peso: 75.5kg, Altura: 1.80m]";
    }

    private void generarDNI() {
        String DNI = "";
        for (int i = 0; i <= 8; i++) {
            int numeroAleatorio = (int) (Math.random() * 10);
            DNI += numeroAleatorio;
        }
        int dni = Integer.parseInt(DNI);
        String caracteres = "TRWAGMYFPDXBNJZSQVHLCKE";
        int resto = dni % 23;
        char letra = caracteres.charAt(resto);
        this.DNI = DNI + letra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDNI() {
        return DNI;
    }

    public char getSexo() {
        return sexo;
    }
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
}