public class Encomenda {

    private Medicamento medicamento;
    private Componente componente;
    private Cliente cliente;
    private Farmaceutico farmaceutico;

    public Encomenda(Medicamento mmedicamento, Componente ccomponente, Cliente ccliente) {
        this.medicamento = mmedicamento;
        this.componente = ccomponente;
        this.cliente = ccliente;
    }

    public void setFarmaceutico(Farmaceutico ffarmaceutico) {
        this.farmaceutico = ffarmaceutico;
    }

    public Farmaceutico getFarmaceutico() {
        return farmaceutico;
    }

}
