public class MainPersona {
    public static void main(String[] args) {
        Persona persona = new Persona();
        Persona persona2 = new Persona("Víctor", 24, 'H');
        Persona persona3 = new Persona("Juan", 29, "49203040Y", 'M', 65, 1.90);
        System.out.println(persona.toString());
        System.out.println(persona2.toString());
        System.out.println(persona3.toString());
    }
}