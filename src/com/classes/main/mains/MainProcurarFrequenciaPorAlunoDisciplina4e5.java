package com.classes.main.mains;

import com.classes.BO.AlunoBO;
import com.classes.BO.AulaAlunoBO;
import com.classes.DTO.Aluno;
import com.classes.DTO.AulaAluno;

import java.util.List;

public class MainProcurarFrequenciaPorAlunoDisciplina4e5 {
	public static void main(String[] args) {

		AlunoBO alunoBO = new AlunoBO();
		AulaAlunoBO aulaAlunoBO = new AulaAlunoBO();

		Aluno aluno = alunoBO.procurarPorNome("Gian");
		List<AulaAluno> aulas = aulaAlunoBO.procurarPorIdAluno(aluno.getCodigo());

		for (AulaAluno aula : aulas) {
			System.out.println("ID Aula: " + aula.getCodigo()
			+ "\n	 Disciplina: " + aula.getAula().getDisciplinaProfessor().getDisciplina().getNome()
			+ "\n	 Professor: " + aula.getAula().getDisciplinaProfessor().getProfessor().getNome()
			+ "\n 	 Presente: " + (aula.getPresente() ? "S" : "N")
			+ "\n 	 Nota avaliação: " + (aula.getNota()!=null ? aula.getNota() : "Avaliação não realizada nesta aula" ));
		}

	}
}