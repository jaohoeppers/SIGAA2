package com.classes.mainSQL.inserir;

import com.classes.BO.CursoBO;
import com.classes.BO.DisciplinaBO;
import com.classes.BO.FaseBO;
import com.classes.DTO.Curso;
import com.classes.DTO.Disciplina;
import com.classes.DTO.Fase;

public class MainInserirDisciplinas {
	public static void main(String[] args) {

		// Teste Inserir
		DisciplinaBO disciplinaBO = new DisciplinaBO();
		CursoBO cursoBO = new CursoBO();
		FaseBO faseBO = new FaseBO();
		Curso curso = cursoBO.procurarPorNome("BCC");

		Disciplina disciplina = new Disciplina("TCC"
				, true
				, (Fase) faseBO.procurarPorNome("3").stream()
					.filter(fase -> fase.getNome().equals(curso.getNome())
					)
		);
		if (disciplinaBO.inserir(disciplina))
			System.out.println("Inserido com Sucesso");
		else
			System.out.println("Erro ao Inserir: " + disciplina.getNome());

		disciplina = new Disciplina("POO1"
				, true
				, (Fase) faseBO.procurarPorNome("1").stream()
				.filter(fase -> fase.getNome().equals(curso.getNome())
				)
		);
		if (disciplinaBO.inserir(disciplina))
			System.out.println("Inserido com Sucesso");
		else
			System.out.println("Erro ao Inserir: " + disciplina.getNome());

		disciplina = new Disciplina("POO2"
				, true
				, (Fase) faseBO.procurarPorNome("2").stream()
				.filter(fase -> fase.getNome().equals(curso.getNome())
				)
		);
		if (disciplinaBO.inserir(disciplina))
			System.out.println("Inserido com Sucesso");
		else
			System.out.println("Erro ao Inserir: " + disciplina.getNome());

		disciplina = new Disciplina("Banco de Dados1"
				, true
				, (Fase) faseBO.procurarPorNome("2").stream()
				.filter(fase -> fase.getNome().equals(curso.getNome())
				)
		);
		if (disciplinaBO.inserir(disciplina))
			System.out.println("Inserido com Sucesso");
		else
			System.out.println("Erro ao Inserir: " + disciplina.getNome());
	}
}