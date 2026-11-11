import java.time.Year;
import ExcecoesPersonalizadas.*;

public class Veiculo {
    private String placa;
    private String modelo;
    private int ano;

    public Veiculo(String placa, String modelo, int ano) throws ValorInvalidoException {
        setPlaca(placa);
        setModelo(modelo);
        setAno(ano);
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) throws ValorInvalidoException {
        if (placa == null || placa.trim().isEmpty()) {
            throw new ValorInvalidoException("A placa do veículo não pode ser vazia.");
        }
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) throws ValorInvalidoException {
        if (modelo == null || modelo.trim().isEmpty()) {
            throw new ValorInvalidoException("O modelo do veículo não pode ser vazio.");
        }
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) throws ValorInvalidoException {
        int anoAtual = Year.now().getValue();
        if (ano <= 0 || ano > anoAtual) {
            throw new ValorInvalidoException("Ano inválido. Deve ser positivo e não superior ao ano atual (" + anoAtual + ").");
        }
        this.ano = ano;
    }

    public void exibirInformacoes() {
        System.out.println("Veículo: " + modelo + " | Placa: " + placa + " | Ano: " + ano);
    }
}