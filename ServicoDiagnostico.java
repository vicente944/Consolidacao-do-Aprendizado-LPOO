public class ServicoDiagnostico extends Servico {
    private boolean possuiReparo;

    public ServicoDiagnostico(String descricao, double valorBase, String realizaReparo) {
        super(descricao, valorBase);
        if (realizaReparo.trim().equalsIgnoreCase("s") || realizaReparo.trim().equalsIgnoreCase("sim"))
            this.possuiReparo = true;
        else
            this.possuiReparo = false;
    }

    public double calcPrecoFinal() {
        if (possuiReparo)
            return getValorBase() / 2;
        else
            return getValorBase();
    }
}
