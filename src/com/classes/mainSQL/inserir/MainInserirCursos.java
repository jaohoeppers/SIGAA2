package com.classes.mainSQL.inserir;

import com.classes.BO.CursoBO;
import com.classes.DTO.Curso;

public class MainInserirCursos {
	public static void main(String[] args) {

		// Teste Inserir
		CursoBO cursoBO = new CursoBO();
		Curso curso = new Curso("BCC");
		if (cursoBO.inserir(curso))
			System.out.println("Inserido com Sucesso");
		else
			System.out.println("Erro ao Inserir: " + curso.getNome());

		curso = new Curso("Agronomia");
		if (cursoBO.inserir(curso))
			System.out.println("Inserido com Sucesso");
		else
			System.out.println("Erro ao Inserir: " + curso.getNome());

		curso = new Curso("Fisioterapia");
		if (cursoBO.inserir(curso))
			System.out.println("Inserido com Sucesso");
		else
			System.out.println("Erro ao Inserir: " + curso.getNome());
	}
}