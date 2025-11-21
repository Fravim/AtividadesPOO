import java.util.ArrayList;
import java.util.List;

// --- 1. CLASSE ABSTRATA ---
abstract class Vendedor {
    protected String nome;
    protected double totalVendas; // Para o gerente, isso representa o total da equipe

    public Vendedor(String nome, double totalVendas) {
        this.nome = nome;
        this.totalVendas = totalVendas;
    }

    public String getNome() {
        return nome;
    }

    // Método abstrato: cada um calcula de um jeito
    public abstract double calcularComissao();
}

// --- 2. SUBCLASSES (ESPECIALIZAÇÕES) ---

class VendedorJunior extends Vendedor {
    public VendedorJunior(String nome, double totalVendas) {
        super(nome, totalVendas);
    }

    @Override
    public double calcularComissao() {
        // Regra: 5% sobre vendas
        return this.totalVendas * 0.05;
    }
}

class VendedorSenior extends Vendedor {
    private static final double META = 10000.00;
    private static final double BONUS = 500.00;

    public VendedorSenior(String nome, double totalVendas) {
        super(nome, totalVendas);
    }

    @Override
    public double calcularComissao() {
        // Regra: 8% sobre vendas
        double comissao = this.totalVendas * 0.08;

        // Regra: Bônus se bater meta
        if (this.totalVendas > META) {
            comissao += BONUS;
        }
        return comissao;
    }
}

class GerenteComercial extends Vendedor {
    private static final double SALARIO_FIXO = 3000.00;

    public GerenteComercial(String nome, double totalVendasEquipe) {
        super(nome, totalVendasEquipe);
    }

    @Override
    public double calcularComissao() {
        // Regra: Fixo + 2% sobre vendas da equipe
        return SALARIO_FIXO + (this.totalVendas * 0.02);
    }
}

// --- 3. EXECUÇÃO ---
public class SistemaComissao {
    public static void main(String[] args) {
        List<Vendedor> equipe = new ArrayList<>();

        // Junior vendeu 5.000
        equipe.add(new VendedorJunior("Lucas (Jr)", 5000.00));

        // Sênior vendeu 12.000 (Bateu meta)
        equipe.add(new VendedorSenior("Fernanda (Sr)", 12000.00));

        // Sênior vendeu 8.000 (Não bateu meta)
        equipe.add(new VendedorSenior("Pedro (Sr)", 8000.00));

        // Gerente com equipe que vendeu um total de 100.000
        equipe.add(new GerenteComercial("Marcos (Gerente)", 100000.00));

        System.out.println("=== RELATÓRIO DE COMISSÕES (POLIMÓRFICO) ===");

        for (Vendedor v : equipe) {
            System.out.printf("%-20s | Vendas/Base: R$ %9.2f | Comissão: R$ %.2f%n",
                    v.getNome(), v.totalVendas, v.calcularComissao());
        }
    }
}