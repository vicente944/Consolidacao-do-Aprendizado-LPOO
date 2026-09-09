class Main {
    public static void main(String[] args) {
        // Definição dos serviços disponíveis
        Servico trocaOleo = new Servico("Troca de óleo do motor", 180.00);
        Servico alinhamento = new Servico("Alinhamento de direção", 90.00);
        Servico balanceamento = new Servico("Balanceamento de 4 rodas", 80.00);
        Servico trocaPastilhas = new Servico("Troca de pastilhas de freio", 250.00);
        Servico revisaoEletrica = new Servico("Revisão elétrica completa", 150.00);
        
        Veiculo veiculo1 = new Veiculo("placa1", "modelo1", 2025);
        OS ordem1 = new OS("Cliente1", veiculo1, 3);





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

