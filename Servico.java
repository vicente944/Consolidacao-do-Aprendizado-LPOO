public class Servico {
    String descricao;
    double valor;

    public Servico(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public static void exibirInfo() {
        // Definição dos serviços disponíveis
        Servico trocaOleo = new Servico("Troca de óleo do motor", 180.00);
        Servico alinhamento = new Servico("Alinhamento de direção", 90.00);
        Servico balanceamento = new Servico("Balanceamento de 4 rodas", 80.00);
        Servico trocaPastilhas = new Servico("Troca de pastilhas de freio", 250.00);
        Servico revisaoEletrica = new Servico("Revisão elétrica completa", 150.00);

        System.out.println("Servicos disponiveis: ");
        System.out.println("1. " + trocaOleo.descricao + " .......... R$ " + trocaOleo.valor);
        System.out.println("2. " + alinhamento.descricao + " .......... R$ " + alinhamento.valor);
        System.out.println("3. " + balanceamento.descricao + " .......... R$ " + balanceamento.valor);
        System.out.println("4. " + trocaPastilhas.descricao + " .......... R$ " + trocaPastilhas.valor);
        System.out.println("5. " + revisaoEletrica.descricao + " .......... R$ " + revisaoEletrica.valor);
    }
}
