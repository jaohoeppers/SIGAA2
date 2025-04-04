package com.classes.mainSQL.mainsCRUD;

import com.classes.BO.AlunoBO;
import com.classes.BO.AulaAlunoBO;
import com.classes.BO.AulaBO;
import com.classes.BO.DisciplinaBO;
import com.classes.DTO.Aluno;
import com.classes.DTO.Aula;
import com.classes.DTO.AulaAluno;

import java.util.List;

public class testarAulaAluno {

    public static void main(String[] args) {

        System.out.println("\n===== TESTE CRUD AULA ALUNO =====");
        AulaAlunoBO aulaAlunoBO = new AulaAlunoBO();
        AulaBO aulaBO = new AulaBO();
        AlunoBO alunoBO = new AlunoBO();
        DisciplinaBO disciplinaBO = new DisciplinaBO();

        List<Aluno> alunos = alunoBO.pesquisarTodos();
        Aluno aluno = alunos.getFirst();

        List<Aula> aulas = aulaBO.pesquisarTodos();
        Aula aula = aulas.getFirst();

        // CREATE
        AulaAluno novaAulaAluno = new AulaAluno(aula, aluno, true);

        boolean inserido = aulaAlunoBO.inserir(novaAulaAluno);
        System.out.println("AulaAluno inserida: " + inserido);

        // READ
        AulaAluno aulaAlunoPorIds = aulaAlunoBO.procurarPorIdAulaIdAluno(
                aula.getCodigo(), aluno.getCodigo());

        // UPDATE
        boolean atualizado = aulaAlunoBO.alterarPresente(aulaAlunoPorIds, false);
        System.out.println("AulaAluno atualizada: " + atualizado);

        // Verificar atualização
        AulaAluno aulaAlunoAtualizada = aulaAlunoBO.procurarPorIdAulaIdAluno(
                aula.getCodigo(), aluno.getCodigo());
        if (aulaAlunoAtualizada != null) {
            System.out.println("Presença após atualização: " + aulaAlunoAtualizada.getPresente());
        }

        // DELETE
        boolean removido = aulaAlunoBO.excluir(aulaAlunoPorIds);
        System.out.println("AulaAluno removida: " + removido);
    }
}
