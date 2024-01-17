import java.io.Serializable;
import java.util.List;

public class Files implements Serializable {
    private List<Utilizadores> users;
    private List<Farmaceutico> farmaceuticos;
    private List<Cliente> clientes;
    private List<Medicamento> medicamentos;
    private List<Componente> componentes;
    private List<Encomenda> encomendas;

    public Files(List<Utilizadores> uusers, List<Farmaceutico> ffarmaceuticos, List<Cliente> cclientes, List<Medicamento> mmedicamentos, List<Componente> ccomponentes, List<Encomenda> eencomendas) {
        this.users = uusers;
        this.farmaceuticos = ffarmaceuticos;
        this.clientes = cclientes;
        this.medicamentos = mmedicamentos;
        this.componentes = ccomponentes;
        this.encomendas = eencomendas;
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

}