package U5.repaso;

import java.util.HashMap;

public class Empleado {
    private static int contador = 1;
    private int id;
    private String nombre;
    private String puesto;
    private int salario;

    public Empleado(String nombre, String puesto, int salario) {
        this.id = contador;
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
        contador++;
    }
    public int getId() {return this.id;}
    public String getNombre() {return this.nombre;}
    public String getPuesto() {return this.puesto;}
    public int getSalario() {return this.salario;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setPuesto(String puesto) {this.puesto = puesto;}
    public void setSalario(int salario) {this.salario = salario;}
    @Override
    public String toString(){
        return this.nombre + " ,id: " + id + " ,puesto: " + this.puesto + ", salario: " + this.salario;
    }
}
