public class Veiculo {
    private String placa;
    private String modelo;
    private int ano;

    public String getPlaca() {
        return placa;
    }

    public String getModelo () {
        return modelo;
    }

    public int getAno() {
        return ano;
    }

    public Veiculo(String placa, String modelo, int ano) {
        this.placa = placa;
        this.modelo = modelo;
        this.ano = ano;
    }

    public void exibirInfo() {
        System.out.println("Placa: " + placa +"\n"+ "Modelo: " + modelo +"\n"+ "Ano: " + ano);
    }

    public void calcIdade(int anoAtual) {
        System.out.println("Idade do veiculo: " + (anoAtual - ano) + " ano(s)");
    }
}
