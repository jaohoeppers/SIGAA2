package com.classes.mainSQL.mains;

import com.classes.BO.AlunoBO;
import com.classes.BO.DisciplinaAlunoBO;
import com.classes.DTO.Aluno;
import com.classes.DTO.DisciplinaAluno;

import java.util.List;

public class MainProcurarDisciplinasAluno7e8 {
	public static void main(String[] args) {

		AlunoBO alunoBO = new AlunoBO();

		Aluno aluno = alunoBO.procurarPorNome("Gian");
		DisciplinaAlunoBO disAlunoBO = new DisciplinaAlunoBO();

		List<DisciplinaAluno> disciplinas = disAlunoBO.procurarPorIdAluno(aluno.getCodigo());

		for(DisciplinaAluno disciplina : disciplinas) {
			System.out.println("ID Disciplina: " + disciplina.getDisciplina().getCodigo()
			+ "\n	 Nome: " + disciplina.getDisciplina().getNome()
			+ "\n 	 Fase da disciplina: " + disciplina.getDisciplina().getFase().getNome()
			+ "\n 	 Status do aluno na disciplina: " + disciplina.getStatus());
			System.out.println();
		}

	}
}