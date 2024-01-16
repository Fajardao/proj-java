public class Farmaceutico {
    
    private String login;
    private String password;
    private String nome;
    private boolean estado;
    private String email;
    private String tipo;
    private int nif;
    private String morada;
    private int telefone;

    public Farmaceutico(String llogin, String ppassword, String nnome, boolean eestado, String eemail, String ttipo, int nnif, String mmorada, int ttelefone) {
        
        this.login = llogin;
        this.password = ppassword;
        this.nome = nnome;
        this.estado = eestado;
        this.email = eemail;
        this.tipo = ttipo;
        this.nif = nnif;
        this.morada = mmorada;
        this.telefone = ttelefone;

    }


    public int getNif(){
        return nif;
    }

    public int getTelefone(){
        return telefone;
    }
}