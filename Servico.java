public class Servico {
    private String descricao;
    private double valorBase;

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

    public void exibirInfo() {
        System.out.println(this.descricao + " .......... R$ " + this.valorBase);
        }

    public double calcPrecoFinal(){
        return valorBase;
    }
}
