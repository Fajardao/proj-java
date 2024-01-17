import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Utilizadores implements Serializable {

    private String login;
    private String password;
    private String nome;
    private boolean estado;
    private String email;
    private String tipo;
    private static Set <String> loginsUsados=new HashSet();//******************************************************************************* */
    private static Set <String> emailsUsados=new HashSet();





    public Utilizadores(String llogin, String ppassword, String nnome, boolean eestado, String eemail, String ttipo) {
        this.login = llogin;
        this.password = ppassword;
        this.nome = nnome;
        this.estado = eestado;
        this.email = eemail;
        this.tipo = ttipo;
        
        if (loginsUsados.contains(login)|| emailsUsados.contains(email)){
            System.out.println("O email ou user já estão a ser usados");
        } else{
            loginsUsados.add(login);
            emailsUsados.add(email);
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



    //R4
    //Criação de um metodo para verificar se o login do usuario
    //que quer fazer alterações nas informações é igual ao login
    //que foi passado como parametro, visto que cada utilizador
    //apenas pode alterar a sua propria informaçao


    public boolean podeAlterarInformacao(String loginAtual){
        return this.login.equals(loginAtual);
    }

    //R5. O login e email devem ser unicos 

}