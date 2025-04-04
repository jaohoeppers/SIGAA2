package com.classes.main.mainsCRUD;

import com.classes.BO.AlunoBO;
import com.classes.BO.CursoBO;
import com.classes.DTO.Aluno;

import java.util.List;

public class testarAluno {

    private static void testarAluno() {
        System.out.println("\n===== TESTE CRUD ALUNO =====");
        AlunoBO alunoBO = new AlunoBO();
        CursoBO cursoBO = new CursoBO();

        // CREATE
        Aluno novoAluno = new Aluno("Zeca Silva", "78948", "4444", "ee@ee", cursoBO.procurarPorNome("BCC"));
        boolean inserido = alunoBO.inserir(novoAluno);
        System.out.println("Aluno inserido: " + inserido);

        // READ
        Aluno alunoPorNome = alunoBO.procurarPorNome("Zeca Silva");
        if (alunoPorNome != null) {
            System.out.println("Aluno encontrado: " + alunoPorNome.getNome() + " (ID: " + alunoPorNome.getCodigo() + ")");
        }

        // UPDATE
        if (alunoPorNome != null) {
            boolean atualizado = alunoBO.alterarNome(alunoPorNome, "Zeca Silva Atualizado");
            System.out.println("Aluno atualizado: " + atualizado);

            // Verificar atualização
            Aluno alunoAtualizado = alunoBO.procurarPorCodigo(alunoPorNome.getCodigo());
            if (alunoAtualizado != null) {
                System.out.println("Nome atualizado: " + alunoAtualizado.getNome());
            }
        }

        // READ ALL
        List<Aluno> todosAlunos = alunoBO.pesquisarTodos();
        System.out.println("Total de alunos: " + todosAlunos.size());

        // DELETE
        if (alunoPorNome != null) {
            boolean excluido = alunoBO.excluir(alunoPorNome);
            System.out.println("Aluno excluído: " + excluido);
        }
    }
}
