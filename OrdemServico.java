import ExcecoesPersonalizadas.*;
import EnumInterfaces.*;

public class OrdemServico implements Descontavel {
    private int numero;
    private String nomeCliente;
    private Veiculo veiculo;
    private Servico[] servicos;
    private int quantidadeServicos;
    private double percentualDesconto;
    private EstadoOrdem estado;

    public OrdemServico(int numero, String nomeCliente, Veiculo veiculo, int capacidade) throws ValorInvalidoException {
        if (numero <= 0) {
            throw new ValorInvalidoException("O número da ordem deve ser positivo.");
        }
        if (nomeCliente == null || nomeCliente.trim().isEmpty()) {
            throw new ValorInvalidoException("O nome do cliente não pode ser vazio.");
        }
        if (veiculo == null) {
            throw new ValorInvalidoException("O veículo não pode ser nulo.");
        }
        if (capacidade <= 0) {
            throw new ValorInvalidoException("A capacidade de serviços deve ser maior que zero.");
        }

        this.numero = numero;
        this.nomeCliente = nomeCliente;
        this.veiculo = veiculo;
        this.servicos = new Servico[capacidade];
        this.quantidadeServicos = 0;
        this.percentualDesconto = 0.0;
        this.estado = EstadoOrdem.ABERTA;
    }

    public int getNumero() { return numero; }
    public String getNomeCliente() { return nomeCliente; }
    public Veiculo getVeiculo() { return veiculo; }
    public EstadoOrdem getEstado() { return estado; }
    public double getPercentualDesconto() { return percentualDesconto; }

    public void adicionarServico(Servico servico) throws CapacidadeExcedidaException, OrdemFinalizadaException, ValorInvalidoException {
        if (this.estado == EstadoOrdem.FINALIZADA) {
            throw new OrdemFinalizadaException("Não é possível adicionar serviços a uma ordem FINALIZADA.");
        }
        if (servico == null) {
            throw new ValorInvalidoException("O serviço não pode ser nulo.");
        }
        if (this.quantidadeServicos >= this.servicos.length) {
            throw new CapacidadeExcedidaException("Capacidade máxima de serviços para esta ordem foi atingida.");
        }

        this.servicos[this.quantidadeServicos] = servico;
        this.quantidadeServicos++;
    }

    public double calcularSubtotal() {
        double subtotal = 0.0;
        for (int i = 0; i < quantidadeServicos; i++) {
            subtotal += servicos[i].calcularPrecoFinal();
        }
        return subtotal;
    }

    public double calcularTotal() {
        return calcularSubtotal() * (1.0 - (percentualDesconto / 100.0));
    }

    @Override
    public double aplicarDesconto(double percentual) throws ValorInvalidoException, OrdemFinalizadaException {
        if (this.estado == EstadoOrdem.FINALIZADA) {
            throw new OrdemFinalizadaException("Não é possível alterar o desconto de uma ordem FINALIZADA.");
        }
        if (percentual < 0 || percentual > 100) {
            throw new ValorInvalidoException("O percentual de desconto deve estar entre 0 e 100.");
        }

        this.percentualDesconto = percentual;
        return calcularTotal();
    }

    public void finalizar() throws OrdemVaziaException {
        if (this.quantidadeServicos == 0) {
            throw new OrdemVaziaException("Não é possível finalizar uma ordem de serviço sem serviços cadastradas.");
        }
        this.estado = EstadoOrdem.FINALIZADA;
    }

    public void exibirResumo() {
        System.out.println("\n------------------------------------------------");
        System.out.println("Ordem nº " + numero + " [" + estado + "]");
        System.out.println("Cliente: " + nomeCliente);
        veiculo.exibirInformacoes();
        System.out.println("\nSERVIÇOS:");
        if (quantidadeServicos == 0) {
            System.out.println(" (Nenhum serviço adicionado)");
        } else {
            for (int i = 0; i < quantidadeServicos; i++) {
                servicos[i].exibirInformacoes();
                System.out.println();
            }
        }
        System.out.printf("Subtotal: R$ %.2f\n", calcularSubtotal());
        System.out.printf("Desconto: %.2f%%\n", percentualDesconto);
        System.out.printf("TOTAL DA ORDEM: R$ %.2f\n", calcularTotal());
        System.out.println("------------------------------------------------");
    }
}