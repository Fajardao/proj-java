import java.io.IOException;

public class Cliente extends Utilizadores {

    private int nif;
    private String morada;
    private int telefone;

    public Cliente(String llogin, String ppassword, String nnome, boolean eestado, String eemail, String ttipo, int nnif, String mmorada, int ttelefone) throws IOException {

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

    public String toString() {
        return super.toString() + "\nNIF: " + nif + "\nMorada: " + morada + "\nTelefone: " + telefone;
    }

}