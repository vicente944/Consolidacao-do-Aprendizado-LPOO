import ExcecoesPersonalizadas.*;

public abstract class Servico {
    private String descricao;
    private double valorBase;

    public Servico(String descricao, double valorBase) throws ValorInvalidoException {
        setDescricao(descricao);
        setValorBase(valorBase);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) throws ValorInvalidoException {
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new ValorInvalidoException("A descrição do serviço não pode ser vazia.");
        }
        this.descricao = descricao;
    }

    public double getValorBase() {
        return valorBase;
    }

    public void setValorBase(double valorBase) throws ValorInvalidoException {
        if (valorBase <= 0) {
            throw new ValorInvalidoException("O valor base do serviço deve ser maior que zero.");
        }
        this.valorBase = valorBase;
    }

    public abstract double calcularPrecoFinal();
    public abstract void exibirInformacoes();
}