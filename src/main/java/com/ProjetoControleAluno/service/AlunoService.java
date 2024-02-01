package com.ProjetoControleAluno.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProjetoControleAluno.entities.Aluno;
import com.ProjetoControleAluno.repository.AlunoRepository;

@Service
public class AlunoService {
	private final AlunoRepository alunoRepository;
	@Autowired
	public AlunoService (AlunoRepository AlunoRepository) {
		this.alunoRepository = AlunoRepository;
	}
	public List<Aluno> getAllAluno (){
		return alunoRepository.findAll();
	}
	public Aluno getAlunoById(Long idAluno) {
		Optional<Aluno> Aluno = alunoRepository.findById(idAluno);
		return Aluno.orElse(null);
	}
	public Aluno salvarAluno(Aluno aluno) {
		return alunoRepository.save(aluno);
	}
	public Aluno updateAluno(Long id, Aluno updatedAluno) {
		Optional<Aluno> existingAluno = alunoRepository.findById(id);
		if (existingAluno.isPresent()) {
			updatedAluno.setIdAluno(id);
			return alunoRepository.save(updatedAluno);
		}
		return null;
	}
	public boolean deleteAluno(Long idAluno) {
		Optional<Aluno> existingAluno = alunoRepository.findById(idAluno);
		if (existingAluno.isPresent()) {
			alunoRepository.deleteById(idAluno);
			return true;
		}
		return false;
	}
}
