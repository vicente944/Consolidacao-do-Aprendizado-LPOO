public class ServicoPorHora extends Servico {
    private double horasTrabalhadas;
    private double valorHora;

    public ServicoPorHora(String descricao, double valorBase, double horasTrabalhadas, double valorHora) {
        super(descricao, valorBase);
        this.horasTrabalhadas = horasTrabalhadas;
        this.valorHora = valorHora;
    }

    public double getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(double horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    public double calcPrecoFinal() {
        return getValorBase() + (getHorasTrabalhadas() * getValorHora());
    }
}
