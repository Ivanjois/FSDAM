package Tema0.miniterminal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class MiniFileManager {
    private File currentDir;

    public MiniFileManager() {
        this.currentDir = new File(System.getProperty("user.dir"));
    }

    public String getPWD() throws IOException {
        return currentDir.getCanonicalPath();
    }

    public boolean changeDir(String dir) throws IOException {
        if (dir == null || dir.isBlank()) {
            throw new IllegalArgumentException("Debes indicar un directorio.");
        }

        File target;
        if (dir.equals("..")) {
            target = currentDir.getParentFile();
            if (target == null) {
                throw new IOException("Ya te encuentras en el directorio raiz.");
            }
        } else {
            File candidate = new File(dir);
            target = candidate.isAbsolute() ? candidate : new File(currentDir, dir);
        }

        if (!target.exists() || !target.isDirectory()) {
            throw new FileNotFoundException("El directorio no existe: " + dir);
        }

        currentDir = target.getCanonicalFile();
        return true;
    }

    public void printList(boolean info) throws IOException {
        File[] files = currentDir.listFiles();
        if (files == null) {
            throw new IOException("No se puede listar el contenido de: " + getPWD());
        }

        List<File> directorios = new ArrayList<>();
        List<File> archivos = new ArrayList<>();

        for (File f : files) {
            if (f.isDirectory()) {
                directorios.add(f);
            } else {
                archivos.add(f);
            }
        }

        Comparator<File> porNombre = Comparator.comparing(f -> f.getName().toLowerCase());
        directorios.sort(porNombre);
        archivos.sort(porNombre);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        for (File d : directorios) {
            if (info) {
                System.out.printf("[DIR]  %-30s %10s  %s%n",
                        d.getName(), "-", sdf.format(new Date(d.lastModified())));
            } else {
                System.out.println("[*] " + d.getName());
            }
        }

        for (File a : archivos) {
            if (info) {
                System.out.printf("[FILE] %-30s %10d B  %s%n",
                        a.getName(), a.length(), sdf.format(new Date(a.lastModified())));
            } else {
                System.out.println("    " + a.getName());
            }
        }
    }

    public void makeDir(String dir) throws IOException {
        if (dir == null || dir.isBlank()) {
            throw new IllegalArgumentException("Debes indicar el nombre del directorio.");
        }
        File nuevo = new File(currentDir, dir);
        if (nuevo.exists()) {
            throw new IOException("Ya existe un archivo o carpeta con ese nombre: " + dir);
        }
        if (!nuevo.mkdir()) {
            throw new IOException("No se pudo crear el directorio: " + dir);
        }
    }

    public void removeFile(String fileName) throws IOException {
        if (fileName == null || fileName.isBlank()) {
            throw new IllegalArgumentException("Debes indicar el archivo o carpeta a borrar.");
        }
        File target = new File(currentDir, fileName);
        if (!target.exists()) {
            throw new FileNotFoundException("No existe el archivo o carpeta: " + fileName);
        }

        if (target.isFile()) {
            if (!target.delete()) {
                throw new IOException("No se pudo borrar el archivo: " + fileName);
            }
            return;
        }

        File[] hijos = target.listFiles();
        boolean tieneSubcarpetas = false;
        if (hijos != null) {
            for (File hijo : hijos) {
                if (hijo.isDirectory()) {
                    tieneSubcarpetas = true;
                } else if (!hijo.delete()) {
                    throw new IOException("No se pudo borrar el archivo interno: " + hijo.getName());
                }
            }
        }

        if (tieneSubcarpetas) {
            System.out.println("Advertencia: La carpeta '" + fileName
                    + "' contiene subcarpetas. Se han borrado los archivos sueltos, pero las subcarpetas y la carpeta principal se dejan intactas.");
        } else if (!target.delete()) {
            throw new IOException("No se pudo borrar la carpeta: " + fileName);
        }
    }

    public void moveFile(String sourceName, String destName) throws IOException {
        if (sourceName == null || destName == null || sourceName.isBlank() || destName.isBlank()) {
            throw new IllegalArgumentException("Uso correcto: mv <FILE1> <FILE2>");
        }
        File origen = new File(currentDir, sourceName);
        if (!origen.exists()) {
            throw new FileNotFoundException("No existe el origen: " + sourceName);
        }

        File destino = new File(currentDir, destName);
        if (destino.exists() && destino.isDirectory()) {
            destino = new File(destino, origen.getName());
        }

        if (!origen.renameTo(destino)) {
            throw new IOException("No se pudo mover o renombrar '" + sourceName + "' a '" + destName + "'.");
        }
    }
}
