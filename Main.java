import ExcecoesPersonalizadas.*;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static String lerString() {
        return scanner.nextLine().trim();
    }

    public static int lerInteiro() {
        return Integer.parseInt(scanner.nextLine().trim());
    }

    public static double lerDecimal() {
        return Double.parseDouble(scanner.nextLine().trim());
    }

    public static void main(String[] args) {
        GerenciadorOrdens gerenciador;
        try {
            gerenciador = new GerenciadorOrdens(20);
        } catch (ValorInvalidoException e) {
            System.out.println("Erro crítico ao inicializar sistema: " + e.getMessage());
            return;
        }

        int opcao = 0;

        while (opcao != 8) {
            try {
                System.out.println("\n=== OFICINA BOX 42 ===");
                System.out.println("1 - Criar ordem de serviço");
                System.out.println("2 - Adicionar serviço à ordem");
                System.out.println("3 - Listar ordens");
                System.out.println("4 - Buscar ordens por cliente");
                System.out.println("5 - Buscar ordens por placa");
                System.out.println("6 - Aplicar desconto");
                System.out.println("7 - Finalizar ordem");
                System.out.println("8 - Sair");
                System.out.print("Escolha uma opção: ");

                opcao = lerInteiro();

                switch (opcao) {
                    case 1:
                        System.out.print("\nNúmero da Ordem: ");
                        int numeroOS = lerInteiro();

                        System.out.print("Nome do cliente: ");
                        String nomeCliente = lerString();

                        System.out.print("Placa do veículo: ");
                        String placa = lerString();

                        System.out.print("Modelo: ");
                        String modelo = lerString();

                        System.out.print("Ano: ");
                        int ano = lerInteiro();

                        System.out.print("Capacidade máxima de serviços nesta ordem: ");
                        int capServicos = lerInteiro();

                        Veiculo veiculo = new Veiculo(placa, modelo, ano);
                        OrdemServico novaOrdem = new OrdemServico(numeroOS, nomeCliente, veiculo, capServicos);
                        
                        gerenciador.adicionarOrdem(novaOrdem);
                        System.out.println("Ordem nº " + numeroOS + " criada com sucesso!");
                        break;

                    case 2:
                        System.out.print("\nDigite o número da Ordem de Serviço: ");
                        int numOS = lerInteiro();
                        OrdemServico osEncontrada = gerenciador.buscarPorNumero(numOS);

                        if (osEncontrada == null) {
                            System.out.println("Erro: Ordem de serviço nº " + numOS + " não existe!");
                            break;
                        }

                        System.out.println("\n=== TIPO DE SERVIÇO ===");
                        System.out.println("1 - Serviço com peças");
                        System.out.println("2 - Serviço por hora");
                        System.out.println("3 - Diagnóstico");
                        System.out.print("Escolha o tipo: ");
                        int tipoServico = lerInteiro();

                        System.out.print("Descrição do serviço: ");
                        String desc = lerString();

                        System.out.print("Valor base: R$ ");
                        double vBase = lerDecimal();

                        Servico novoServico = null;

                        switch (tipoServico) {
                            case 1:
                                System.out.print("Valor das peças: R$ ");
                                double vPecas = lerDecimal();
                                novoServico = new ServicoComPecas(desc, vBase, vPecas);
                                break;
                            case 2:
                                System.out.print("Horas trabalhadas: ");
                                double horas = lerDecimal();
                                System.out.print("Valor por hora: R$ ");
                                double vHora = lerDecimal();
                                novoServico = new ServicoPorHora(desc, vBase, horas, vHora);
                                break;
                            case 3:
                                System.out.print("O cliente realizou o reparo? (S/N): ");
                                boolean rep = lerString().equalsIgnoreCase("S");
                                novoServico = new ServicoDiagnostico(desc, vBase, rep);
                                break;
                            default:
                                System.out.println("Tipo de serviço inválido!");
                        }

                        if (novoServico != null) {
                            osEncontrada.adicionarServico(novoServico);
                            System.out.println("Serviço adicionado com sucesso à Ordem nº " + numOS + "!");
                        }
                        break;

                    case 3:
                        gerenciador.listarOrdens();
                        break;

                    case 4:
                        System.out.print("\nDigite o início do nome do cliente: ");
                        String buscaNome = lerString();
                        gerenciador.buscarPorInicioDoNome(buscaNome);
                        break;

                    case 5:
                        System.out.print("\nDigite a placa do veículo: ");
                        String buscaPlaca = lerString();
                        gerenciador.buscarPorPlaca(buscaPlaca);
                        break;

                    case 6:
                        System.out.print("\nDigite o número da Ordem para aplicar desconto: ");
                        int numOSDesc = lerInteiro();
                        OrdemServico osDesc = gerenciador.buscarPorNumero(numOSDesc);

                        if (osDesc == null) {
                            System.out.println("Erro: Ordem de serviço nº " + numOSDesc + " não existe!");
                            break;
                        }

                        System.out.print("Informe o percentual de desconto (0 a 100): ");
                        double perc = lerDecimal();
                        
                        double novoTotal = osDesc.aplicarDesconto(perc);
                        System.out.printf("Desconto aplicado! Novo total da Ordem nº %d: R$ %.2f\n", numOSDesc, novoTotal);
                        break;

                    case 7:
                        System.out.print("\nDigite o número da Ordem que deseja finalizar: ");
                        int numOSFim = lerInteiro();
                        OrdemServico osFim = gerenciador.buscarPorNumero(numOSFim);

                        if (osFim == null) {
                            System.out.println("Erro: Ordem de serviço nº " + numOSFim + " não existe!");
                            break;
                        }

                        osFim.finalizar();
                        System.out.println("Ordem nº " + numOSFim + " finalizada com sucesso!");
                        break;

                    case 8:
                        System.out.println("Encerrando o sistema...");
                        break;

                    default:
                        System.out.println("Opção inválida! Digite um número entre 1 e 8.");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERRO DE LEITURA: Entrada numérica inválida. Digite números corretamente.");
            } catch (ValorInvalidoException | OrdemVaziaException | CapacidadeExcedidaException | OrdemFinalizadaException e) {
                System.out.println("ERRO DE REGRA DE NEGÓCIO: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("ERRO INESPERADO: " + e.getMessage());
            }
        }
    }
}