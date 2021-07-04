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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.davi.ormel.teste.domain.Directory;
import com.davi.ormel.teste.dto.DirectoryDTO;
import com.davi.ormel.teste.repositories.DirectoryRepository;
import com.davi.ormel.teste.services.DirectoryService;

@RestController
@RequestMapping(value = "/directory")
public class DirectoryResource {

	@Autowired
	private DirectoryService service;
	@Autowired
	private DirectoryRepository repo;

	// retorna uma Directory pelo ID
	/*
	 * @RequestMapping(value = "/{id}", method = RequestMethod.GET) public
	 * ResponseEntity<Directory> find(@PathVariable Integer id) { Directory obj =
	 * service.find(id); return ResponseEntity.ok().body(obj);
	 * 
	 * }
	 */

	// retorna uma Directory pelo Nome
	@GetMapping(value = "/search-name")
	public ResponseEntity<Page<Directory>> searchByName(@RequestParam(defaultValue = "") String directoryName,
			Pageable pageable) {
		Page<Directory> result = repo.findByDirectoryNameContainingIgnoreCase(directoryName, pageable);
		return ResponseEntity.ok().body(result);
	}

	/*
	 * //Retorna um Directory por o nome
	 * 
	 * @RequestMapping(value="/{directoryName}",method = RequestMethod.GET) public
	 * ResponseEntity<Directory> findByDirectoryName(
	 * 
	 * @RequestParam(defaultValue = "") String directoryName) { Directory dire =
	 * service.findByDirectoryName(directoryName); return
	 * ResponseEntity.ok().body(dire);
	 * 
	 * }
	 */

	// cria uma Directory
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Directory obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	// atualiza uma Directory
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Directory obj, @PathVariable Integer id) {
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}

	// deleta uma Directory por o id
	/*
	 * @RequestMapping(value = "/{id}", method = RequestMethod.DELETE) public
	 * ResponseEntity<Directory> delete(@PathVariable Integer id) {
	 * service.delete(id); return ResponseEntity.noContent().build(); }
	 */

	// deleta uma Directory por o nome
	@RequestMapping(value = "/{directoryName}", method = RequestMethod.DELETE)
	public ResponseEntity<Directory> delete(@PathVariable String directoryName) {
		service.deleteName(directoryName);
		return ResponseEntity.noContent().build();
	}

	// retorna uma lista de Directory
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<DirectoryDTO>> findAll() {
		List<Directory> list = service.findALL();
		List<DirectoryDTO> listDTO = list.stream().map(obj -> new DirectoryDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	// retorna os singlesfiles atraves de uma paginação
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<DirectoryDTO>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "directoryName") String orderBy,
			@RequestParam(value = "direction", defaultValue = "DESC") String direction) {
		Page<Directory> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<DirectoryDTO> listDTO = list.map(obj -> new DirectoryDTO(obj));
		return ResponseEntity.ok().body(listDTO);
	}

}
