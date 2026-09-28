package U5.ActividadesInicio;

public class Usuario {
    private String username;
    private String emailAddress;
    private String password;
    Usuario(String username, String emailAddress, String password) {
        this.setUsername(username);
        this.setEmailAddress(emailAddress);
        this.setPassword(password);
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmailAddress() {
        return emailAddress;
    }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        if (password.length() >= 8) {
            this.password = password;
        }
        else {
            System.out.println("Debe tener 8 caracteres o más");
        }
    }
}
