import java.io.Serializable;

public class Componente implements Serializable{

    private String designacao;
    private String codigo;
    private int quantidade;

    public Componente(String ddesignacao, String ccodigo, int qquantidade) {
        this.designacao = ddesignacao;
        this.codigo = ccodigo;
        this.quantidade = qquantidade;
    }

    public String getDesignacao() {
        return designacao;
    }

}