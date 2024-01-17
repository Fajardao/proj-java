public class Farmaceutico extends Utilizadores {

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

        super(llogin, ppassword, nnome, eestado, eemail, ttipo);
        this.nif = nnif;
        this.morada = mmorada;
        this.telefone = ttelefone;
        super.addNifTel(nnif, ttelefone);

    }

    public int getNif() {
        return nif;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setMorada(String mmorada) {
        this.morada = mmorada;
    }

}