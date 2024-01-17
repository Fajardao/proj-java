import java.io.Serializable;

public class Encomenda implements Serializable {

    private Medicamento medicamento;
    private Componente componente;
    private Cliente cliente;
    private Farmaceutico farmaceutico;
    private boolean confirmado;
    private float total;
    private int data;
    private int conclusao;

    public Encomenda(Object info, Cliente ccliente, int tipo) {
        if (tipo == 1) {
            this.medicamento = (Medicamento) info;
        } else if (tipo == 2) {
            this.componente = (Componente) info;
        }
        this.cliente = ccliente;
        this.confirmado = false;
    }

    public void setFarmaceutico(Farmaceutico ffarmaceutico) {
        this.farmaceutico = ffarmaceutico;
    }

    public Farmaceutico getFarmaceutico() {
        return farmaceutico;
    }

    public void confirmarEncomenda() {
        this.confirmado = true;
    }

    public boolean getConfirmado() {
        return confirmado;
    }

    public String toString() {
        return medicamento.getDesignacao() + " - " + cliente.getNome();
    }

}
