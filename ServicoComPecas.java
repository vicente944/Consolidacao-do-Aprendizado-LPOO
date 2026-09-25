/*
 * Observação: Na Consolidação 3, Kauan Victor não teve acesso ao Classroom
 * devido a uma ausência por motivos de saúde. Apesar disso, participou do
 * desenvolvimento e contribuiu para a implementação deste projeto.
 */

public class ServicoComPecas extends Servico {
    private double valorPecas;

    public ServicoComPecas(String descricao, double valorBase, double valorPecas) {
        super(descricao, valorBase); // Chama o construtor da classe base Servico
        this.valorPecas = valorPecas;
    }

    public double getValorPecas() {
        return valorPecas;
    }

    public void setValorPecas(double valorPecas) {
        this.valorPecas = valorPecas;
    }

    @Override
    public double calcularPrecoFinal() {
        return getValorBase() + this.valorPecas;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println(getDescricao());
        System.out.printf("Valor base: R$ %.2f\n", getValorBase());
        System.out.printf("Peças: R$ %.2f\n", this.valorPecas);
        System.out.printf("Preço final: R$ %.2f\n", this.calcularPrecoFinal());
    }
}
