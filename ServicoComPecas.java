public class ServicoComPecas extends Servico {
    private double valorPecas;

    public ServicoComPecas(String descricao, double valorBase, double valorPecas) {
        super(descricao, valorBase);
        this.valorPecas = valorPecas;
    }
    
    public double getValorPecas() {
        return valorPecas;
    }

    public void setValorPecas(double valorPecas) {
        this.valorPecas = valorPecas;
    }

    public double calcPrecoFinal() {
        return getValorBase() + getValorPecas();
    }
}
