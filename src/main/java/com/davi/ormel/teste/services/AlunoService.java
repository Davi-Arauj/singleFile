package com.davi.ormel.teste.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.davi.ormel.teste.domain.Aluno;
import com.davi.ormel.teste.repositories.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunorepo;

		// inserindo um aluno
		public Aluno insert(Aluno obj) {
			obj.setId(null);
			return alunorepo.save(obj);
		}
		
		
		//listando alunos
		public List<Aluno> listaAlunos(){
			List<Aluno> alunos = alunorepo.findAll();
			return alunos;
		}
		
		public Aluno buscaAlunoId(int id) {
			Aluno aluno = alunorepo.findById(id);
			return aluno;
		}
		
}
