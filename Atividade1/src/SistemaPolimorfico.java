import java.util.ArrayList;
import java.util.List;

// 1. CLASSE ABSTRATA (O CONTRATO)
abstract class Professor {
    protected String nome;

    public Professor(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    // Método abstrato: obriga as subclasses a terem sua própria lógica
    public abstract double calcularPagamento();
}

// 2. CLASSES CONCRETAS (ESPECIALIZAÇÕES)

class ProfessorHorista extends Professor {
    private int horasTrabalhadas;
    private static final double VALOR_HORA = 85.00;
    private static final int LIMITE_HORAS = 160;

    public ProfessorHorista(String nome, int horasTrabalhadas) {
        super(nome);
        this.horasTrabalhadas = horasTrabalhadas;
    }

    @Override
    public double calcularPagamento() {
        // Encapsulamento da regra de negócio específica do horista
        int horasEfetivas = Math.min(horasTrabalhadas, LIMITE_HORAS);
        return horasEfetivas * VALOR_HORA;
    }
}

class ProfessorDedicacaoExclusiva extends Professor {
    private int numeroTitulacoes; // 1 para Mestre, 2 para Doutor, etc.
    private static final double SALARIO_FIXO = 8000.00;
    private static final double BONUS_TITULACAO = 1500.00;

    public ProfessorDedicacaoExclusiva(String nome, int numeroTitulacoes) {
        super(nome);
        this.numeroTitulacoes = numeroTitulacoes;
    }

    @Override
    public double calcularPagamento() {
        return SALARIO_FIXO + (numeroTitulacoes * BONUS_TITULACAO);
    }
}

class ProfessorPesquisador extends Professor {
    private int projetosAtivos;
    private static final double SALARIO_BASE = 5000.00;
    private static final double BOLSA_PROJETO = 2000.00;

    public ProfessorPesquisador(String nome, int projetosAtivos) {
        super(nome);
        this.projetosAtivos = projetosAtivos;
    }

    @Override
    public double calcularPagamento() {
        return SALARIO_BASE + (projetosAtivos * BOLSA_PROJETO);
    }
}

// 3. EXECUÇÃO
public class SistemaPolimorfico {
    public static void main(String[] args) {
        // Lista Heterogênea: Uma lista de "Professor" que aceita qualquer filho
        List<Professor> folhaPagamento = new ArrayList<>();

        folhaPagamento.add(new ProfessorHorista("Carlos (Horista)", 170)); // Vai testar o teto de 160h
        folhaPagamento.add(new ProfessorDedicacaoExclusiva("Amanda (D.E.)", 2));
        folhaPagamento.add(new ProfessorPesquisador("Roberto (Pesq.)", 3));

        System.out.println("=== FOLHA DE PAGAMENTO (POLIMÓRFICA) ===");
        
        for (Professor p : folhaPagamento) {
            // POLIMORFISMO ACONTECENDO AQUI:
            // O Java decide em tempo de execução qual método "calcularPagamento" chamar
            System.out.printf("Professor: %-20s | Salário: R$ %.2f%n", p.getNome(), p.calcularPagamento());
        }
    }
}