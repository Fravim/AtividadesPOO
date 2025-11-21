# Sistema de Pagamento de Professores 🎓

Este projeto acadêmico implementa um sistema de folha de pagamento para uma universidade, com o objetivo principal de realizar um **estudo comparativo** entre duas abordagens de desenvolvimento de software: Orientação a Objetos (Polimorfismo) vs. Programação Estruturada/Procedural.

## 📋 Descrição do Problema

A universidade necessita calcular os salários de três categorias distintas de professores, cada uma com suas próprias regras de negócio:

1.  **Professor Horista:** Remuneração baseada em horas/aula (R$ 85,00/h), com um teto operacional de 160 horas mensais.
2.  **Professor Dedicação Exclusiva (DE):** Remuneração fixa (R$ 8.000,00) somada a um adicional por titulação (R$ 1.500,00 por título).
3.  **Professor Pesquisador:** Remuneração base (R$ 5.000,00) somada a bolsas por projetos de pesquisa ativos (R$ 2.000,00 por projeto).

## 🏗️ Arquitetura da Solução

O projeto foi dividido em duas implementações distintas para fins de análise:

### 1. Abordagem Polimórfica (Recomendada)
Utiliza os pilares da POO (Herança, Polimorfismo e Encapsulamento).
* **Estrutura:** Uma classe abstrata `Professor` define o contrato, e subclasses especializadas (`ProfessorHorista`, `ProfessorDE`, `ProfessorPesquisador`) implementam a lógica específica do método `calcularPagamento()`.
* **Vantagem:** Permite o uso de coleções heterogêneas e facilita a extensão do sistema.

### 2. Abordagem Não-Polimórfica (Anti-Pattern)
Simula um sistema legado ou mal estruturado.
* **Estrutura:** Uma única classe "Deus" (`ProfessorTudoEmUm`) gerencia todos os tipos, utilizando condicionais (`if/else` ou `switch`) e flags para determinar o comportamento.
* **Desvantagem:** Alto acoplamento e baixa coesão.

---

## 📊 Análise Comparativa Técnica

Abaixo, a comparação detalhada entre os impactos de cada abordagem na engenharia do software.

| Critério | Abordagem Polimórfica (OO) | Abordagem Não-Polimórfica (Estruturada) |
| :--- | :--- | :--- |
| **Manutenibilidade** | **Alta.** Regras de negócio estão isoladas. Alterações em uma classe não afetam as outras. | **Baixa.** Alterações exigem edição da classe principal, aumentando o risco de efeitos colaterais. |
| **Extensibilidade** | **Excelente (Open/Closed Principle).** Novos tipos de professores são adicionados criando novas classes, sem tocar no código existente. | **Ruim.** Exige modificação da lógica central e recompilação de toda a classe para adicionar um novo tipo. |
| **Coesão** | **Alta.** Cada classe tem responsabilidade única. | **Baixa.** A classe principal acumula responsabilidades de todos os tipos. |
| **Acoplamento** | **Baixo.** O sistema depende apenas da abstração. | **Alto.** A lógica depende de implementações concretas e atributos específicos misturados. |
| **Memória** | **Eficiente.** Aloca apenas os atributos necessários para o objeto. | **Ineficiente.** Objetos carregam atributos nulos/zerados desnecessários na memória. |

## 🚀 Como Executar o Projeto

Pré-requisitos: Java JDK 8 ou superior.

1.  Clone o repositório.
2.  Compile os arquivos da abordagem desejada:
    ```bash
    javac SistemaPolimorfico.java
    ```
3.  Execute a classe principal:
    ```bash
    java SistemaPolimorfico
    ```

---
**Desenvolvido para a disciplina de Ciência da Computação.**