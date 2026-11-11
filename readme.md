# Oficina Vika Car Services - Sistema Avançado de Gerenciamento de Ordens de Serviço

Este projeto é a consolidação final do sistema de gerenciamento de ordens de serviço para a **Oficina Box 42**, desenvolvido em Java. Ele aplica rigorosamente os pilares da Programação Orientada a Objetos (POO) para garantir um código seguro, escalável e de fácil manutenção.

---

## 🛠️ 1. Instruções para Compilar e Executar

Para rodar a aplicação via console (terminal), certifique-se de ter o [Java JDK](https://www.oracle.com/br/java/technologies/downloads/) instalado na sua máquina (versão 8 ou superior).

1. Abra o terminal (ou prompt de comando) e navegue até a pasta onde estão os arquivos `.java`.
2. **Compile todos os arquivos** executando o comando abaixo:
   ```bash
   javac *.java
   ```
3. **Execute o sistema** iniciando pela classe principal (`Main`):
   ```bash
   java Main
   ```

---

## 🚀 2. Roteiro de Demonstração (Fluxo Principal)

Siga os passos abaixo no menu interativo para demonstrar o funcionamento ideal do sistema:

1. **Cadastro de Ordem:** Escolha a opção `1` no menu. Preencha o número da ordem (ex: 101), dados do cliente (ex: "Ana Silva"), dados do veículo (placa, modelo, ano) e defina a capacidade de serviços (ex: 3).
2. **Adição dos Três Tipos de Serviço:** Escolha a opção `2`, digite o número da ordem criada (101) e adicione um serviço de cada tipo:
   * *Tipo 1 (Com peças):* Ex: Troca de pastilhas (Base: 150.00, Peças: 200.00).
   * *Tipo 2 (Por hora):* Ex: Reparo elétrico (Base: 80.00, Horas: 2, Valor/Hora: 100.00).
   * *Tipo 3 (Diagnóstico):* Ex: Diagnóstico eletrônico (Base: 120.00, Reparo realizado: S).
3. **Busca por Cliente e Placa:** Utilize as opções `4` (busca por nome, ex: "Ana") e `5` (busca por placa) para visualizar a ordem recém-criada e verificar o **cálculo polimórfico** sendo aplicado automaticamente no subtotal.
4. **Aplicação de Desconto:** Escolha a opção `6`, informe a ordem 101 e aplique um desconto (ex: 10%). Liste a ordem novamente (opção `3`) para ver o total recalculado.
5. **Finalização:** Escolha a opção `7` e informe a ordem 101 para mudar seu estado de `ABERTA` para `FINALIZADA`.

---

## ⚠️ 3. Demonstração de Tratamento de Erros

O sistema trata falhas de regra de negócio sem interromper a execução. Para demonstrar as exceções personalizadas, simule os seguintes cenários:

* **Erro 1 - Ordem Vazia (`OrdemVaziaException`):** 
  * *Ação:* Crie uma nova ordem (ex: nº 102). Sem adicionar nenhum serviço, tente usar a opção `7` para finalizá-la.
* **Erro 2 - Capacidade Excedida (`CapacidadeExcedidaException`):** 
  * *Ação:* Crie uma ordem definindo a capacidade máxima como `1`. Adicione um serviço. Tente adicionar um segundo serviço nessa mesma ordem.
* **Erro 3 - Desconto Inválido (`ValorInvalidoException`):** 
  * *Ação:* Vá na opção `6`, escolha uma ordem aberta e tente aplicar um desconto de `150` (acima do limite de 100) ou `-10` (negativo).
* **Erro 4 - Alteração de Ordem Finalizada (`OrdemFinalizadaException`):** 
  * *Ação:* Pegue a ordem 101 (que foi finalizada no roteiro principal). Tente adicionar um novo serviço (opção `2`) ou aplicar um novo desconto (opção `6`).

---

## 🧠 4. Conceitos de POO Aplicados (Explicação Teórica)

Abaixo está o detalhamento de como os requisitos de engenharia de software foram implementados:

* **Encapsulamento:** Todos os atributos do sistema (ex: placa, modelo, arrays de ordens e serviços) estão marcados como `private`. A única forma de acessá-los ou modificá-los é através de construtores e métodos *getters/setters*, que realizam validações (ex: impedir anos negativos, placas vazias ou valores base menores que zero).
* **Herança:** Criamos classes filhas (`ServicoComPecas`, `ServicoPorHora`, `ServicoDiagnostico`) que herdam (`extends`) as características comuns (descrição e valor base) da classe mãe (`Servico`). O uso do método `super()` nos construtores reutiliza a lógica da classe mãe.
* **Classe e Métodos Abstratos:** A classe `Servico` foi declarada como `abstract`, pois não faz sentido instanciar um "serviço genérico" na oficina; todo serviço tem uma regra de preço específica. Os métodos `calcularPrecoFinal()` e `exibirInformacoes()` são abstratos, obrigando as subclasses a implementá-los de forma especializada.
* **Polimorfismo:** Na classe `OrdemServico`, o armazenamento é feito num array generalista: `Servico[] servicos`. Ao calcular o subtotal, o laço de repetição chama `servicos[i].calcularPrecoFinal()`. O Java, dinamicamente, descobre se o objeto naquela posição é um diagnóstico, um serviço por hora ou com peças, e executa a matemática correta **sem o uso de estruturas condicionais (`if` ou `switch`) ou `instanceof`**.
* **Interfaces:** Representam "contratos" de comportamento que classes de diferentes hierarquias podem assinar.
  * A classe `OrdemServico` implementa a interface `Descontavel`, garantindo que ela possui a regra de `aplicarDesconto`.
  * A classe `GerenciadorOrdens` implementa a interface `Buscavel`, garantindo que existe uma padronização no método `buscarPorInicioDoNome`.
* **Exceptions (Tratamento de Exceções):** Foram criadas classes específicas (como `ValorInvalidoException` e `OrdemFinalizadaException`) que herdam da classe raiz `Exception`. Elas substituem mensagens de erro espalhadas pelo código por "lançamentos de erros" formais (`throw new ...`), que são capturados lá na classe `Main` por blocos `try-catch`, separando completamente as regras de negócio das mensagens exibidas ao usuário.