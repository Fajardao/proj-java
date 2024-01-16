import java.io.Serializable;
import java.util.List;

public class Files implements Serializable {
    private List<Utilizadores> users;
    // Adicione outras listas de dados aqui

    public Files(List<Utilizadores> users) {
        this.users = users;
    }

    public List<Utilizadores> getUsers() {
        return users;
    }

    // Adicione outros getters e setters aqui
}