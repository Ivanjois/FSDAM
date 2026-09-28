package U5.ActividadesInicio;

import java.util.ArrayList;

public class mainBicicletas {
    public static void main(String[] args) {
        ArrayList<Bicicleta> bicicletas = new ArrayList<Bicicleta>();
        Bicicleta a = new Bicicleta("cal", "ab");
        Bicicleta b = new Bicicleta("cul", "ad");
        Bicicleta c = new Bicicleta("cel", "ax");
        bicicletas.add(a);
        bicicletas.add(b);
        bicicletas.add(c);
        for (Bicicleta bicicleta : bicicletas) {
            System.out.println(bicicleta.toString());
        }
        System.out.println(Bicicleta.getContadorDeBicicletas());

    }
}
