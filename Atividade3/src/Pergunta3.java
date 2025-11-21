import java.util.InputMismatchException; // Importante importar a exceção
import java.util.Scanner;

public class Pergunta3 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        try {
            System.out.println("=== Divisão de dois números ===");

            System.out.print("Informe o penúltimo numero do seu celular: ");
            int x = teclado.nextInt(); // Ponto de risco 1: Usuário digitar texto

            System.out.print("Informe o ultimo digito do seu celular: ");
            int y = teclado.nextInt(); // Ponto de risco 2: Usuário digitar texto

            // O código original faz divisão inteira (x / y).
            // Se y for 0, lança ArithmeticException.
            double r = (x / y);

            System.out.println("O resultado da divisão é " + r);

        } catch (InputMismatchException e) {
            // Captura se o usuário digitar letras ou símbolos
            System.out.println("Erro: Você digitou um valor inválido! Por favor, insira apenas números inteiros.");
        } catch (ArithmeticException e) {
            // Captura se o usuário tentar dividir por zero (ex: último dígito ser 0)
            System.out.println("Erro: Não é possível realizar divisão por zero!");
        } catch (Exception e) {
            // Captura qualquer outro erro genérico imprevisto
            System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
        } finally {
            // O bloco finally SEMPRE é executado, garantindo que o Scanner feche
            // mesmo se der erro no meio do caminho.
            System.out.println("Programa finalizado.");
            teclado.close();
        }
    }
}