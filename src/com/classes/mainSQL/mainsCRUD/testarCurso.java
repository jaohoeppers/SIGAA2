package com.classes.mainSQL.mainsCRUD;

import com.classes.BO.CursoBO;
import com.classes.DTO.Curso;

import java.util.List;

public class testarCurso {

    public static void main(String[] args) {

        System.out.println("\n===== TESTE CRUD CURSO =====");
        CursoBO cursoBO = new CursoBO();

        // CREATE
        Curso novoCurso = new Curso("Engenharia de Software");
        boolean inserido = cursoBO.inserir(novoCurso);
        System.out.println("Curso inserido: " + inserido);

        // READ
        Curso cursoPorNome = cursoBO.procurarPorNome("Engenharia de Software");
        if (cursoPorNome != null) {
            System.out.println("Curso encontrado: " + cursoPorNome.getNome() + " (ID: " + cursoPorNome.getCodigo() + ")");
        }

        // UPDATE
        if (cursoPorNome != null) {
            boolean atualizado = cursoBO.alterarNome(cursoPorNome, "Engenharia de Software Atualizado");
            System.out.println("Curso atualizado: " + atualizado);

            // Verificar atualização
            Curso cursoAtualizado = cursoBO.procurarPorCodigo(cursoPorNome.getCodigo());
            if (cursoAtualizado != null) {
                System.out.println("Nome atualizado: " + cursoAtualizado.getNome());
            }
        }

        // READ ALL
        List<Curso> todosCursos = cursoBO.pesquisarTodos();
        System.out.println("Total de cursos: " + todosCursos.size());

        // DELETE
        if (cursoPorNome != null) {
            boolean excluido = cursoBO.excluir(cursoPorNome);
            System.out.println("Curso excluído: " + excluido);
        }
    }
}
