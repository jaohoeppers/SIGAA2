package com.classes.mainSQL.inserir;

import com.classes.BO.AlunoBO;
import com.classes.DTO.Aluno;
import com.classes.DTO.Curso;

public class MainInserirAlunos {
	public static void main(String[] args) {

		Curso curso = new Curso("BCC");
		// Teste Inserir
		AlunoBO alunoBO = new AlunoBO();
		Aluno aluno = new Aluno("João","123456","47997123084","teste@gmail.com", curso);
		if (alunoBO.inserir(aluno))
			System.out.println("Inserido com Sucesso");
		else
			System.out.println("Erro ao Inserir");

//		aluno = new Aluno("Gian","654321","47997965874","testeee@gmail.com", curso);
//		if (alunoBO.inserir(aluno))
//			System.out.println("Inserido com Sucesso");
//		else
//			System.out.println("Erro ao Inserir");
//
//		aluno = new Aluno("Dezin","162534","54998756858","torto@gmail.com", curso);
//		if (alunoBO.inserir(aluno))
//			System.out.println("Inserido com Sucesso");
//		else
//			System.out.println("Erro ao Inserir");
//
//		aluno = new Aluno("Robertin","615243","47987848685","theblackguy@gmail.com", curso);
//		if (alunoBO.inserir(aluno))
//			System.out.println("Inserido com Sucesso");
//		else
//			System.out.println("Erro ao Inserir");
	}
}