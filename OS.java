public class OS {
    String nomeCliente;
    Veiculo veiculoCliente;
    int numServicos;
    Servico[] servicos = new Servico[numServicos];

    public OS(String nomeCliente, Veiculo veiculoCliente, int numServicos) {
        this.nomeCliente = nomeCliente;
        this.veiculoCliente = veiculoCliente;
        this.numServicos = numServicos;
    }

    public void exibirResum() { // Deve exibir resumo incluindo os serviços associados
        System.out.println();
    }

    public double calcValorTotal() {
        double valorTotal = 0;

        return valorTotal;
    }

    public void addServicos() {

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
