package com.davi.ormel.teste.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.davi.ormel.teste.domain.Aluno;
import com.davi.ormel.teste.services.AlunoService;

@RestController
public class AlunoResource {

	@Autowired
	private AlunoService alunoservice;

	@RequestMapping(value = "/alunos")
	public ModelAndView aluno() {
		ModelAndView mv = new ModelAndView("aluno");
		Iterable<Aluno> listaAlunos = alunoservice.listaAlunos();
		mv.addObject("listaAlunos", listaAlunos);
		return mv;
	}

	// criando um Aluno
	@PostMapping(value = "/addAlunos")
	@ResponseBody
	public ResponseEntity<Aluno> insert(@RequestBody Aluno obj) {
		obj = alunoservice.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		if (uri != null) {
			atulizaLista();
		}
		return ResponseEntity.created(uri).build();

	}

	public ModelAndView atulizaLista() {

		ModelAndView mv = new ModelAndView("aluno");
		Iterable<Aluno> listaAlunos = alunoservice.listaAlunos();
		mv.addObject("listaAlunos", listaAlunos);
		return mv;
	}

}
