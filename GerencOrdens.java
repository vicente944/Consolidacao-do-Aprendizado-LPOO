public class GerencOrdens {
    private OrdemServico[] ordens;
    private int qtdOrdens;

    public GerencOrdens(int capacidade) {
        this.ordens = new OrdemServico[capacidade];
        this.qtdOrdens = 0;
    }

    public int getQtdOrdens() {
        return qtdOrdens;
    }
    public void setQtdOrdens(int qtdOrdens) {
        this.qtdOrdens = qtdOrdens;
    }

    public void addOrdem(OrdemServico ordem) {
        if (qtdOrdens < ordens.length) {
            ordens[qtdOrdens] = ordem;
            qtdOrdens++;
            System.out.println("Ordem cadastrada!");
        }
        else
            System.out.println("Erro: Limite de armazenamento de ordens atingido.");
    }

    public void listarOrdens() {
        if (qtdOrdens == 0) {
            System.out.println("Nenhuma ordem cadastrada ate o momento.");
            return;
        }

        System.out.println("\n===== LISTA DE ORDENS DE SERVICO =====");
        for (int i = 0; i < qtdOrdens; i++) {
            System.out.println("\n --- Ordem nº" + (i + 1) + " ---");
            ordens[i].exibirResumo();
        }
    }

    public void buscarOrdensNome(String inicioNome) {
        boolean encontrou = false;
        System.out.println("\n===== BUSCA POR NOME: \"" + inicioNome + "\" =====");
        for (int i = 0; i < qtdOrdens; i++) {
            if (ordens[i].getNomeCliente().toLowerCase().startsWith(inicioNome.toLowerCase())) {
                System.out.println("\n --- Ordem nº" + (i + 1) + " ---");
                ordens[i].exibirResumo();
                System.out.println();
                encontrou = true;
            }
        }
        if (!encontrou)
            System.out.println("Nenhuma ordem encontrada para clientes que comecam com: " + inicioNome);
    }

    public void buscarOrdensPlaca(String placaBuscada) {
        boolean encontrou = false;
        System.out.println("\n===== BUSCA POR PLACA: \"" + placaBuscada + "\" =====");
        for (int i = 0; i < qtdOrdens; i++) {
            if (ordens[i].getVeiculoCliente().getPlaca().equalsIgnoreCase(placaBuscada)) {
                System.out.println("\n --- Ordem nº" + (i + 1) + " ---");
                ordens[i].exibirResumo();
                System.out.println();
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhuma ordem encontrada com a placa: " + placaBuscada);
        }
    }

    public OrdemServico buscarOrdemPorIndice(int indice) {
        if (indice >= 0 && indice < qtdOrdens) {
            return ordens[indice];
        }
        return null;
    }
}
