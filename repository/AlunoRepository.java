package com.ProjetoControleAluno.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProjetoControleAluno.entities.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long >{

}
