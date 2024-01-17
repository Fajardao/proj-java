import java.util.HashSet;
import java.util.Set;

public class Cliente extends Utilizadores {

    private int nif;
    private String morada;
    private int telefone;

    //tornar nif e telefone unicos
    private static Set <Integer> nifsUsados=new HashSet<>();
    private static Set <Integer> telefonesUsados=new HashSet<>();

    public Cliente(String llogin, String ppassword, String nnome, boolean eestado, String eemail, String ttipo, int nnif, String mmorada, int ttelefone) {
        
        super(llogin, ppassword, nnome, eestado, eemail, ttipo);
        this.nif = nnif;
        this.morada = mmorada;
        this.telefone = ttelefone;


        if (verificaUnicidade(nnif, ttelefone)) {
                nifsUsados.add(nnif);
                telefonesUsados.add(ttelefone);
                this.nif = nnif;
                this.telefone = ttelefone;
            } else {
                // Lida com a situação em que o NIF ou telefone não é único
                // Pode lançar uma exceção, retornar um código de erro, etc.
        }
        
    
    }
    private boolean verificaUnicidade(int nnif, int ttelefone) {
        boolean nifUnico= !nifsUsados.contains(nnif);
        boolean telefoneUnico = !telefonesUsados.contains(ttelefone);
        
        if (nifUnico && telefoneUnico) {
            return true;
        } else {
            return false;
        }

    }

    public int getNif(){
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