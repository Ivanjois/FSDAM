package U4.repaso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
public class U04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> lista = new ArrayList<String>();//Declaración de ArrayList
        lista.add("Rojo");
        lista.add("Azul");
        lista.add("Verde");

        System.out.println(lista);//Printear una lista

        for(String l: lista){
            System.out.println(l);
        }//For each de arraylist

        lista.add(0,"Amarillo");//Añadir en posicion 0, desplaza el resto
        System.out.println(lista);

        System.out.println(lista.get(2));//Printeamos la posicion 2 de la lista

        System.out.println("Introduce indice a sustituir");
        int indice = sc.nextInt();
        sc.nextLine();//Por favor limpiad siempre el buffer después de un int
        System.out.println("Nuevo color");
        String color = sc.nextLine();
        lista.set(indice,color);//Sustituimos color
        System.out.println(lista);

        lista.remove(1);//Si conocemos el indice, no necesitamos iterator
        System.out.println(lista);

        System.out.println("Introduce un color");
        String color2 = sc.nextLine();
        if(lista.contains(color2)){
            System.out.println("Color encontrado");
        }else{
            System.out.println("Color no encontrado");
        }//.contains devuelve un booleano

        Iterator<String> it = lista.iterator();//Declaración de iterator
        while(it.hasNext()){
            if(it.next().equals("Azul")){
                it.remove();
            }
        }//Al recorrer una lista en un bucle necesitamos un iterator para asegurarnos que se borra correctamente

        Collections.sort(lista);//Ordenamos alfabeticamente la lista
        System.out.println(lista);

        ArrayList<String> listaCopia = new ArrayList<>(lista);//Clonamos la lista
        System.out.println(listaCopia);

        Collections.shuffle(lista);//"Baraja" la lista
        System.out.println(lista);

        Collections.reverse(lista);//Revertimos la lista
        System.out.println(lista);

        System.out.println(lista.subList(1,2));//Pillamos una parte de la lista, pero no pillamos 1 y 2, el ultimo no se incluye, seria del 1 al 1

        if(lista.equals(listaCopia)){
            System.out.println("Son iguales");
        }else {
            System.out.println("No son iguales");
        }
        ArrayList<String> lista2 = new ArrayList<>(lista);
        if(lista.equals(lista2)){
            System.out.println("Son iguales");
        }else {
            System.out.println("No son iguales");
        }
        //Con equals en una lista comparamos tamaño de la lista y cada indice con su paralelo

        Collections.swap(lista,0,1);//Intercambiamos un indice con el otro
        System.out.println(lista);

        lista.addAll(lista2);//Une ambas listas en una
        System.out.println(lista);
        System.out.println(lista2);

        Object copia = lista.clone();//La anterior era una copia simple, esto es un clonado
        System.out.println(copia);

        lista.clear();//Borra entera la lista
        System.out.println(lista);

        if(lista.isEmpty()){
            System.out.println("Está vacía");
        }
    }
}