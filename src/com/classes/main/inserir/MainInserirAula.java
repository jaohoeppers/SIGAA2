package com.classes.main.inserir;

import com.classes.BO.AulaBO;
import com.classes.BO.DisciplinaBO;
import com.classes.BO.DisciplinaProfessorBO;
import com.classes.BO.ProfessorBO;
import com.classes.DTO.Aula;
import com.classes.DTO.DisciplinaProfessor;

import java.time.Instant;
import java.util.Date;
import java.util.List;

public class MainInserirAula {
	public static void main(String[] args) {

		DisciplinaProfessorBO disciplinaProfessorBO = new DisciplinaProfessorBO();
		DisciplinaBO disciplinaBO = new DisciplinaBO();
		ProfessorBO professorBO = new ProfessorBO();
		DisciplinaProfessor disciplinaProfessor = disciplinaProfessorBO.procurarPorIdDisciplinaIdProfessor
				(
						disciplinaBO.procurarPorNome("algoritmos").getCodigo()
						,professorBO.procurarPorNome("fabio").getCodigo()
				);
		final Date data = Date.from(Instant.now());

		AulaBO aulaBO = new AulaBO();
		Aula aula = new Aula(disciplinaProfessor, Date.from(Instant.now()));

		// Teste Inserir
		if (aulaBO.inserir(aula))
			System.out.println("Inserido com Sucesso");
		else
			System.out.println("Erro ao Inserir");
//
//		aula = new Aluno("Gian","654321","47997965874","testeee@gmail.com", curso);
//		if (Aula.inserir(aula))
//			System.out.println("Inserido com Sucesso");
//		else
//			System.out.println("Erro ao Inserir");
//
//		aula = new Aluno("Dezin","162534","54998756858","torto@gmail.com", curso);
//		if (Aula.inserir(aula))
//			System.out.println("Inserido com Sucesso");
//		else
//			System.out.println("Erro ao Inserir");
//
//		aula = new Aluno("Robertin","615243","47987848685","theblackguy@gmail.com", curso);
//		if (Aula.inserir(aula))
//			System.out.println("Inserido com Sucesso");
//		else
//			System.out.println("Erro ao Inserir");
	}
}