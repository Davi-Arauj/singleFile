package com.davi.ormel.teste.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.davi.ormel.teste.domain.Aluno;
import com.davi.ormel.teste.services.AlunoService;

@RestController
public class DocumentoResource {

	@Autowired
	private AlunoService service;
	
	/*abrindo a tela dos documentos*/
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ModelAndView documentosAluno( @PathVariable Integer id) {
		ModelAndView mv = new ModelAndView("documentosAluno");	
		Aluno aluno = service.buscaAlunoId(id);
		mv.addObject("aluno",aluno);
		return mv;
	}

}
