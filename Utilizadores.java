public class Utilizadores {
    
    private String login;
    private String password;
    private String nome;
    private boolean estado;
    private String email;
    private String tipo;

    public Utilizadores(String llogin, String ppassword, String nnome, boolean eestado, String eemail, String ttipo) {
        this.login = llogin;
        this.password = ppassword;
        this.nome = nnome;
        this.estado = eestado;
        this.email = eemail;
        this.tipo = ttipo;
    }

}
