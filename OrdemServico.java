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

    public Veiculo getVeiculoCliente() {
        return veiculoCliente;
    }

    public void exibirResumo() { // Deve exibir resumo incluindo os serviços associados
        System.out.println("Cliente: "+ this.nomeCliente);
        System.out.println("Veículo: " + this.veiculoCliente.getModelo() + "\nPlaca: " + this.veiculoCliente.getPlaca());
        System.out.println("\nServiços realizados: ");
        for (int i=0; i < this.numServicos; i++){
            if (this.servicos[i] != null){
                System.out.println("-"+ this.servicos[i].getDescricao() + ": R$" + this.servicos[i].getValor());
             } 
        }
        System.out.println("Valor total: R$" + this.calcValorTotal());
    }


    // (Funcionando) Calcula o valor total dos servicos adicionados
    public double calcValorTotal() {
        double valorTotal = 0;
        for (int i = 0; i < numServicos; i++) {
            if (servicos[i] != null)
                valorTotal += servicos[i].getValor();
        }
        return valorTotal;
    }

    // (Funcionando) Adiciona o servico ao array da OS
    public void addServico(Servico servico) {
    if (numServicos < servicos.length) {
        servicos[numServicos] = servico;
        numServicos++;
    }
    else 
        System.out.println("Erro: Limite de serviços para esta ordem foi atingido.");
}

    /*
    Aplicar desconto - Em Standby
    public void aplicDesc(double desconto) {
        double margemInf = 0.00;
        double margemSup = 100.00;
        if (margemInf <= desconto && desconto <= margemSup) {
        System.out.println("Valor do desconto: " + (desconto / 100 * valServ));
        valServ = valServ - (desconto / 100 * valServ);
        }
        else
            System.out.println("Desconto invalido.");
    }
        */
}
