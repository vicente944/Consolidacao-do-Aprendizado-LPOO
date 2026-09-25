/*
 * Observação: Na Consolidação 3, Kauan Victor não teve acesso ao Classroom
 * devido a uma ausência por motivos de saúde. Apesar disso, participou do
 * desenvolvimento e contribuiu para a implementação deste projeto.
 */
public class Servico {
    private String descricao;
    private double valorBase;

    // Construtor principal da classe base
    public Servico(String descricao, double valorBase) {
        this.descricao = descricao;
        this.valorBase = valorBase;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorBase() {
        return valorBase;
    }

    public void setValorBase(double valorBase) {
        this.valorBase = valorBase;
    }

    // Método compatível para códigos antigos que usavam getValor()
    public double getValor() {
        return this.calcularPrecoFinal();
    }

    // Regra da classe base: retorna o valor base sem acréscimos
    public double calcularPrecoFinal() {
        return this.valorBase;
    }

    // Exibição oficial da Consolidação 3
    public void exibirInformacoes() {
        System.out.println(this.descricao);
        System.out.printf("Valor base: R$ %.2f\n", this.valorBase);
        System.out.printf("Preço final: R$ %.2f\n", this.calcularPrecoFinal());
    }

    // Método de compatibilidade para chamadas antigas do Main
    public void exibirInfo() {
        this.exibirInformacoes();
    }
}