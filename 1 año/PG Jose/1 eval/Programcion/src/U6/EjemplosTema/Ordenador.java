package U6.EjemplosTema;

import java.util.ArrayList;
import java.util.Objects;

public class Ordenador {
    private Procesador cpu;
    private ArrayList<MemoriaRam> bancosRam;
    private final int MAX_RAM_SLOTS = 4;

    Ordenador(Procesador cpu) {
        this.cpu = cpu;
        this.bancosRam = new ArrayList<>();
    }

    public void anadirRam(MemoriaRam ram) {
        if (this.bancosRam.size() < MAX_RAM_SLOTS && ram.getTecnologia().equals(this.bancosRam.getFirst().getTecnologia())) {
            this.bancosRam.add(ram);
        } else {
            System.out.println("No se pueden añadir el modulo de memoria RAM porque no queda espacio");
        }
    }

    public void mostrarConfiguracion() {
        int Ram = 0;
        System.out.println("CPU: " + this.cpu);
        System.out.println("Memoria RAM: ");
        for (MemoriaRam ram : this.bancosRam) {
            Ram += ram.getCapacidad();
        }
        System.out.println("Total: "+Ram + "GB");
    }

}
