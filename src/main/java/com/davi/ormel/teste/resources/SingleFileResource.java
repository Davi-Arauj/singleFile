package com.davi.ormel.teste.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.davi.ormel.teste.domain.Aluno;
import com.davi.ormel.teste.domain.SingleFile;
import com.davi.ormel.teste.dto.SingleFileDTO;
import com.davi.ormel.teste.repositories.SingleFileRepository;
import com.davi.ormel.teste.services.SingleFileService;

@RestController
@RequestMapping(value = "/singlefile")
public class SingleFileResource {

	@Autowired
	private SingleFileService service;
	@Autowired
	private SingleFileRepository repo;

	// retorna uma singlefile pelo Nome
	@GetMapping(value="/search-name")
	public ResponseEntity<Page<SingleFile>> searchByName(
			@RequestParam(defaultValue="") String fileName,
			Pageable pageable){
		Page<SingleFile> result = repo.findByFileNameContainingIgnoreCase(fileName,pageable);
		return ResponseEntity.ok(result);
	}

	// cria uma singlefile
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody SingleFile obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	// atualiza uma singlefile
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody SingleFile obj, @PathVariable Integer id) {
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}

	// deleta uma singlefile
	/*@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<SingleFile> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}*/
	
	//deleta um singlefile por o nome
	@RequestMapping(value = "/{fileName}", method = RequestMethod.DELETE)
	public ResponseEntity<SingleFile> deleteByFileName(@RequestParam(defaultValue = "") String fileName) {
		service.deleteByFileName(fileName);
		return ResponseEntity.noContent().build();
	}

	// retorna uma lista de singlefiles
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<SingleFileDTO>> findAll() {
		List<SingleFile> list = service.findALL();
		List<SingleFileDTO> listDTO = list.stream().map(obj -> new SingleFileDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	// retorna os singlesfiles atraves de uma paginação
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<SingleFileDTO>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "fileName") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		Page<SingleFile> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<SingleFileDTO> listDTO = list.map(obj -> new SingleFileDTO(obj));
		return ResponseEntity.ok().body(listDTO);
	}

}
