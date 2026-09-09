public class GerencOrdens {
    OS[] ordensServico = new OS[100];

    // (Falta testar) Adiciona ordem de servico ao array do Gerenciador de Ordens
    //(Agora) Adiciona uma ordem de serviço em uma posição específica do array
    public void addOrdem(OS ordemEscolhida, int posicaoDaOrdem) {
        
        if (posicaoDaOrdem >= 0 && posicaoDaOrdem < ordensServico.length) {
            ordensServico[posicaoDaOrdem] = ordemEscolhida;
        } else {
            System.out.println("Erro: Limite de armazenamento de ordens atingido!");
        }
    }

    public void listarOrdens() {
      boolean encontrou = false;
        System.out.println("\n===== LISTA DE ORDENS DE SERVICO =====");

        for (int i = 0; i < ordensServico.length; i++) {
            if (ordensServico[i] != null) {
                ordensServico[i].exibirResum();
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhuma ordem de servico cadastrada ate o momento.");
        }

    }

    public void buscarOrdensNome(String inicioNome) {
       boolean encontrou = false;
        System.out.println("\n===== BUSCA POR NOME: \"" + inicioNome + "\" =====");

        for (int i = 0; i < ordensServico.length; i++) {
            if (ordensServico[i] != null) {
                String nomeAtual = ordensServico[i].nomeCliente.toLowerCase();
                String termoBusca = inicioNome.toLowerCase();

                if (nomeAtual.startsWith(termoBusca)) {
                    ordensServico[i].exibirResum();
                    encontrou = true;
                }
            }
        } // Fechamento correto do for

        if (!encontrou) {
            System.out.println("Nenhuma ordem encontrada para clientes que comecam com: " + inicioNome);
        }

    }


    public void buscarOrdensPlaca(String placaBuscada) {

        boolean encontrou = false;
        System.out.println("\n===== BUSCA POR PLACA: \"" + placaBuscada + "\" =====");

        for (int i = 0; i < ordensServico.length; i++) {
            if (ordensServico[i] != null) {
                // equalsIgnoreCase compara o texto ignorando se as letras são maiúsculas ou minúsculas
                if (ordensServico[i].veiculoCliente.placa.equalsIgnoreCase(placaBuscada)) {
                    ordensServico[i].exibirResum();
                    encontrou = true;
                }
            }
        }

        if (!encontrou) {
            System.out.println("Nenhuma ordem encontrada com a placa: " + placaBuscada);
        }
        
    }
}
