public class OrdemServico {
    private String nomeCliente;
    private Veiculo veiculoCliente;
    private Servico[] servicos;
    private int numServicos;

    public OrdemServico(String nomeCliente, Veiculo veiculoCliente, int maxServicos) {
        this.nomeCliente = nomeCliente;
        this.veiculoCliente = veiculoCliente;
        this.servicos = new Servico[maxServicos];
        this.numServicos = 0;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public Veiculo getVeiculoCliente() {
        return veiculoCliente;
    }

    public void setVeiculoCliente(Veiculo veiculoCliente) {
        this.veiculoCliente = veiculoCliente;
    }

    public void exibirResumo() { // Deve exibir resumo incluindo os serviços associados
        System.out.println("Cliente: "+ this.nomeCliente);
        System.out.println("Veículo: " + this.veiculoCliente.getModelo() + "\nPlaca: " + this.veiculoCliente.getPlaca());
        System.out.println("\nServiços realizados: ");
        for (int i=0; i < this.numServicos; i++){
            if (this.servicos[i] != null){
                System.out.println("-"+ this.servicos[i].getDescricao() + ": R$" + this.servicos[i].getValorBase());
                System.out.println("Valor base: R$" + servicos[i].getValorBase());
                if (servicos[i] instanceof ServicoComPecas) 
                    System.out.println("Valor das peças: R$" + servicos[i].getValorPecas());
             } 
        }
        System.out.println("Valor total: R$" + this.calcValorTotal());
    }

    public double calcValorTotal() {
        double valorTotal = 0;
        for (int i = 0; i < numServicos; i++) {
            if (servicos[i] != null)
                valorTotal += servicos[i].getValorBase();
        }
        return valorTotal;
    }

    public void addServico(Servico servico) {
        if (numServicos < servicos.length) {
            servicos[numServicos] = servico;
            numServicos++;
        }
        else 
            System.out.println("Erro: Limite de serviços para esta ordem foi atingido.");
    }
}
