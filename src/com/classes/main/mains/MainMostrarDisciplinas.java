package com.classes.main.mains;

import com.classes.BO.CursoBO;
import com.classes.BO.DisciplinaBO;
import com.classes.BO.FaseBO;
import com.classes.DTO.Curso;
import com.classes.DTO.Disciplina;
import com.classes.DTO.Fase;

import java.util.List;

public class MainMostrarDisciplinas {
	public static void main(String[] args) {

		DisciplinaBO disciplinaBO = new DisciplinaBO();
		List<Disciplina> disciplinas = disciplinaBO.pesquisarTodos();

		 for (Disciplina disciplina : disciplinas) {
			 System.out.println("Nome do Curso: " + disciplina.getNome());
		 }

	}
}