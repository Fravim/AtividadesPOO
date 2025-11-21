import java.util.ArrayList;
import java.util.List;

class VendedorTudoEmUm {
    private String nome;
    private String tipo; // "JUNIOR", "SENIOR", "GERENTE"
    private double valorVendas;

    // O construtor e a classe precisam lidar com a lógica de todos
    public VendedorTudoEmUm(String nome, String tipo, double valorVendas) {
        this.nome = nome;
        this.tipo = tipo;
        this.valorVendas = valorVendas;
    }

    public double calcularComissao() {
        double comissao = 0.0;

        // Lógica condicional frágil (Switch ou If/Else)
        if (tipo.equals("JUNIOR")) {
            comissao = valorVendas * 0.05;
        }
        else if (tipo.equals("SENIOR")) {
            comissao = valorVendas * 0.08;
            if (valorVendas > 10000.00) {
                comissao += 500.00; // Regra espalhada no meio do código
            }
        }
        else if (tipo.equals("GERENTE")) {
            // Regra do gerente misturada com a dos vendedores
            comissao = 3000.00 + (valorVendas * 0.02);
        }

        return comissao;
    }

    public String getNome() { return nome; }
    public double getValorVendas() { return valorVendas; }
}

public class SistemaRuim {
    public static void main(String[] args) {
        List<VendedorTudoEmUm> lista = new ArrayList<>();

        // 1. Junior
        lista.add(new VendedorTudoEmUm("Lucas (Jr)", "JUNIOR", 5000.00));

        // 2. Senior que Bateu Meta (12k)
        // Note que aqui passamos os mesmos parametros, mas o "if" lá dentro vai ter que se virar
        lista.add(new VendedorTudoEmUm("Fernanda (Sr)", "SENIOR", 12000.00));

        // 3. Senior que NÃO Bateu Meta (8k)
        lista.add(new VendedorTudoEmUm("Pedro (Sr)", "SENIOR", 8000.00));

        // 4. Gerente
        lista.add(new VendedorTudoEmUm("Marcos (Gerente)", "GERENTE", 100000.00));

        System.out.println("=== RELATÓRIO (NÃO-POLIMÓRFICO - COMPLETO) ===");
        for (VendedorTudoEmUm v : lista) {
            System.out.printf("%-20s | R$ %.2f%n", v.getNome(), v.calcularComissao());
        }
    }
}