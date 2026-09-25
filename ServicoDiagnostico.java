
/*
 * Observação: Na Consolidação 3, Kauan Victor não teve acesso ao Classroom
 * devido a uma ausência por motivos de saúde. Apesar disso, participou do
 * desenvolvimento e contribuiu para a implementação deste projeto.
 */
public class ServicoDiagnostico extends Servico {
    private boolean possuiReparo;

    public ServicoDiagnostico(String descricao, double valorBase, boolean possuiReparo) {
        super(descricao, valorBase);
        this.possuiReparo = possuiReparo;
    }

    public boolean isPossuiReparo() {
        return possuiReparo;
    }

    public void setPossuiReparo(boolean possuiReparo) {
        this.possuiReparo = possuiReparo;
    }

    @Override
    public double calcularPrecoFinal() {
        if (this.possuiReparo) {
            return getValorBase() * 0.50; // 50% de desconto caso o reparo seja realizado
        }
        return getValorBase();
    }

    @Override
    public void exibirInformacoes() {
        System.out.println(getDescricao());
        System.out.printf("Valor base: R$ %.2f\n", getValorBase());
        System.out.println("Reparo realizado: " + (this.possuiReparo ? "Sim" : "Não"));
        System.out.printf("Preço final: R$ %.2f\n", this.calcularPrecoFinal());
    }
}