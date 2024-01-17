import java.io.Serializable;

public class Excipiente implements Serializable {
    private String designacao;
    private String classificacaoInfarmed;
    private int quantidade;
    
    public Excipiente(String ddesignacao, String cclassificacaoInfarmed,int qquantidade){
        this.designacao=ddesignacao;
        this.classificacaoInfarmed=cclassificacaoInfarmed;
        this.quantidade=qquantidade;
    }
    

}
