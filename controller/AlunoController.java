package com.ProjetoControleAluno.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProjetoControleAluno.entities.Aluno;
import com.ProjetoControleAluno.service.AlunoService;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/aluno")

public class AlunoController {
	private final AlunoService alunoService;
	
	@Autowired
	public AlunoController(AlunoService alunoService) {
		this.alunoService = alunoService;
	}
	@GetMapping("/{id}")
	public ResponseEntity<Aluno> buscaClientesControlId(@PathVariable Long id){
		Aluno aluno = alunoService.getAlunoById(id);
		if (aluno != null) {
			return ResponseEntity.ok(aluno);
		}
		else {
			return ResponseEntity.notFound().build();		
		}

	}
	@GetMapping
	public ResponseEntity<List<Aluno>>buscaTodosAlunoControl(){
		List <Aluno> Aluno = alunoService.getAllAluno();
		return ResponseEntity.ok(Aluno);
	}
	@PostMapping
	public ResponseEntity<Aluno> salvaAlunoControl(@RequestBody @Valid Aluno aluno){
		Aluno salvaAluno = alunoService.salvarAluno(aluno);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaAluno);
	}
		@PutMapping("/{id}")
		public ResponseEntity<Aluno> alteraAlunoControl(@PathVariable Long id, @RequestBody @Valid Aluno aluno){
			Aluno alteraAluno = alunoService.updateAluno(id, aluno);
			if(alteraAluno != null) {
				return ResponseEntity.ok(aluno);
			}
			else {
				return ResponseEntity.notFound().build();
			}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Aluno> apagaAlunoControl(@PathVariable  Long id){
		boolean apagar = alunoService.deleteAluno(id);
		if (apagar) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}
