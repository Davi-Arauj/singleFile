package com.davi.ormel.teste.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.davi.ormel.teste.domain.Aluno;
import com.davi.ormel.teste.services.AlunoService;


@RestController
public class IndexResource {

	

	@Autowired
	private AlunoService alunoservice;
	
	@RequestMapping(value = "/")
	public ModelAndView aluno() {
		
		ModelAndView mv = new ModelAndView("index");
		Iterable<Aluno> listaAlunos = alunoservice.listaAlunos();
		mv.addObject("listaAlunos", listaAlunos);
		return mv;
	}
	
} 
