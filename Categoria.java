import java.io.Serializable;

public class Categoria implements Serializable{
    private String designacao;
    private String classificacaoInfarmed;
    private int codigo; // precisa ser unico
    private String fornecedor;

    public Categoria(String ddesignacao, String cclassificacaoImfarmed, int ccodigo, String ffornecedor) {
        this.designacao = ddesignacao;
        this.classificacaoInfarmed = cclassificacaoImfarmed;
        this.codigo = ccodigo;
        this.fornecedor = ffornecedor;
    }

}