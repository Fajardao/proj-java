import java.io.Serializable;
import java.time.LocalDate;

public class Encomenda implements Serializable {

    private int id;
    private Medicamento medicamento;
    private Componente componente;
    private Cliente cliente;
    private Farmaceutico farmaceutico;
    private float total;
    private String data;
    private String conclusao;
    private String tipo;
    private int estado; // 1 - pendente, 2 - aceite, 3 - decorrer, 4 - concluido, 5 - encerrado
    private static int idCount = 1;

    public Encomenda(Object info, Cliente ccliente, int type) {
        if (type == 1) {
            this.medicamento = (Medicamento) info;
            this.total = this.medicamento.getPrecoVenda();
        } else if (type == 2) {
            this.componente = (Componente) info;
        }
        farmaceutico = null;
        this.cliente = ccliente;
        this.id = idCount++;
        this.data = LocalDate.now().toString();
        this.tipo = "normal";
        this.estado = 1;

    }

    public void setFarmaceutico(Farmaceutico ffarmaceutico) {
        this.farmaceutico = ffarmaceutico;
    }

    public Farmaceutico getFarmaceutico() {
        return farmaceutico;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public Componente getComponente() {
        return componente;
    }

    public static int getIdCount() {
        return idCount;
    }

    public static void setIdCount(int idCount) {
        Encomenda.idCount = idCount;
    }

    public int getId() {
        return id;
    }

    public void changeTipo(int ttipo) {
        if (ttipo == 1) {
            this.tipo = "normal";
        } else if (ttipo == 2) {
            this.tipo = "urgente";
        }
    }

    public String getTipo() {
        return tipo;
    }

    public void changeEstado(int eestado) {
        this.estado = eestado;
    } 

    public int getEstado() {
        return estado;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    public void complete() {
        this.estado = 4;
        this.conclusao = LocalDate.now().toString();
    }

    public String toString() {
        String str = this.id + " - " + this.tipo + " - ";

        if (this.estado == 1) {
            str += "pendente";
        } else if (this.estado == 2) {
            str += "aceite";
        } else if (this.estado == 3) {
            str += "decorrer";
        } else if (this.estado == 4) {
            str += "concluido";
        } else if (this.estado == 5) {
            str += "encerrado";
        }

        return str;
    }

    public String getDetails() {
        String str = "ID: " + this.id + "\n";
        str += "Tipo: " + this.tipo + "\n";
        str += "Estado: ";

        if (this.estado == 1) {
            str += "pendente";
        } else if (this.estado == 2) {
            str += "aceite";
        } else if (this.estado == 3) {
            str += "decorrer";
        } else if (this.estado == 4) {
            str += "concluido";
        } else if (this.estado == 5) {
            str += "encerrado";
        }

        if (this.componente != null) {
            str += "\nComponente: " + this.componente.getDesignacao() + "\n";
        } else if (this.medicamento != null) {
            str += "Medicamento: " + this.medicamento.getDesignacao() + "\n";
            str += "Total: " + this.total + "\n";
        }

        str += "\n";
        str += "Data: " + this.data + "\n";
        
        if (this.conclusao != null) {
            str += "Conclusao: " + this.conclusao + "\n";
        } else {
            str += "Conclusao: - Não concluido\n";
        }

        str += "Cliente: " + this.cliente.getNome() + "\n";
        str += "Farmaceutico: " + this.farmaceutico.getNome() + "\n";

        return str;
    }

}
