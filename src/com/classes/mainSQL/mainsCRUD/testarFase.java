package com.classes.mainSQL.mainsCRUD;

import com.classes.BO.CursoBO;
import com.classes.BO.FaseBO;
import com.classes.DTO.Curso;
import com.classes.DTO.Fase;

import java.util.List;

public class testarFase {

    public static void main(String[] args) {

        System.out.println("\n===== TESTE CRUD FASE =====");
        FaseBO faseBO = new FaseBO();
        CursoBO cursoBO = new CursoBO();

        Curso curso = cursoBO.procurarPorNome("BCC");
        if (curso == null) {
            curso = new Curso("BCC");
            cursoBO.inserir(curso);
            curso = cursoBO.procurarPorNome("BCC");
        }

        // CREATE
        Fase novaFase = new Fase("1", curso);
        novaFase.setCurso(curso);
        boolean inserido = faseBO.inserir(novaFase);
        System.out.println("Fase inserida: " + inserido);

        // READ
        List<Fase> fasesPorNome = faseBO.procurarPorNome("1");
        Fase fasePorNome = null;
        if (!fasesPorNome.isEmpty()) {
            fasePorNome = fasesPorNome.getFirst();
            System.out.println("Fase encontrada: " + fasePorNome.getNome() + " (ID: " + fasePorNome.getCodigo() + ")");
        }

        // UPDATE
        if (fasePorNome != null) {
            boolean atualizado = faseBO.alterarNome(fasePorNome, "Fase 1 Atualizada");
            System.out.println("Fase atualizada: " + atualizado);

            // Verificar atualização
            Fase faseAtualizada = faseBO.procurarPorCodigo(fasePorNome.getCodigo());
            if (faseAtualizada != null) {
                System.out.println("Nome atualizado: " + faseAtualizada.getNome());
            }
        }

        // READ ALL
        List<Fase> todasFases = faseBO.pesquisarTodos();
        System.out.println("Total de fases: " + todasFases.size());

        // DELETE
        if (fasePorNome != null) {
            boolean excluido = faseBO.excluir(fasePorNome);
            System.out.println("Fase excluída: " + excluido);
        }
    }
}
