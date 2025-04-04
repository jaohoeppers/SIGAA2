package com.classes.mainSQL.mainsCRUD;

import com.classes.BO.AulaBO;
import com.classes.BO.DisciplinaProfessorBO;
import com.classes.DTO.Aula;
import com.classes.DTO.DisciplinaProfessor;

import java.util.Date;
import java.util.List;

public class TestarAula {

    public static void main(String[] args) {

        System.out.println("\n===== TESTE CRUD AULA =====");
        AulaBO aulaBO = new AulaBO();
        DisciplinaProfessorBO disciplinaProfessorBO = new DisciplinaProfessorBO();

        List<DisciplinaProfessor> disciplinas = disciplinaProfessorBO.pesquisarTodos();

        DisciplinaProfessor disciplinaProfessor = disciplinas.getFirst();

        // CREATE
        Aula novaAula = new Aula(disciplinaProfessor, new Date());

        boolean inserido = aulaBO.inserir(novaAula);
        System.out.println("Aula inserida: " + inserido);

        // READ
        Aula aulaPorId = aulaBO.procurarPorIdDisciplinaProfessorANDData(novaAula.getDisciplinaProfessor().getCodigo(),novaAula.getData()).getFirst();

        // UPDATE
        boolean atualizado = aulaBO.alterarData(aulaPorId, new Date());
        System.out.println("Aula atualizada: " + atualizado);

        // Verificar atualização
        Aula aulaAtualizada = aulaBO.procurarPorIdDisciplinaProfessorANDData(novaAula.getDisciplinaProfessor().getCodigo(),novaAula.getData()).getFirst();
        if (aulaAtualizada != null) {
            System.out.println("Conteúdo após atualização: " + aulaAtualizada.getData());
        }

        // DELETE
        boolean removido = aulaBO.excluir(aulaPorId);
        System.out.println("Aula removida: " + removido);
    }

}
