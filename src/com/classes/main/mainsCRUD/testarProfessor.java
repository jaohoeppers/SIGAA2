package com.classes.main.mainsCRUD;

import com.classes.BO.ProfessorBO;
import com.classes.DTO.Professor;

import java.util.List;

public class testarProfessor {

    private static void testarProfessorCRUD() {
        System.out.println("\n===== TESTE CRUD PROFESSOR =====");
        ProfessorBO professorBO = new ProfessorBO();

        // CREATE
        Professor novoProfessor = new Professor("Wesley");
        boolean inserido = professorBO.inserir(novoProfessor);
        System.out.println("Professor inserido: " + inserido);

        // READ
        Professor professorPorNome = professorBO.procurarPorNome("Wesley");
        if (professorPorNome != null) {
            System.out.println("Professor encontrado: " + professorPorNome.getNome() + " (ID: " + professorPorNome.getCodigo() + ")");
        }

        // UPDATE
        if (professorPorNome != null) {
            boolean atualizado = professorBO.alterarNome(professorPorNome, "Wesley Atualizado");
            System.out.println("Professor atualizado: " + atualizado);

            // Verificar atualização
            Professor professorAtualizado = professorBO.procurarPorCodigo(professorPorNome.getCodigo());
            if (professorAtualizado != null) {
                System.out.println("Nome atualizado: " + professorAtualizado.getNome());
            }
        }

        // READ ALL
        List<Professor> todosProfessores = professorBO.pesquisarTodos();
        System.out.println("Total de professores: " + todosProfessores.size());

        // DELETE
        if (professorPorNome != null) {
            boolean excluido = professorBO.excluir(professorPorNome);
            System.out.println("Professor excluído: " + excluido);
        }
    }
}
