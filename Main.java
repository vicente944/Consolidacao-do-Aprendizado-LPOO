class Main {
    public static void main(String[] args) {
        // Definição dos serviços disponíveis
        Servico trocaOleo = new Servico("Troca de óleo do motor", 180.00);
        Servico alinhamento = new Servico("Alinhamento de direção", 90.00);
        Servico balanceamento = new Servico("Balanceamento de 4 rodas", 80.00);
        Servico trocaPastilhas = new Servico("Troca de pastilhas de freio", 250.00);
        Servico revisaoEletrica = new Servico("Revisão elétrica completa", 150.00);

        System.out.println("--- Vika Car Services ---");

        int i = 0;
        // Essa parte foi pensada para estar dentro de um loop while -> while (i != 5)
        System.out.println("1. Cadastrar Ordem de Servico\n2. Listar Ordens de Servico\n3. Buscar ordens pelo inicio do nome do cliente\n4. Buscar ordens pelo inicio da placa do carro\n5. Sair");
        
        i = 1; // simula a entrada do usuario para a primeira opção
        System.out.println("Escolha um servico: " + i);
        System.out.println();

        // Cadastrar OS
        if (i == 1) {
            // Dados do Veiculo
            System.out.println("Insira os dados do veiculo: ");
            Veiculo veiculo1 = new Veiculo("placa1", "modelo1", 2025);
            System.out.println("Placa: " + veiculo1.placa + "\nModelo: " + veiculo1.modelo + "\nAno: " + veiculo1.ano);
            System.out.println();
            
            // Dados do Cliente
            System.out.println("Insira o nome do cliente e quantos servicos serao realizados: ");
            OS os1 = new OS("Cliente1", veiculo1, 3);
            System.out.println("Nome do Cliente: " + os1.nomeCliente + "\nNumero de Servicos: " + os1.numServicos);
            System.out.println();

            // Escolha dos Servicos
            Servico.exibirInfo();
            System.out.println();

            // Servicos escolhidos:
            os1.addServico(trocaOleo, 0);
            os1.addServico(balanceamento, 1);
            os1.addServico(revisaoEletrica, 2);

            // Valor total
            System.out.println("Valor total dos servicos escolhidos: R$ " + os1.calcValorTotal());
            System.out.println();


            // Mensagem de ordem cadastrada
            System.out.println("Ordem cadastrada com sucesso!");



        }

        else if (i == 2) {
            
        }

        else if (i == 3) {
            
        }
        
        else if (i == 4) {
            
        }

        else if (i == 5) {
            System.out.println("Fechando o programa...");
        }
        
        else
            System.out.println("Acao invalida! Digite um dos numeros acima.");

        
        





        /* Código antido - Consolidação 1
        System.out.println("---------- Veiculo 1 ");
        Veiculo carro1 = new Veiculo();

        carro1.placa = "placalegal";
        carro1.modelo = "modeloshow";
        carro1.ano = 2021;

        System.out.println("----- Informacoes do veiculo: ");
        carro1.calcIdade(2026);
        carro1.exibirInfo();

        System.out.println(""); // Linha extra
        //Testes da classe OS
        OS serv1 = new OS();

        serv1.nomeCli = "Junior";
        serv1.descServ = "Descricao errada";
        serv1.valServ = 1000.55;
        serv1.veiculoCliente = carro1;

        System.out.println("----- Resumo do servico antes do desconto");
        serv1.exibirResum(); // Resumo antes do desconto
        
        System.out.println(""); // Linha extra

        System.out.println("----- Aplicacao do desconto");
        serv1.aplicDesc(210); // Desconto propositalmente invalido!!!
        
        System.out.println(""); // Linha extra
        
        System.out.println("----- Resumo do servico depois do desconto");
        serv1.exibirResum(); // Resumo depois do desconto
        
        System.out.println(""); // Linha extra

        System.out.println("---------- Depois que foi verificado o registro incorreto do Veiculo 1, trocar para Veiculo 2 ----------");

        System.out.println(""); // Linha extra

        System.out.println("---------- Veiculo 2 ");
        Veiculo carro2 = new Veiculo();

        carro2.placa = "placamassa";
        carro2.modelo = "modelotop";
        carro2.ano = 2023;

        System.out.println("----- Informacoes do veiculo: ");
        carro2.calcIdade(2026);
        carro2.exibirInfo();

        System.out.println(""); // Linha extra
        //Testes da classe OS

        serv1.nomeCli = "Major";
        serv1.descServ = "Descricao certa";
        serv1.valServ = 7500.99;
        serv1.veiculoCliente = carro2;

        System.out.println("----- Resumo do servico antes do desconto");
        serv1.exibirResum(); // Resumo antes do desconto
        
        System.out.println(""); // Linha extra

        System.out.println("----- Aplicacao do desconto");
        serv1.aplicDesc(15);
        
        System.out.println(""); // Linha extra
        
        System.out.println("----- Resumo do servico depois do desconto");
        
        serv1.exibirResum(); // Resumo depois do desconto

        System.out.println(""); // Linha extra
        System.out.println(""); // Linha extra
        System.out.println("Autores: \nVicente Souza\nKauan Moura");*/
    } 
}

