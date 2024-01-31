import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

public class Utilizadores implements Serializable {

    private String login;
    private String password;
    private String nome;
    private boolean estado;
    private String email;
    private String tipo;

    private static List <String> loginsUsados=new ArrayList<>();
    private static List<String> emailsUsados = new ArrayList<>();

    private static List<Integer> nifsUsados = new ArrayList<>();
    private static List<Integer> telefonesUsados = new ArrayList<>();

    public Utilizadores(String llogin, String ppassword, String nnome, boolean eestado, String eemail, String ttipo) throws IOException {
        this.login = llogin;
        this.password = ppassword;
        this.nome = nnome;
        this.estado = eestado;
        this.email = eemail;
        this.tipo = ttipo;

        loginsUsados.add(llogin);
        emailsUsados.add(eemail);

        Files.saveTxt(eemail + " / " + ppassword);
    }
    
    public static boolean verificaUnicidade(String llogin, String eemail) {
        boolean loginUnico= !loginsUsados.contains(llogin);
        boolean emailUnico = !emailsUsados.contains(eemail);
        
        if (loginUnico && emailUnico) {
            return true;
        } else {
            return false;
        }

    }

    public String getEmail() {
        return email;
    }

    public boolean verificaPassword(String pass) {
        if (pass.equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean getAtivo() {
        return estado;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setAtivo() {
        this.estado = true;
    }

    public void setNome(String nnome) {
        this.nome = nnome;
    }

    public void setPassword(String ppassword) {
        this.password = ppassword;
    }

    public void addNifTel(int nnif, int ttelefone) {
        nifsUsados.add(nnif);
        telefonesUsados.add(ttelefone);
    }

    public static boolean verifyNifTel(int nnif, int ttelefone) {
        boolean nifUnico = !nifsUsados.contains(nnif);
        boolean telefoneUnico = !telefonesUsados.contains(ttelefone);

        if (nifUnico && telefoneUnico) {
            return true;
        } else {
            return false;
        }

    }

    public static List<String> getLoginsUsados() {
        return loginsUsados;
    }

    public static List<String> getEmailsUsados() {
        return emailsUsados;
    }

    public static List<Integer> getNifsUsados() {
        return nifsUsados;
    }

    public static List<Integer> getTelefonesUsados() {
        return telefonesUsados;
    }

    public static void setLoginsUsados(List<String> loginsUsados) {
        Utilizadores.loginsUsados = loginsUsados;
    }

    public static void setEmailsUsados(List<String> emailsUsados) {
        Utilizadores.emailsUsados = emailsUsados;
    }

    public static void setNifsUsados(List<Integer> nifsUsados) {
        Utilizadores.nifsUsados = nifsUsados;
    }

    public static void setTelefonesUsados(List<Integer> telefonesUsados) {
        Utilizadores.telefonesUsados = telefonesUsados;
    }

    public String getLogin() {
        return login;
    }

    public String toString() {
        String string = "Nome: " + nome + "\nEmail: " + email + "\nLogin: " + login + "\nPassword: " + password + "\nTipo: " + tipo + "\nEstado: ";
        
                if (estado) {
                    string += "Ativo";
                } else {
                    string += "Inativo";
                }

        return string;
    }

}