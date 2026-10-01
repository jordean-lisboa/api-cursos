package br.edu.ifpi.api_cursos;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CursoController {

    @GetMapping("/cursos")
    public List<Curso> listarCursos() {
        return List.of(
                new Curso(1L, "Análise e Desenvolvimento de Sistemas", "Superior"),
                new Curso(2L, "Sistemas de Informação", "Superior"),
                new Curso(3L, "Informática", "Técnico")
        );
    }

    @GetMapping("/cursos/{id}")
    public Curso buscarCurso(@PathVariable Long id) {
        return listarCursos().stream()
                .filter(curso -> curso.id().equals(id))
                .findFirst()
                .orElse(null);
    }

    @GetMapping("/cursos/{id}/descricao")
    public String descricaoCurso(@PathVariable Long id) {
        return listarCursos().stream()
                .filter(curso -> curso.id().equals(id))
                .map(curso -> "Curso " + curso.id() + " - " + curso.nome())
                .findFirst()
                .orElse("Curso não encontrado");
    }
}
