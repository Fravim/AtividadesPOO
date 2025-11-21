public class Exercicio4 {

    public static void main(String[] args) {
        // 1. Criando as matrizes 3x1 (3 linhas, 1 coluna)
        double[][] matrizA = {
                {10.0},
                {20.0},
                {30.0}
        };

        double[][] matrizB = {
                {2.0},
                {5.0},
                {10.0}
        };

        // Matriz C vazia para guardar o resultado
        double[][] matrizC = new double[3][1];

        System.out.println("--- Calculando: Matriz A - Matriz B ---");

        // 2. Chamando o método solicitado
        subtrairMatrizes(matrizA, matrizB, matrizC);

        // 3. Exibindo o resultado para provar que funcionou
        imprimirMatriz(matrizC);
    }

    /**
     * Método solicitado pelo exercício.
     * Recebe 3 matrizes 3x1, subtrai as duas primeiras e guarda na terceira.
     */
    public static void subtrairMatrizes(double[][] m1, double[][] m2, double[][] resultado) {
        // Percorre as 3 linhas
        for (int linha = 0; linha < 3; linha++) {
            // Percorre a única coluna (índice 0)
            // Como é 3x1, a coluna é sempre 0, mas o loop deixa o código mais genérico
            for (int coluna = 0; coluna < 1; coluna++) {
                resultado[linha][coluna] = m1[linha][coluna] - m2[linha][coluna];
            }
        }
    }

    // Método auxiliar apenas para mostrar o resultado no console
    public static void imprimirMatriz(double[][] m) {
        for (int i = 0; i < m.length; i++) {
            System.out.println("[" + m[i][0] + "]");
        }
    }
}