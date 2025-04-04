package com.classes.main.inserir;

import com.classes.BO.AlunoBO;
import com.classes.BO.DisciplinaAlunoBO;
import com.classes.BO.DisciplinaBO;
import com.classes.DTO.Aluno;
import com.classes.DTO.Disciplina;
import com.classes.DTO.DisciplinaAluno;

public class MainInserirDiciplinaAluno {
	public static void main(String[] args) {

		AlunoBO alunoBO = new AlunoBO();
		Aluno aluno = alunoBO.procurarPorNome("Dezin");

		DisciplinaBO disciplinaBO = new DisciplinaBO();
		Disciplina disciplina = disciplinaBO.procurarPorNome("Algoritmos");

		DisciplinaAlunoBO disciplinaAlunoBO = new DisciplinaAlunoBO();
		DisciplinaAluno disciplinaAluno = new DisciplinaAluno("Ativo",aluno,disciplina);

		// Teste Inserir
		if (disciplinaAlunoBO.inserir(disciplinaAluno))
			System.out.println("Inserido com Sucesso");
		else
			System.out.println("Erro ao Inserir");

		aluno = alunoBO.procurarPorNome("Dezin");
		disciplina = disciplinaBO.procurarPorNome("POO2");
		disciplinaAluno = new DisciplinaAluno("Ativo",aluno,disciplina);
		if (disciplinaAlunoBO.inserir(disciplinaAluno))
			System.out.println("Inserido com Sucesso");
		else
			System.out.println("Erro ao Inserir");

		aluno = alunoBO.procurarPorNome("Dezin");
		disciplina = disciplinaBO.procurarPorNome("Banco de Dados1");
		disciplinaAluno = new DisciplinaAluno("Ativo",aluno,disciplina);
		if (disciplinaAlunoBO.inserir(disciplinaAluno))
			System.out.println("Inserido com Sucesso");
		else
			System.out.println("Erro ao Inserir");

		aluno = alunoBO.procurarPorNome("Dezin");
		disciplina = disciplinaBO.procurarPorNome("TCC");
		disciplinaAluno = new DisciplinaAluno("Ativo",aluno,disciplina);
		if (disciplinaAlunoBO.inserir(disciplinaAluno))
			System.out.println("Inserido com Sucesso");
		else
			System.out.println("Erro ao Inserir");

		aluno = alunoBO.procurarPorNome("Gian");
		disciplina = disciplinaBO.procurarPorNome("TCC");
		disciplinaAluno = new DisciplinaAluno("Ativo",aluno,disciplina);
		if (disciplinaAlunoBO.inserir(disciplinaAluno))
			System.out.println("Inserido com Sucesso");
		else
			System.out.println("Erro ao Inserir");

		aluno = alunoBO.procurarPorNome("Gian");
		disciplina = disciplinaBO.procurarPorNome("Algoritmos");
		disciplinaAluno = new DisciplinaAluno("Ativo",aluno,disciplina);
		if (disciplinaAlunoBO.inserir(disciplinaAluno))
			System.out.println("Inserido com Sucesso");
		else
			System.out.println("Erro ao Inserir");
	}
}