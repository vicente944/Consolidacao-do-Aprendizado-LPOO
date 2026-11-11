import ExcecoesPersonalizadas.*;

public class ServicoPorHora extends Servico {
    private double horasTrabalhadas;
    private double valorHora;

    public ServicoPorHora(String descricao, double valorBase, double horasTrabalhadas, double valorHora) throws ValorInvalidoException {
        super(descricao, valorBase);
        setHorasTrabalhadas(horasTrabalhadas);
        setValorHora(valorHora);
    }

    public double getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(double horasTrabalhadas) throws ValorInvalidoException {
        if (horasTrabalhadas <= 0) {
            throw new ValorInvalidoException("As horas trabalhadas devem ser maiores que zero.");
        }
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) throws ValorInvalidoException {
        if (valorHora <= 0) {
            throw new ValorInvalidoException("O valor da hora deve ser maior que zero.");
        }
        this.valorHora = valorHora;
    }

    @Override
    public double calcularPrecoFinal() {
        return getValorBase() + (horasTrabalhadas * valorHora);
    }

    @Override
    public void exibirInformacoes() {
        System.out.println(getDescricao() + " (Por Hora)");
        System.out.printf("  Valor base: R$ %.2f\n", getValorBase());
        System.out.printf("  Horas trabalhadas: %.1fh | Valor/hora: R$ %.2f\n", horasTrabalhadas, valorHora);
        System.out.printf("  Preço final: R$ %.2f\n", calcularPrecoFinal());
    }
}