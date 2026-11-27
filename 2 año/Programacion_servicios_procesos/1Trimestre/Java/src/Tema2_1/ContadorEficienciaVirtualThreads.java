package Tema2_1;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Ejercicio Tema 2.1: Virtual Threads y metodos de sincronizacion.
 * Cuenta hasta 1.000.000 con 2 Virtual Threads (500.000 incrementos cada uno)
 * comparando: Sin sincronizar, AtomicInteger, synchronized y ReentrantLock.
 */
public class ContadorEficienciaVirtualThreads {

    private static final int INCREMENTOS_POR_HILO = 500_000;

    // 1. Contador sin sincronizacion (sufre condicion de carrera)
    static class ContadorSinSincronizar {
        private int valor = 0;

        public void incrementar() {
            valor++;
        }

        public int getValor() {
            return valor;
        }
    }

    // 2. Contador con AtomicInteger (operaciones atomicas CAS lock-free)
    static class ContadorAtomic {
        private final AtomicInteger valor = new AtomicInteger(0);

        public void incrementar() {
            valor.incrementAndGet();
        }

        public int getValor() {
            return valor.get();
        }
    }

    // 3. Contador con metodo synchronized (monitor intrinseco)
    static class ContadorSynchronized {
        private int valor = 0;

        public synchronized void incrementar() {
            valor++;
        }

        public synchronized int getValor() {
            return valor;
        }
    }

    // 4. Contador con ReentrantLock (cerrojo explicito con try/finally)
    static class ContadorLock {
        private int valor = 0;
        private final Lock lock = new ReentrantLock();

        public void incrementar() {
            lock.lock();
            try {
                valor++;
            } finally {
                lock.unlock();
            }
        }

        public int getValor() {
            lock.lock();
            try {
                return valor;
            } finally {
                lock.unlock();
            }
        }
    }

    private static long ejecutarConDosVirtualThreads(Runnable tareaIncremento) throws InterruptedException {
        long inicio = System.nanoTime();

        Thread v1 = Thread.startVirtualThread(() -> {
            for (int i = 0; i < INCREMENTOS_POR_HILO; i++) {
                tareaIncremento.run();
            }
        });
        Thread v2 = Thread.startVirtualThread(() -> {
            for (int i = 0; i < INCREMENTOS_POR_HILO; i++) {
                tareaIncremento.run();
            }
        });

        v1.join();
        v2.join();

        return System.nanoTime() - inicio;
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Comparativa de eficiencia (2 Virtual Threads -> 1.000.000) ===");

        // 1. Sin sincronizar
        ContadorSinSincronizar cSin = new ContadorSinSincronizar();
        long nsSin = ejecutarConDosVirtualThreads(cSin::incrementar);
        System.out.printf("1. Sin sincronizar -> Valor: %,d | Tiempo: %.3f ms%n", cSin.getValor(), nsSin / 1_000_000.0);

        // 2. AtomicInteger
        ContadorAtomic cAtomic = new ContadorAtomic();
        long nsAtomic = ejecutarConDosVirtualThreads(cAtomic::incrementar);
        System.out.printf("2. AtomicInteger   -> Valor: %,d | Tiempo: %.3f ms%n", cAtomic.getValor(), nsAtomic / 1_000_000.0);

        // 3. Synchronized
        ContadorSynchronized cSync = new ContadorSynchronized();
        long nsSync = ejecutarConDosVirtualThreads(cSync::incrementar);
        System.out.printf("3. Synchronized    -> Valor: %,d | Tiempo: %.3f ms%n", cSync.getValor(), nsSync / 1_000_000.0);

        // 4. ReentrantLock
        ContadorLock cLock = new ContadorLock();
        long nsLock = ejecutarConDosVirtualThreads(cLock::incrementar);
        System.out.printf("4. ReentrantLock   -> Valor: %,d | Tiempo: %.3f ms%n", cLock.getValor(), nsLock / 1_000_000.0);
    }
}
