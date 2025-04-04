package com.classes.main.mainsCRUD;

import com.classes.BO.CursoBO;
import com.classes.BO.DisciplinaBO;
import com.classes.BO.FaseBO;
import com.classes.DTO.Curso;
import com.classes.DTO.Disciplina;
import com.classes.DTO.Fase;

import java.util.List;

public class testarDisciplina {

    private static void testarDisciplina() {
        System.out.println("\n===== TESTE CRUD DISCIPLINA =====");
        DisciplinaBO disciplinaBO = new DisciplinaBO();
        FaseBO faseBO = new FaseBO();

        List<Fase> fases = faseBO.pesquisarTodos();
        Fase fase = null;
        if (!fases.isEmpty()) {
            fase = fases.getFirst();
        } else {
            CursoBO cursoBO = new CursoBO();
            Curso curso = cursoBO.procurarPorNome("BCC");
            if (curso == null) {
                curso = new Curso("BCC");
                cursoBO.inserir(curso);
                curso = cursoBO.procurarPorNome("BCC");
            }

            fase = new Fase("9",curso);
            fase.setCurso(curso);
            faseBO.inserir(fase);

            List<Fase> novasFases = faseBO.procurarPorNome("9");
            if (!novasFases.isEmpty()) {
                fase = novasFases.getFirst();
            }
        }

        if (fase != null) {
            // CREATE
            Disciplina novaDisciplina = new Disciplina("Prog Alto Desempenho", true, fase);
            novaDisciplina.setFase(fase);
            boolean inserido = disciplinaBO.inserir(novaDisciplina);
            System.out.println("Disciplina inserida: " + inserido);

            // READ
            Disciplina disciplinaPorNome = disciplinaBO.procurarPorNome("Prog Alto Desempenho");
            if (disciplinaPorNome != null) {
                System.out.println("Disciplina encontrada: " + disciplinaPorNome.getNome() + " (ID: " + disciplinaPorNome.getCodigo() + ")");
            }

            // UPDATE
            if (disciplinaPorNome != null) {
                boolean atualizado = disciplinaBO.alterarNome(disciplinaPorNome, "Prog Alto Desempenho Atualizado");
                System.out.println("Disciplina atualizada: " + atualizado);

                // Verificar atualização
                Disciplina disciplinaAtualizada = disciplinaBO.procurarPorCodigo(disciplinaPorNome.getCodigo());
                if (disciplinaAtualizada != null) {
                    System.out.println("Nome atualizado: " + disciplinaAtualizada.getNome());
                }
            }

            // READ ALL
            List<Disciplina> todasDisciplinas = disciplinaBO.pesquisarTodos();
            System.out.println("Total de disciplinas: " + todasDisciplinas.size());

            // DELETE
            if (disciplinaPorNome != null) {
                boolean excluido = disciplinaBO.excluir(disciplinaPorNome);
                System.out.println("Disciplina excluída: " + excluido);
            }
        } else {
            System.out.println("Não foi possível testar Disciplina: Fase não encontrada.");
        }
    }
}
