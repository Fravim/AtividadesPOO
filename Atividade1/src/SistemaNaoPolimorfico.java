import java.util.ArrayList;
import java.util.List;

class ProfessorTudoEmUm {
	private String nome;
	private String tipo; // "HORISTA", "DE", "PESQUISADOR"

	// ATRIBUTOS MISTURADOS (Isso C) ruim: desperdC-cio de memC3ria e confusC#o)
	private int horasTrabalhadas;  // SC3 serve para Horista
	private int numeroTitulacoes;  // SC3 serve para DE
	private int projetosAtivos;    // SC3 serve para Pesquisador

	// Construtor MonolC-tico (Gigante)
	public ProfessorTudoEmUm(String nome, String tipo, int horas, int titulacoes, int projetos) {
		this.nome = nome;
		this.tipo = tipo;
		this.horasTrabalhadas = horas;
		this.numeroTitulacoes = titulacoes;
		this.projetosAtivos = projetos;
	}

	public String getNome() {
		return nome;
	}

	// O PROBLEMA ESTC AQUI:
	public double calcularPagamento() {
		double salario = 0.0;

		// Uso excessivo de condicionais (Switch ou If/Else)
		// Se precisar criar um novo tipo de professor, vocC* C) OBRIGADO a editar esse mC)todo.
		switch (this.tipo) {
		case "HORISTA":
			int horas = Math.min(this.horasTrabalhadas, 160);
			salario = horas * 85.00;
			break;
		case "DE":
			salario = 8000.00 + (this.numeroTitulacoes * 1500.00);
			break;
		case "PESQUISADOR":
			salario = 5000.00 + (this.projetosAtivos * 2000.00);
			break;
		default:
			System.out.println("Erro: Tipo desconhecido");
		}
		return salario;
	}
}

public class SistemaNaoPolimorfico {
	public static void main(String[] args) {
		List<ProfessorTudoEmUm> folha = new ArrayList<>();

		// InstanciaC'C#o confusa: temos que passar 0 para os campos que nC#o usamos
		folha.add(new ProfessorTudoEmUm("Carlos (Horista)", "HORISTA", 170, 0, 0));
		folha.add(new ProfessorTudoEmUm("Amanda (D.E.)", "DE", 0, 2, 0));
		folha.add(new ProfessorTudoEmUm("Roberto (Pesq.)", "PESQUISADOR", 0, 0, 3));

		System.out.println("=== FOLHA DE PAGAMENTO (NCO-POLIMCRFICA) ===");

		for (ProfessorTudoEmUm p : folha) {
			System.out.printf("Professor: %-20s | SalC!rio: R$ %.2f%n", p.getNome(), p.calcularPagamento());
		}
	}
}