import ExcecoesPersonalizadas.*;
import EnumInterfaces.*;

public class GerenciadorOrdens implements Buscavel {
    private OrdemServico[] ordens;
    private int quantidadeOrdens;

    public GerenciadorOrdens(int capacidade) throws ValorInvalidoException {
        if (capacidade <= 0) {
            throw new ValorInvalidoException("A capacidade do gerenciador de ordens deve ser positiva.");
        }
        this.ordens = new OrdemServico[capacidade];
        this.quantidadeOrdens = 0;
    }

    public int getQuantidadeOrdens() {
        return quantidadeOrdens;
    }

    public void adicionarOrdem(OrdemServico ordem) throws CapacidadeExcedidaException, ValorInvalidoException {
        if (ordem == null) {
            throw new ValorInvalidoException("Ordem de serviço inválida.");
        }
        if (quantidadeOrdens >= ordens.length) {
            throw new CapacidadeExcedidaException("Limite de armazenamento de ordens no gerenciador atingido.");
        }
        if (buscarPorNumero(ordem.getNumero()) != null) {
            throw new ValorInvalidoException("Já existe uma ordem cadastrada com o número " + ordem.getNumero() + ".");
        }

        ordens[quantidadeOrdens] = ordem;
        quantidadeOrdens++;
    }

    public void listarOrdens() {
        if (quantidadeOrdens == 0) {
            System.out.println("\nNenhuma ordem cadastrada até o momento.");
            return;
        }
        System.out.println("\n===== LISTA DE ORDENS DE SERVIÇO =====");
        for (int i = 0; i < quantidadeOrdens; i++) {
            ordens[i].exibirResumo();
        }
    }

    public OrdemServico buscarPorNumero(int numero) {
        for (int i = 0; i < quantidadeOrdens; i++) {
            if (ordens[i].getNumero() == numero) {
                return ordens[i];
            }
        }
        return null;
    }

    @Override
    public void buscarPorInicioDoNome(String inicio) throws ValorInvalidoException {
        if (inicio == null || inicio.trim().isEmpty()) {
            throw new ValorInvalidoException("O texto de busca por nome não pode ser vazio.");
        }
        boolean encontrou = false;
        String termo = inicio.trim().toLowerCase();

        System.out.println("\n===== BUSCA POR CLIENTE: \"" + inicio.trim() + "\" =====");
        for (int i = 0; i < quantidadeOrdens; i++) {
            if (ordens[i].getNomeCliente().toLowerCase().startsWith(termo)) {
                ordens[i].exibirResumo();
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhuma ordem encontrada para clientes com início do nome: " + inicio.trim());
        }
    }

    public void buscarPorPlaca(String placa) {
        if (placa == null || placa.trim().isEmpty()) {
            System.out.println("Placa inválida para busca.");
            return;
        }
        boolean encontrou = false;
        String placaBusca = placa.trim();

        System.out.println("\n===== BUSCA POR PLACA: \"" + placaBusca + "\" =====");
        for (int i = 0; i < quantidadeOrdens; i++) {
            if (ordens[i].getVeiculo().getPlaca().equalsIgnoreCase(placaBusca)) {
                ordens[i].exibirResumo();
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhuma ordem encontrada com a placa: " + placaBusca);
        }
    }
}