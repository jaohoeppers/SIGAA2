package com.classes.main.mains;

import com.classes.BO.CursoBO;
import com.classes.BO.DisciplinaBO;
import com.classes.BO.FaseBO;
import com.classes.DTO.Curso;
import com.classes.DTO.Disciplina;
import com.classes.DTO.Fase;

import java.util.List;

public class MainMostrarFasesCurso2 {
	public static void main(String[] args) {

		CursoBO cursoBO = new CursoBO();
		FaseBO faseBO = new FaseBO();
		DisciplinaBO disciplinaBO = new DisciplinaBO();

		Curso curso = cursoBO.procurarPorNome("BCC");
		System.out.println("Nome do Curso:" + curso.getNome());
		List<Fase> fases = faseBO.procurarPorIdCurso(curso.getCodigo());
		for (Fase fase : fases) {
			System.out.println("	Nome da Fase: " + fase.getNome()
					+ " - Codigo da Fase: " + fase.getCodigo());
			List<Disciplina> disciplinas = disciplinaBO.procurarPorIdFase(fase.getCodigo());
			for (Disciplina disciplina : disciplinas) {
				System.out.println("		Nome da Disciplina: " + disciplina.getNome()
						+ " - Codigo da Disciplina: " + disciplina.getCodigo());
			}
			System.out.println();
		}

	}
}