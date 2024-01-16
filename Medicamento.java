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
    }

}
