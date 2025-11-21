# Portfólio de Exercícios: Programação Orientada a Objetos (Java) ☕

Este repositório contém a resolução de uma lista de exercícios práticos desenvolvidos para a disciplina de **Programação Orientada a Objetos**. O foco principal das atividades foi comparar paradigmas de desenvolvimento (Estruturado vs. Orientado a Objetos), implementar robustez com tratamento de exceções e manipular estruturas de dados complexas.

## 🛠️ Tecnologias Utilizadas
* **Linguagem:** Java (JDK 8+)
* **IDE:** IntelliJ IDEA
* **Conceitos:** Polimorfismo, Herança, Tratamento de Exceções, Manipulação de Matrizes.

---

## 📂 Estrutura do Projeto

### [Exercício 1: Sistema de Pagamento de Professores](Atividade1/src/SistemaPolimorfico.java)
**Objetivo:** Comparar a manutenibilidade entre um sistema polimórfico e um não-polimórfico.

* **Cenário:** Cálculo de salários para Professores Horistas, Dedicação Exclusiva e Pesquisadores.
* **Conceitos Aplicados:**
    * Criação de Classes Abstratas (`Professor`).
    * Implementação de Herança e Sobrescrita de Métodos (`@Override`).
    * **Análise Crítica:** Demonstração de como a abordagem OO respeita o princípio *Open/Closed* (SOLID), facilitando a extensão do código sem modificar regras existentes.

### [Exercício 2: Sistema de Comissões de Vendas](Atividade2/src/SistemaComissao.java)
**Objetivo:** Implementar regras de negócio complexas e hierarquia de classes.

* **Cenário:** Cálculo de comissões para Vendedores Júnior, Sênior (com metas) e Gerentes (com fixo + comissão de equipe).
* **Conceitos Aplicados:**
    * Encapsulamento de regras de negócio específicas (Metas e Bônus).
    * Lista Heterogênea (Polimorfismo em Coleções).
    * Comparação com *Anti-Patterns* (uso excessivo de `if/else` e "God Class").

### [Exercício 3: Tratamento de Exceções (Robustez)](Atividade3/src/Pergunta3.java)
**Objetivo:** Refatorar um código legado para prevenir falhas de execução (*crashes*).

* **Cenário:** Um sistema de divisão de números baseado em dígitos de telefone.
* **Conceitos Aplicados:**
    * Uso de blocos `try-catch-finally`.
    * Tratamento de `InputMismatchException` (entrada de texto em campo numérico).
    * Tratamento de `ArithmeticException` (divisão por zero).
    * Gerenciamento de recursos (fechamento seguro do `Scanner`).

### [Exercício 4: Operações Matriciais](Atividade4/src/Exercicio4.java)
**Objetivo:** Manipulação de arrays multidimensionais e passagem de parâmetros por referência.

* **Cenário:** Subtração de duas matrizes `3x1` com armazenamento do resultado em uma terceira matriz.
* **Conceitos Aplicados:**
    * Lógica de iteração em Arrays Bidimensionais (`double[][]`).
    * **Passagem por Referência:** Compreensão de como objetos (arrays) são manipulados na memória Java ao serem passados como argumentos para métodos `void`.

---

## 📊 Resumo da Análise: Polimorfismo vs. Estruturado

Durante os exercícios 1 e 2, foi realizada uma análise comparativa técnica entre as abordagens.

| Critério | Abordagem Polimórfica (OO) | Abordagem Estruturada (Condicional) |
| :--- | :--- | :--- |
| **Manutenção** | **Alta.** Regras isoladas em classes específicas. | **Baixa.** Alto risco de efeitos colaterais em edições. |
| **Escalabilidade** | **Simples.** Basta criar uma nova classe filha. | **Complexa.** Exige edição de grandes blocos condicionais. |
| **Coesão** | **Alta.** Responsabilidade única por classe. | **Baixa.** Classes centralizadoras ("God Class"). |
