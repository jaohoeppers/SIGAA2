package com.classes.mainSQL.inserir;

import com.classes.BO.AlunoBO;
import com.classes.BO.DisciplinaAlunoBO;
import com.classes.BO.DisciplinaBO;
import com.classes.DTO.Aluno;
import com.classes.DTO.Disciplina;
import com.classes.DTO.DisciplinaAluno;

public class MainTeste {
	public static void main(String[] args) {

		AlunoBO alunoBO = new AlunoBO();
		Aluno aluno = alunoBO.procurarPorNome("Gian");

		DisciplinaBO disciplinaBO = new DisciplinaBO();
		Disciplina disciplina = disciplinaBO.procurarPorNome("POO2");

		DisciplinaAlunoBO disciplinaAlunoBO = new DisciplinaAlunoBO();
		DisciplinaAluno disciplinaAluno = disciplinaAlunoBO.procurarPorIdDisciplinaIdAluno(disciplina.getCodigo(), aluno.getCodigo());
		disciplinaAlunoBO.alterarStatus(disciplinaAluno, "Reprovado por falta");


	}
}