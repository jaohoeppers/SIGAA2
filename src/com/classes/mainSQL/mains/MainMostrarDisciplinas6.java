package com.classes.mainSQL.mains;

import com.classes.BO.DisciplinaBO;
import com.classes.DTO.Disciplina;

import java.util.List;

public class MainMostrarDisciplinas6 {
	public static void main(String[] args) {

		DisciplinaBO disciplinaBO = new DisciplinaBO();
		List<Disciplina> disciplinas = disciplinaBO.pesquisarTodos();

		 for (Disciplina disciplina : disciplinas) {
			 System.out.println("Nome da Disciplina: " + disciplina.getNome()
			 + "\n  Codigo da Disciplina: " + disciplina.getCodigo()
			 + "\n  Disciplina ativa?: " + disciplina.getAtiva()
			 + "\n  Fase da Disciplina: " + disciplina.getFase().getNome());
			 System.out.println();
		 }

	}
}