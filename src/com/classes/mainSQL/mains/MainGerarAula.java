package com.classes.mainSQL.mains;

import com.classes.BO.*;
import com.classes.DTO.*;
import com.classes.XML.Professor;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MainGerarAula {
	public static void main(String[] args) {

		DisciplinaProfessorBO disciplinaProfessorBO = new DisciplinaProfessorBO();
		DisciplinaBO disciplinaBO = new DisciplinaBO();
		ProfessorBO professorBO = new ProfessorBO();
		AlunoBO alunoBO = new AlunoBO();
		AulaBO aulaBO = new AulaBO();
		AulaAlunoBO aulaAlunoBO = new AulaAlunoBO();
		DisciplinaAlunoBO disAlunoBO = new DisciplinaAlunoBO();
		Scanner scanner = new Scanner(System.in);

		System.out.println("Deseja criar uma aula? (S/N)");
		String resposta = scanner.nextLine();

		if (resposta.equalsIgnoreCase("S")) {
			// Buscar todas as disciplinas
			List<Disciplina> disciplinas = disciplinaBO.pesquisarTodos();

			// Mostra todas as disciplinas
			System.out.println("Disciplinas disponíveis:");
			for (int i = 0; i < disciplinas.size(); i++) {
				System.out.println("Nome: " + disciplinas.get(i).getNome() + " Codigo: " + disciplinas.get(i).getCodigo());
			}

			System.out.println("Qual a disciplina da aula? (Digite o número)");
			int dis = scanner.nextInt();
			scanner.nextLine();

			Disciplina disciplinaSelecionada = disciplinaBO.procurarPorCodigo(dis);

			// Buscar professores disponíveis para a disciplina escolhida
			List<DisciplinaProfessor> disPro = disciplinaProfessorBO.procurarPorIdDisciplina(disciplinaSelecionada.getCodigo());
			List<com.classes.XML.Professor> professores = disPro.stream()
					.map(DisciplinaProfessor::getProfessor)
					.toList();

			// Mostrar professores disponíveis para a disciplina escolhida
			System.out.println("Professores disponíveis para a disciplina:");
			for (int i = 0; i < professores.size(); i++) {
				System.out.println("Nome: " + professores.get(i).getNome() + " Codigo: " + professores.get(i).getCodigo());
			}

			System.out.println("Qual o professor da aula? (Digite o número)");
			int pro = scanner.nextInt();
			scanner.nextLine();

			Professor professorSelecionado = professorBO.procurarPorCodigo(pro);

			// Busca codigo da Disciplina_professor
			DisciplinaProfessor disciplinaProfessor = disciplinaProfessorBO.procurarPorIdDisciplinaIdProfessor(
					disciplinaSelecionada.getCodigo(),
					professorSelecionado.getCodigo()
			);

			// Criar a aula
			Aula aula = new Aula(disciplinaProfessor, Date.from(Instant.now()));

			boolean inserido = aulaBO.inserir(aula);
			Aula aulaAtual = aulaBO.procurarPorIdDisciplinaProfessorANDData(aula.getDisciplinaProfessor().getCodigo(), aula.getData()).getLast();

			if (inserido) {
				System.out.println("Aula criada");

				// Registrar presença dos alunos
				List<DisciplinaAluno> alunosDisciplina = disAlunoBO.procurarPorIdDisciplina(disciplinaSelecionada.getCodigo());
//				List<Aluno> alunosDisciplina = alunos.stream()
//						.map(aluno -> disAlunoBO.procurarPorIdAluno(aluno.getCodigo()))
//						.filter(disAluno -> {
//							DisciplinaAluno[] disciplinasAluno = disAluno;
//							if (disciplinasAluno != null) {
//								for (DisciplinaAluno disA : disciplinasAluno) {
//									if (disA != null && disA.getDisciplina().getCodigo() == disciplinaSelecionada.getCodigo()) {
//										return true;
//									}
//								}
//							}
//							return false;
//						})
//						.toList();

				if (alunosDisciplina != null && !alunosDisciplina.isEmpty()) {
					System.out.println("Registrando presença dos alunos:");

					for (DisciplinaAluno disAluno : alunosDisciplina) {
						Aluno aluno = alunoBO.procurarPorCodigo(disAluno.getAluno().getCodigo());
						System.out.println("Aluno: " + aluno.getNome() + " Matrícula: " + aluno.getMatricula());
						System.out.println("Está presente? (S/N)");
						String presenca = scanner.nextLine();

						// Cria registro de aula para determinado aluno
						AulaAluno registroAula = new AulaAluno(aulaAtual, aluno, presenca.equalsIgnoreCase("S"));

						if (aulaAlunoBO.inserir(registroAula)) {
							System.out.println("Aula registrada com sucesso!");
						} else {
							System.out.println("Erro ao registrar Aula!");
						}
					}

					System.out.println("Todas as presenças foram registradas!");

					System.out.println("Deseja registar uma avaliação? (S/N)");
					resposta = scanner.nextLine();

					if(resposta.equalsIgnoreCase("S")){

						List<AulaAluno> aulasAlunos = aulaAlunoBO.procurarPorIdAula(aulaAtual.getCodigo());
						for (AulaAluno aulaAluno : aulasAlunos) {
							System.out.println("Qual a nota do aluno: " + aulaAluno.getAluno().getNome() + " ?");
							String entrada = scanner.nextLine();
							Double nota = null;
							boolean valorValido = false;

							while (!valorValido) {
								try {
									entrada = entrada.replace(',', '.');
									nota = Double.parseDouble(entrada);
									valorValido = true;
								} catch (NumberFormatException e) {
									System.out.println("Por favor, digite um número válido.");
								}
							}

							if (aulaAlunoBO.inserirAvaliacao(aulaAluno, nota)) {
								System.out.println("Avaliação inserida com Sucesso!");
							}else System.out.println("Erro: Avaliação não inserida");
						}
					}

				} else {
					System.out.println("Não há alunos cadastrados no sistema.");
				}

			} else {
				System.out.println("Erro ao criar aula!");
			}
		} else {
			System.out.println("Registro de aula cancelado");
		}

		scanner.close();
	}
}