package com.classes.mainSQL.inserir;

import com.classes.BO.FaseBO;
import com.classes.BO.CursoBO;
import com.classes.DTO.Fase;

public class MainInserirFases {
	public static void main(String[] args) {

		// Teste Inserir
		FaseBO faseBO = new FaseBO();
		CursoBO cursoBO = new CursoBO();

		Fase fase = new Fase("1", cursoBO.procurarPorNome("BCC"));
		if (faseBO.inserir(fase))
			System.out.println("Inserido com Sucesso");
		else
			System.out.println("Erro ao Inserir: " + fase.getNome());

		fase = new Fase("2", cursoBO.procurarPorNome("BCC"));
		if (faseBO.inserir(fase))
			System.out.println("Inserido com Sucesso");
		else
			System.out.println("Erro ao Inserir: " + fase.getNome());

		fase = new Fase("3", cursoBO.procurarPorNome("BCC"));
		if (faseBO.inserir(fase))
			System.out.println("Inserido com Sucesso");
		else
			System.out.println("Erro ao Inserir: " + fase.getNome());

		fase = new Fase("4", cursoBO.procurarPorNome("BCC"));
		if (faseBO.inserir(fase))
			System.out.println("Inserido com Sucesso");
		else
			System.out.println("Erro ao Inserir: " + fase.getNome());
	}
}