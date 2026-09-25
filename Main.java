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
        GerencOrdens gerenciador = new GerencOrdens(100);

        // Lista fixa de serviços disponíveis
        Servico[] servicosDisponiveis = {
            new Servico("Troca de óleo", 180.00),
            new Servico("Balanceamento", 120.00),
            new ServicoComPecas("Troca de pastilhas de freio", 150.00, 200.00),
            new ServicoComPecas("Troca de correia dentada", 180.00, 250.00),
            new ServicoPorHora("Alinhamento técnico", 50.00, 1, 50.00),
            new ServicoPorHora("Revisão elétrica", 80.00, 2, 100.00),
            new ServicoDiagnostico("Diagnóstico eletrônico", 120.00, false),
            new ServicoDiagnostico("Diagnóstico de suspensão", 100.00, true)
        };

        int opcao = 0;

        while (opcao != 6) {
            System.out.println("\n=== VIKA CAR SERVICES ===");
            System.out.println("1. Cadastrar ordem de serviço");
            System.out.println("2. Adicionar serviço à ordem");
            System.out.println("3. Listar ordens de serviço");
            System.out.println("4. Buscar ordens pelo início do nome do cliente");
            System.out.println("5. Buscar ordem pela placa do veículo");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = lerInteiro();

            switch (opcao) {
                case 1:
                    System.out.print("\nNome do cliente: ");
                    String nomeCliente = lerString();

                    System.out.print("Placa do veículo: ");
                    String placa = lerString();

                    System.out.print("Modelo: ");
                    String modelo = lerString();

                    System.out.print("Ano: ");
                    int ano = lerInteiro();

                    Veiculo veiculo = new Veiculo(placa, modelo, ano);
                    OrdemServico ordem = new OrdemServico(nomeCliente, veiculo, 10); // Máximo de serviços por ordem fixo em 10

                    String continuar = "S";
                    while (continuar.equalsIgnoreCase("S")) {
                        System.out.println("\n=== TIPO DE SERVIÇO ===");
                        System.out.println("1. Serviço comum");
                        System.out.println("2. Serviço com peças");
                        System.out.println("3. Serviço por hora");
                        System.out.println("4. Diagnóstico");
                        System.out.print("Escolha uma opção: ");
                        int tipo = lerInteiro();

                        if (tipo < 1 || tipo > 4) {
                            System.out.println("Opção inválida! Tente novamente.");
                        } 
                        else {
                            System.out.print("Descrição do serviço: ");
                            String desc = lerString();

                            System.out.print("Valor base: R$ ");
                            double vBase = lerDecimal();

                            Servico novoServico = null;

                            switch (tipo) {
                                case 1:
                                    novoServico = new Servico(desc, vBase);
                                    break;

                                case 2:
                                    System.out.print("Valor das peças: R$ ");
                                    double vPecas = lerDecimal();
                                    novoServico = new ServicoComPecas(desc, vBase, vPecas);
                                    break;

                                case 3:
                                    System.out.print("Horas trabalhadas: ");
                                    int horas = lerInteiro();
                                    System.out.print("Valor por hora: R$ ");
                                    double vHora = lerDecimal();
                                    novoServico = new ServicoPorHora(desc, vBase, horas, vHora);
                                    break;

                                case 4:
                                    System.out.print("O cliente realizou o reparo? (S/N): ");
                                    boolean rep = lerString().equalsIgnoreCase("S");
                                    novoServico = new ServicoDiagnostico(desc, vBase, rep);
                                    break;
                            }

                            if (novoServico != null) {
                                ordem.addServico(novoServico);
                                System.out.println("Serviço adicionado com sucesso!");
                            }
                        }
                        System.out.print("\nDeseja adicionar outro serviço a esta ordem? (S/N): ");
                        continuar = lerString();
                    }
                    gerenciador.addOrdem(ordem);
                    break;
                
                case 2:
                    if (gerenciador.getQtdOrdens() == 0) {
                        System.out.println("\nNenhuma ordem cadastrada! Crie uma ordem primeiro.");
                        break;
                    }

                    gerenciador.listarOrdens();
                    System.out.print("\nInforme o número da ordem que deseja alterar (1 a " + gerenciador.getQtdOrdens() + "): ");
                    int numOrdem = lerInteiro();

                    OrdemServico ordemSelecionada = gerenciador.buscarOrdemPorIndice(numOrdem - 1);
                    if (ordemSelecionada == null) {
                        System.out.println("Ordem inválida!");
                        break;
                    }

                    System.out.println("\n=== TIPO DE SERVIÇO ===");
                    System.out.println("1 - Serviço comum");
                    System.out.println("2 - Serviço com peças");
                    System.out.println("3 - Serviço por hora");
                    System.out.println("4 - Diagnóstico");
                    System.out.print("Escolha o tipo: ");
                    int tipo = lerInteiro();

                    System.out.print("Descrição do serviço: ");
                    String desc = lerString();
                    System.out.print("Valor base: R$ ");
                    double vBase = lerDecimal();

                    Servico novoServico = null;

                    switch (tipo) {
                        case 1:
                            novoServico = new Servico(desc, vBase);
                            break;
                        case 2:
                            System.out.print("Valor das peças: R$ ");
                            double vPecas = lerDecimal();
                            novoServico = new ServicoComPecas(desc, vBase, vPecas);
                            break;
                        case 3:
                            System.out.print("Horas trabalhadas: ");
                            int horas = lerInteiro();
                            System.out.print("Valor por hora: R$ ");
                            double vHora = lerDecimal();
                            novoServico = new ServicoPorHora(desc, vBase, horas, vHora);
                            break;
                        case 4:
                            System.out.print("O cliente realizou o reparo? (S/N): ");
                            boolean rep = lerString().equalsIgnoreCase("S");
                            novoServico = new ServicoDiagnostico(desc, vBase, rep);
                            break;
                        default:
                            System.out.println("Tipo inválido!");
                    }

                    if (novoServico != null) {
                        ordemSelecionada.addServico(novoServico);
                        System.out.println("Serviço adicionado com sucesso!");
                    }
                    break;

                case 3:
                    gerenciador.listarOrdens();
                    break;

                case 4:
                    System.out.print("\nDigite o início do nome do cliente: ");
                    String inicioNome = lerString();
                    gerenciador.buscarOrdensNome(inicioNome);
                    break;

                case 5:
                    System.out.print("\nDigite a placa do veículo: ");
                    String placaBusca = lerString();
                    gerenciador.buscarOrdensPlaca(placaBusca);
                    break;

                case 6:
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}