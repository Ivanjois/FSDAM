public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private char sexo;
    private double peso;
    private double altura;

    public Persona(){this.nombre="Default";this.edad=18;generarDNI();this.sexo='H';this.peso=80;this.altura=1.80;}
    public Persona(String nombre, int edad, char sexo){this.nombre=nombre;this.edad=edad;setSexo(sexo);generarDNI();this.peso=80;this.altura=1.80;}
    public Persona(String nombre, int edad, String dni, char sexo, double peso, double altura){
        this.nombre=nombre;
        this.edad=edad;
        this.dni=dni;
        setSexo(sexo);
        this.peso=peso;
        this.altura=altura;
    }
    private void setSexo(char sexo){
        if(sexo =='H'|| sexo =='h'){
            this.sexo = 'H';
        }else if(sexo == 'M'||sexo == 'm'){
            this.sexo = 'M';
        } else{
            System.out.println("Sexo Invalido");
        }
    }
    private void generarDNI(){
        int numeros = (int) (Math.random() * 10000000);
        char letra = (char) ('A' + Math.random() * 26);
        this.dni=String.format("%08d%c", numeros, letra);
    }
    public int calcularIMC(){
        int IMC = (int) (this.peso/Math.pow(this.altura, 2));
        if(IMC<20){
            return -1;
        }else if(IMC>=20 && IMC<=25){
            return 0;
        }else{
            return 1;
        }
    }
    public boolean esMayorDeEdad(){
        if(this.edad>=18){
            return true;
        }else{
            return false;
        }
    }
    public String toString(){
        String mayorDeEdad;
        String IMC;
        if(esMayorDeEdad()){
            mayorDeEdad = "Es mayor de edad";
        }else{
            mayorDeEdad = "Es menor de edad";
        }
        if(calcularIMC()==-1){
            IMC = "Por debajo del peso ideal";
        }else if(calcularIMC()==0){
            IMC = "Peso ideal";
        }else{
            IMC = "Sobrepeso";
        }
        return "Nombre: " + this.nombre + ", edad: " + this.edad + " años, DNI: " + this.dni + ", sexo: " + this.sexo + ", peso: " + this.peso + "kg, altura: " + this.altura + "m.\n" + mayorDeEdad + "\nIMC: " + IMC;
    }
}
