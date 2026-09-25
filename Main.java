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
            new Servico("Alinhamento", 100.00),
            new Servico("Balanceamento", 120.00),
            new Servico("Troca de pastilhas de freio", 250.00),
            new Servico("Revisão elétrica", 150.00)
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
                        System.out.println("\nServiços disponíveis:");
                        for (int i = 0; i < servicosDisponiveis.length; i++) {
                            System.out.print((i + 1) + ". ");
                            servicosDisponiveis[i].exibirInfo();
                        }

                        System.out.print("Escolha um serviço (número): ");
                        int opcaoServico = lerInteiro();

                        if (opcaoServico >= 1 && opcaoServico <= servicosDisponiveis.length) {
                            ordem.addServico(servicosDisponiveis[opcaoServico - 1]);
                        } else {
                            System.out.println("Opção de serviço inválida!");
                        }

                        System.out.print("Deseja adicionar outro serviço? (S/N): ");
                        continuar = lerString();
                    }

                    gerenciador.addOrdem(ordem);
                    break;
                
                case 2:
                    System.out.println();
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