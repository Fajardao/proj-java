import java.io.Serializable;
import java.util.List;

public class Files implements Serializable {
    private List<Utilizadores> users;
    private List<Farmaceutico> farmaceuticos;
    private List<Cliente> clientes;

    public Files(List<Utilizadores> uusers, List<Farmaceutico> ffarmaceuticos, List<Cliente> cclientes) {
        this.users = uusers;
        this.farmaceuticos = ffarmaceuticos;
        this.clientes = cclientes;
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

}