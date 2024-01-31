import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public class Files implements Serializable {
    private List<Utilizadores> users;
    private List<Farmaceutico> farmaceuticos;
    private List<Cliente> clientes;
    private List<Medicamento> medicamentos;
    private List<Componente> componentes;
    private List<Encomenda> encomendas;
    private List<Integer> codigos;
    private int encIdCount;
    private List<String> emailsUsados;
    private List<String> loginsUsados;
    private List<Integer> nifsUsados;
    private List<Integer> telefonesUsados;

    public Files(List<Utilizadores> uusers, List<Farmaceutico> ffarmaceuticos, List<Cliente> cclientes,
            List<Medicamento> mmedicamentos, List<Componente> ccomponentes, List<Encomenda> eencomendas,
            List<Integer> ccodigos, int eencIdCount, List<String> eemailsUsados, List<String> lloginsUsados,
            List<Integer> nNifsUsados, List<Integer> tTelefonesUsados) {
        this.users = uusers;
        this.farmaceuticos = ffarmaceuticos;
        this.clientes = cclientes;
        this.medicamentos = mmedicamentos;
        this.componentes = ccomponentes;
        this.encomendas = eencomendas;
        this.codigos = ccodigos;
        this.encIdCount = eencIdCount;
        this.emailsUsados = eemailsUsados;
        this.loginsUsados = lloginsUsados;
        this.nifsUsados = nNifsUsados;
        this.telefonesUsados = tTelefonesUsados;

    }

    public List<Utilizadores> getUsers() {
        return users;
    }

    public List<Farmaceutico> getFarmaceuticos() {
        return farmaceuticos;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public List<Componente> getComponentes() {
        return componentes;
    }

    public List<Encomenda> getEncomendas() {
        return encomendas;
    }

    public List<Integer> getCodigos() {
        return codigos;
    }

    public int getEncIdCount() {
        return encIdCount;
    }

    public List<String> getEmailsUsados() {
        return emailsUsados;
    }

    public List<String> getLoginsUsados() {
        return loginsUsados;
    }

    public List<Integer> getNifsUsados() {
        return nifsUsados;
    }

    public List<Integer> getTelefonesUsados() {
        return telefonesUsados;
    }

    public static void saveTxt(String texto) throws IOException {

        FileWriter fw = new FileWriter("credenciais_acesso.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(texto);
        bw.newLine();
        bw.close();

    }

}