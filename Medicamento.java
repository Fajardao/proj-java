import java.util.ArrayList;
import java.util.List;

public class Medicamento {

    private String designacao;
    private String marca;
    private String laboratorio;
    private String lote;
    private Componente componenteActivo;
    private String dosagem;
    private int quantidadeStock;
    private double precoVenda;
    private int anoFabrico;
    private boolean autorizacaoMedica;
    private boolean generico;
    private List<Categoria> categorias; //categorias é uma lista de objetos da classe Categoria
    private List<Excipiente> excipientes; //excipientes é uma lista de objetos da classe Excipiente


    public Medicamento(String ddesignacao, String mmarca, String llaboratorio, String llote, Componente ccomponenteActivo, String ddosagem, int qquantidadeStock, double pprecoVenda, int aanoFabrico, boolean aautorizacaoMedica, boolean ggenerico) {
        this.designacao = ddesignacao;
        this.marca = mmarca;
        this.laboratorio = llaboratorio;
        this.lote = llote;
        this.componenteActivo = ccomponenteActivo;
        this.dosagem = ddosagem;
        this.quantidadeStock = qquantidadeStock;
        this.precoVenda = pprecoVenda;
        this.anoFabrico = aanoFabrico;
        this.autorizacaoMedica = aautorizacaoMedica;
        this.generico = ggenerico;
        this.categorias=new ArrayList<>();
        this.excipientes=new ArrayList<>();
    }
    public void adicionarCategoria(Categoria categoria) {
        if (categorias.size() < 3) {
            categorias.add(categoria);
        } else {
            System.out.println("Não é possível adicionar mais categorias a este medicamento.");
        }
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void adcionarExcipientes(Excipiente excipiente){
        if(excipientes.size() < 5){
            excipientes.add(excipiente);
        } else {
            System.out.println("Não é possível adcionar mais excipientes a este medicamento.");
        }
    }

    public List<Excipiente> getExcipientes() {
        return excipientes;
    }
    
    public String getDesignacao() {
        return designacao;
    }

}