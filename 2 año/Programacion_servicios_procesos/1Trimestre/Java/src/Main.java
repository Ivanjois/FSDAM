void main() {
    Runtime runtime = Runtime.getRuntime();
    try {
        Process proceso = runtime.exec("ls");
    } catch (IOException e){
        e.printStackTrace();
    }
}