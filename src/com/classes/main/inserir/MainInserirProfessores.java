package com.classes.main.inserir;

import com.classes.BO.CursoBO;
import com.classes.BO.ProfessorBO;
import com.classes.DTO.Professor;

public class MainInserirProfessores {
	public static void main(String[] args) {

		// Teste Inserir
		ProfessorBO professorBO = new ProfessorBO();

		Professor professor = new Professor("Fabio");
		if (professorBO.inserir(professor))
			System.out.println("Inserido com Sucesso");
		else
			System.out.println("Erro ao Inserir: " + professor.getNome());

//		professor = new Professor("Curvello");
//		if (professorBO.inserir(professor))
//			System.out.println("Inserido com Sucesso");
//		else
//			System.out.println("Erro ao Inserir: " + professor.getNome());
//
//		professor = new Professor("Andre");
//		if (professorBO.inserir(professor))
//			System.out.println("Inserido com Sucesso");
//		else
//			System.out.println("Erro ao Inserir: " + professor.getNome());
//
//		professor = new Professor("Daniel");
//		if (professorBO.inserir(professor))
//			System.out.println("Inserido com Sucesso");
//		else
//			System.out.println("Erro ao Inserir: " + professor.getNome());
	}
}