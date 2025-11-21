# Relatório de Refatoração: Tratamento de Exceções em Java 🛡️

**Atividade:** Exercício 3 (Opcional)
**Objetivo:** Identificar falhas em um código de divisão de números e implementar tratamento de erros (Exceptions) para garantir a robustez do programa.

---

## 🚨 Diagnóstico do Problema (Causa Raiz)

O código original operava sob a premissa de um "Caminho Feliz" (*Happy Path*), assumindo que o usuário sempre digitaria dados perfeitamente válidos. Essa abordagem apresentava duas falhas críticas que causavam o encerramento abrupto (*crash*) do sistema:

1.  **Falha de Tipo de Dados (`InputMismatchException`):**
    * **Causa:** O método de leitura esperava estritamente um número inteiro.
    * **O Problema:** Se o usuário digitasse letras, símbolos ou números com casas decimais, a classe `Scanner` não conseguia converter a entrada, gerando uma exceção imediata.

2.  **Falha Aritmética (`ArithmeticException`):**
    * **Causa:** A operação matemática realizada era uma divisão de inteiros.
    * **O Problema:** A matemática não permite divisão por zero. Caso o último dígito do celular do usuário fosse `0`, o processador lançava um erro fatal ao tentar executar a operação.

---

## 🛠️ Alterações Realizadas (Solução)

Para resolver os problemas acima, o código foi refatorado utilizando a estrutura de controle de exceções do Java (`try-catch-finally`). As seguintes mudanças foram implementadas:

### 1. Encapsulamento Lógico (`try`)
Todo o bloco de código sensível (leitura de dados e cálculo) foi envolvido em um bloco `try`. Isso sinaliza ao Java que aquele trecho de código é "perigoso" e pode falhar, permitindo que o erro seja capturado antes de derrubar o programa.

### 2. Tratamento Específico de Erros (`catch`)
Foram adicionados blocos de captura específicos para cada tipo de falha, permitindo feedback personalizado ao usuário:

* **Tratamento de Entrada Inválida:** Captura especificamente erros de digitação (letras em campos numéricos), informando ao usuário que ele deve digitar apenas números.
* **Tratamento de Erro Matemático:** Captura especificamente a tentativa de divisão por zero, explicando que a operação é impossível.
* **Tratamento Genérico:** Adicionada uma captura genérica (`Exception`) como rede de segurança para qualquer outro erro imprevisto.

### 3. Gerenciamento de Recursos (`finally`)
Foi adicionado um bloco `finally` para garantir o fechamento do recurso de entrada (`Scanner`).
* **Por que isso foi mudado?** No código original, se ocorresse um erro na leitura do primeiro número, o programa quebrava e o `Scanner` nunca era fechado, podendo causar vazamento de memória. O bloco `finally` garante que o fechamento ocorra independentemente de sucesso ou falha.

---

## 📊 Resumo Técnico

| Componente Adicionado | Função Técnica |
| :--- | :--- |
| `InputMismatchException` | Previne *crash* quando o tipo de dado entrada difere do esperado (`int`). |
| `ArithmeticException` | Previne *crash* em operações matemáticas ilegais (divisão por zero). |
| `finally` | Garante a execução de código de limpeza (ex: `teclado.close()`) em qualquer cenário. |