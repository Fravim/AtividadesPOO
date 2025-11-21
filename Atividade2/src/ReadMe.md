# Sistema de Comissões de Vendas 💼💰

Este projeto implementa a lógica de comissionamento de uma equipe comercial, comparando a eficiência de uma arquitetura Orientada a Objetos (Polimórfica) contra uma Estruturada (Condicional).

## 📋 Regras de Negócio

A empresa possui três níveis hierárquicos com regras de pagamento distintas:

1.  **Vendedor Júnior:** Ganha puramente por performance (5% sobre vendas).
2.  **Vendedor Sênior:** Ganha porcentagem maior (8%) e possui incentivo por meta (Bônus de R$ 500,00 se vender acima de R$ 10k).
3.  **Gerente Comercial:** Possui segurança financeira (Salário Fixo de R$ 3.000) e ganha sobre o esforço coletivo (2% do total da equipe).

---

## 📊 Análise Comparativa: Polimorfismo vs. Estruturado

Abaixo, a comparação focada nos desafios específicos deste exercício (metas e salários fixos).

| Critério | Abordagem Polimórfica (OO) | Abordagem Não-Polimórfica (Estruturada) |
| :--- | :--- | :--- |
| **Isolamento de Regras** | **Total.** A lógica da "Meta de 10k" existe apenas dentro de `VendedorSenior`. O Gerente nem sabe que essa regra existe. | **Nulo.** A regra da meta está misturada com a regra do salário fixo do gerente dentro de um `if/else`. |
| **Segurança do Código** | **Alta.** Se alterarmos o salário fixo do Gerente, é impossível quebrar o cálculo de comissão do Júnior acidentalmente. | **Baixa.** Ao editar o bloco do Gerente no `if/else`, corre-se o risco de apagar uma chave `{}` e quebrar o código do Sênior. |
| **Representação Real** | **Fiel.** O Gerente tem comportamento diferente dos vendedores (fixo + variavel), e a classe reflete isso. | **Artificial.** Força o Júnior a ter a mesma estrutura do Gerente, mesmo não tendo salário fixo. |
| **Escalabilidade** | **Fácil.** Adicionar um "Diretor" (que ganha sobre lucro líquido) requer apenas uma nova classe. | **Difícil.** Requer adicionar mais um `else-if` na classe principal, aumentando a complexidade ciclomática. |

### Destaque Técnico: O problema da "Regra de Ouro"
Na abordagem não-polimórfica, violamos frequentemente o **SRP (Single Responsibility Principle)**. A classe `VendedorTudoEmUm` tem três razões para mudar:
1. Mudança na comissão do Júnior.
2. Mudança na meta do Sênior.
3. Mudança no fixo do Gerente.

Na abordagem Polimórfica, cada classe tem apenas **uma** razão para mudar.

---

## 🚀 Execução

1. Compile o arquivo principal:
   ```bash
   javac SistemaComissao.java