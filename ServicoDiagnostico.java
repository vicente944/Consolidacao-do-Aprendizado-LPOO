import ExcecoesPersonalizadas.*;

public class ServicoDiagnostico extends Servico {
    private boolean possuiReparo;

    public ServicoDiagnostico(String descricao, double valorBase, boolean possuiReparo) throws ValorInvalidoException {
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
        if (possuiReparo) {
            return getValorBase() * 0.50;
        }
        return getValorBase();
    }

    @Override
    public void exibirInformacoes() {
        System.out.println(getDescricao() + " (Diagnóstico)");
        System.out.printf("  Valor base: R$ %.2f\n", getValorBase());
        System.out.println("  Reparo realizado: " + (possuiReparo ? "Sim" : "Não"));
        System.out.printf("  Preço final: R$ %.2f\n", calcularPrecoFinal());
    }
}