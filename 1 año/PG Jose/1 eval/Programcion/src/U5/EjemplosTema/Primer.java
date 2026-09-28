package U5.EjemplosTema;

public class Primer {
    public static void main(String[] args) {
        Coche coche1 = new Coche();

        coche1.setMarca("Ferrari");
        coche1.setModelo("V3");
        coche1.setVelocidad(123);
        coche1.infoCoche();
        coche1.acelerar(10);
        coche1.frenar(50);
        System.out.println();

        Coche coche2 = new Coche();
        coche2.setMarca("BWM");
        coche2.setModelo("3.2");
        coche2.setVelocidad(233);
        coche2.infoCoche();
        coche2.acelerar(10);
        coche2.frenar(50);

    }
}
