package com.classes.mainSQL.mainsCRUD;

import com.classes.BO.*;
import com.classes.DTO.*;

import java.util.List;

public class testarDisciplinaAluno {

    public static void main(String[] args) {

        System.out.println("\n===== TESTE CRUD DISCIPLINA ALUNO =====");
        DisciplinaAlunoBO disciplinaAlunoBO = new DisciplinaAlunoBO();
        AlunoBO alunoBO = new AlunoBO();
        DisciplinaBO disciplinaBO = new DisciplinaBO();

        List<Aluno> alunos = alunoBO.pesquisarTodos();
        List<Disciplina> disciplinas = disciplinaBO.pesquisarTodos();

        Aluno aluno = null;
        aluno = alunos.getFirst();

        Disciplina disciplina = null;
        disciplina = disciplinas.getFirst();


        // CREATE
        DisciplinaAluno novaDisciplinaAluno = new DisciplinaAluno("Ativa", aluno, disciplina);
        boolean inserido = disciplinaAlunoBO.inserir(novaDisciplinaAluno);
        System.out.println("DisciplinaAluno inserida: " + inserido);

        // READ
        DisciplinaAluno disciplinaAlunoPorIds = disciplinaAlunoBO.procurarPorIdDisciplinaIdAluno(
                disciplina.getCodigo(), aluno.getCodigo());

        if (disciplinaAlunoPorIds != null) {
            System.out.println("DisciplinaAluno encontrada: Aluno=" + disciplinaAlunoPorIds.getAluno().getNome() +
                    ", Disciplina=" + disciplinaAlunoPorIds.getDisciplina().getNome() +
                    ", Status=" + disciplinaAlunoPorIds.getStatus());
        }

        // UPDATE
        if (disciplinaAlunoPorIds != null) {
            boolean atualizado = disciplinaAlunoBO.alterarStatus(disciplinaAlunoPorIds, "Aprovado");
            System.out.println("DisciplinaAluno atualizada: " + atualizado);

            // Verificar atualização
            DisciplinaAluno disciplinaAlunoAtualizada = disciplinaAlunoBO.procurarPorCodigo(disciplinaAlunoPorIds.getCodigo());
            if (disciplinaAlunoAtualizada != null) {
                System.out.println("Status atualizado: " + disciplinaAlunoAtualizada.getStatus());
            }
        }

        // READ ALL
        List<DisciplinaAluno> todasDisciplinasAlunos = disciplinaAlunoBO.pesquisarTodos();
        System.out.println("Total de DisciplinasAlunos: " + todasDisciplinasAlunos.size());

        // DELETE
        if (disciplinaAlunoPorIds != null) {
            boolean excluido = disciplinaAlunoBO.excluir(disciplinaAlunoPorIds);
            System.out.println("DisciplinaAluno excluída: " + excluido);
        }
    }
}
