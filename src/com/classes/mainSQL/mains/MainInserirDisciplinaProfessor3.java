package com.classes.mainSQL.mains;

import com.classes.BO.DisciplinaBO;
import com.classes.BO.DisciplinaProfessorBO;
import com.classes.BO.ProfessorBO;
import com.classes.DTO.Disciplina;
import com.classes.DTO.DisciplinaProfessor;
import com.classes.XML.Professor;

public class MainInserirDisciplinaProfessor3 {
	public static void main(String[] args) {

		// Teste Inserir
		ProfessorBO professorBO = new ProfessorBO();
		DisciplinaBO disciplinaBO = new DisciplinaBO();
		DisciplinaProfessorBO disciplinaProfessorBO = new DisciplinaProfessorBO();

		Professor professor = professorBO.procurarPorNome("Daniel");
		Disciplina disciplina = disciplinaBO.procurarPorNome("Algoritmos");

		DisciplinaProfessor disciplinaProfessor = new DisciplinaProfessor(professor, disciplina);
		if (disciplinaProfessorBO.inserir(disciplinaProfessor))
			System.out.println("Inserido com Sucesso");
		else
			System.out.println("Erro ao Inserir disciplina professor: "
					+ disciplinaProfessor.getDisciplina().getNome()
					+ ", "
					+ disciplinaProfessor.getProfessor().getNome());

//		professor = professorBO.procurarPorNome("Daniel");
//		disciplina = disciplinaBO.procurarPorNome("Banco de Dados1");
//
//		disciplinaProfessor = new DisciplinaProfessor(professor, disciplina);
//		if (disciplinaProfessorBO.inserir(disciplinaProfessor))
//			System.out.println("Inserido com Sucesso");
//		else
//			System.out.println("Erro ao Inserir disciplina professor: "
//					+ disciplinaProfessor.getDisciplina().getNome()
//					+ ", "
//					+ disciplinaProfessor.getProfessor().getNome());

//		professor = professorBO.procurarPorNome("Fabio");
//		disciplina = disciplinaBO.procurarPorNome("POO2");
//
//		disciplinaProfessor = new DisciplinaProfessor(professor, disciplina);
//		if (disciplinaProfessorBO.inserir(disciplinaProfessor))
//			System.out.println("Inserido com Sucesso");
//		else
//			System.out.println("Erro ao Inserir disciplina professor: "
//					+ disciplinaProfessor.getDisciplina().getNome()
//					+ ", "
//					+ disciplinaProfessor.getProfessor().getNome());
	}
}