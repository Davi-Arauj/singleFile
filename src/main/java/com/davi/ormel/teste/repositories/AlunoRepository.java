package com.davi.ormel.teste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.davi.ormel.teste.domain.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Integer>{
	
	Aluno findById(int id);

}
