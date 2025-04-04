package com.classes.mainSQL.mainsCRUD;

import com.classes.BO.DisciplinaBO;
import com.classes.BO.DisciplinaProfessorBO;
import com.classes.BO.ProfessorBO;
import com.classes.DTO.Disciplina;
import com.classes.DTO.DisciplinaProfessor;
import com.classes.XML.Professor;

import java.util.List;

public class testarDisciplinaProfessor {

    public static void main(String[] args) {

        System.out.println("\n===== TESTE CRUD DISCIPLINA PROFESSOR =====");
        DisciplinaProfessorBO disciplinaProfessorBO = new DisciplinaProfessorBO();
        ProfessorBO professorBO = new ProfessorBO();
        DisciplinaBO disciplinaBO = new DisciplinaBO();

        // Obter professor e disciplina para associação
        List<Professor> professores = professorBO.pesquisarTodos();
        List<Disciplina> disciplinas = disciplinaBO.pesquisarTodos();

        Professor professor = professores.getFirst();

        Disciplina disciplina = disciplinas.getFirst();

        // CREATE
        DisciplinaProfessor novaDisciplinaProfessor = new DisciplinaProfessor(professor, disciplina);
        boolean inserido = disciplinaProfessorBO.inserir(novaDisciplinaProfessor);
        System.out.println("DisciplinaProfessor inserida: " + inserido);

        // READ
        DisciplinaProfessor disciplinaProfessorPorIds = disciplinaProfessorBO.procurarPorIdDisciplinaIdProfessor(
                disciplina.getCodigo(), professor.getCodigo());

        if (disciplinaProfessorPorIds != null) {
            System.out.println("DisciplinaProfessor encontrada: Professor=" + disciplinaProfessorPorIds.getProfessor().getNome() +
                    ", Disciplina=" + disciplinaProfessorPorIds.getDisciplina().getNome());

            // Lista todos
            List<DisciplinaProfessor> disciplinasProfessores = disciplinaProfessorBO.pesquisarTodos();
            System.out.println("Total de DisciplinasProfessores: " + disciplinasProfessores.size());

            // DELETE
            boolean removido = disciplinaProfessorBO.excluir(disciplinaProfessorPorIds);
            System.out.println("DisciplinaProfessor removida: " + removido);
        } else {
            System.out.println("DisciplinaProfessor não encontrada após inserção.");
        }
    }

}
