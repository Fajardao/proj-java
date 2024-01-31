import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Categoria implements Serializable{
    private String designacao;
    private String classificacaoInfarmed;
    private int codigo; // precisa ser unico
    private String fornecedor;

    private static List<Integer> codigos = new ArrayList<Integer>();

    public Categoria(String ddesignacao, String cclassificacaoImfarmed, int ccodigo, String ffornecedor) {
        this.designacao = ddesignacao;
        this.classificacaoInfarmed = cclassificacaoImfarmed;
        this.codigo = ccodigo;
        this.fornecedor = ffornecedor;

        Categoria.codigos.add(ccodigo);
    }

    public static boolean verificaUnicidade(int ccodigo) {
        boolean codigoUnico = !codigos.contains(ccodigo);

        if (codigoUnico) {
            return true;
        } else {
            return false;
        }
    }

    public String getDesignacao() {
        return designacao;
    }

    public static List<Integer> getCodigos() {
        return codigos;
    }

    public static void setCodigos(List<Integer> ccodigos) {
        codigos = ccodigos;
    }

}