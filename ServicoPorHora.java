/*
 * Observação: Na Consolidação 3, Kauan Victor não teve acesso ao Classroom
 * devido a uma ausência por motivos de saúde. Apesar disso, participou do
 * desenvolvimento e contribuiu para a implementação deste projeto.
 */

public class ServicoPorHora extends Servico {
    private int horasTrabalhadas;
    private double valorHora;

    public ServicoPorHora(String descricao, double valorBase, int horasTrabalhadas, double valorHora) {
        super(descricao, valorBase);
        this.horasTrabalhadas = horasTrabalhadas;
        this.valorHora = valorHora;
    }

    public int getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(int horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    @Override
    public double calcularPrecoFinal() {
        return getValorBase() + (this.horasTrabalhadas * this.valorHora);
    }

    @Override
    public void exibirInformacoes() {
        System.out.println(getDescricao());
        System.out.printf("Valor base: R$ %.2f\n", getValorBase());
        System.out.println("Horas trabalhadas: " + this.horasTrabalhadas);
        System.out.printf("Valor/hora: R$ %.2f\n", this.valorHora);
        System.out.printf("Preço final: R$ %.2f\n", this.calcularPrecoFinal());
    }
}