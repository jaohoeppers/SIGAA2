package com.classes.main.mains;

import com.classes.BO.AlunoBO;
import com.classes.DTO.Aluno;

public class MainProcurarAluno1 {
	public static void main(String[] args) {

		AlunoBO alunoBO = new AlunoBO();

		Aluno aluno = alunoBO.procurarPorNome("Joao");
		System.out.println("Nome:" + aluno.getNome());
		System.out.println("Matricula:" + aluno.getMatricula());
		System.out.println("Numero de Telefone:" + aluno.getNumeroTelefone());
		System.out.println("Email:" + aluno.getEmail());
		System.out.println("Curso:" + aluno.getCurso().getNome());

	}
}