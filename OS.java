public class OS {
    String nomeCliente;
    Veiculo veiculoCliente;
    int numServicos = 20; // Por enquanto o número será fixado em 20, pq o array não limitava ao numero de servicos de outra forma
    Servico[] servicos = new Servico[numServicos];

    public OS(String nomeCliente, Veiculo veiculoCliente, int numServicos) {
        this.nomeCliente = nomeCliente;
        this.veiculoCliente = veiculoCliente;
        this.numServicos = numServicos;
    }

    // (Falta implementar)
    public void exibirResum() { // Deve exibir resumo incluindo os serviços associados
   
        System.out.println("Cliente:"+ this.nomeCliente);
        System.out.println("Veículo: " + this.veiculoCliente.modelo + "Placa: " + this.veiculoCliente.placa);
        System.out.println("Serviços realizados: ");
        for (int i=0; i< this.numServicos; i++){
            if (this.servicos[i] !=null){
                System.out.println("-"+ this.servicos[i].descricao+ ":R$" + this.servicos[i].valor);
             } 
        }

        System.out.println("Valor total: R$" + this.calcValorTotal());
    }


    // (Funcionando) Calcula o valor total dos servicos adicionados
    public double calcValorTotal() {
        double valorTotal = 0;
        for (int i = 0; i < numServicos; i++) {
            valorTotal = valorTotal + servicos[i].valor;
        }
        return valorTotal;
    }

    // (Funcionando) Adiciona o servico ao array da OS
    public void addServico(Servico servicoEscolhido, int posicaoDoServico) {
            servicos[posicaoDoServico] = servicoEscolhido;
        
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
