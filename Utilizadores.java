import java.io.Serializable;

public class Utilizadores implements Serializable {

    private String login;
    private String password;
    private String nome;
    private boolean estado;
    private String email;
    private String tipo;
    private static Set <String> loginsUsados=new HashSet<>();//******************************************************************************* */

    public Utilizadores(String llogin, String ppassword, String nnome, boolean eestado, String eemail, String ttipo) {
        this.login = llogin;
        this.password = ppassword;
        this.nome = nnome;
        this.estado = eestado;
        this.email = eemail;
        this.tipo = ttipo;

        if (loginsUsados.contains(login)){

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

}