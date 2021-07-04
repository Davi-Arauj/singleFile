package com.davi.ormel.teste.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.davi.ormel.teste.domain.Directory;
import com.davi.ormel.teste.repositories.DirectoryRepository;
import com.davi.ormel.teste.services.exception.ObjectNotFoundException;

@Service
public class DirectoryService {

	@Autowired
	private DirectoryRepository repo;

	// buscando o directory por o id
	public Directory find(Integer id) {
		Optional<Directory> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ",Tipo: " + Directory.class.getName()));
	}

	public Directory findByDirectoryName(String directoryName) {
		return repo.findByDirectoryName(directoryName);
	}

	// inserindo um directory
	public Directory insert(Directory obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	// atualizando um directory
	public Directory update(Directory obj) {
		find(obj.getId());
		return repo.save(obj);
	}

	/*
	 * apagando um directory por o id public void delete(Integer id) { Directory
	 * dire = find(id); if(dire.getFiles().isEmpty()) { repo.deleteById(id); }else {
	 * System.out.println("Não é possivel apagar uma pasta que possua arquivos!!");
	 * } try { repo.deleteById(id); }
	 * 
	 * catch (DataIntegrityViolationException e) { throw new
	 * DataIntegrityException("Não é possivel apagar uma pasta que possua arquivos!!"
	 * ); }
	 * 
	 * }
	 */

	// apagando um directory por o nome
	public void deleteName(String directoryName) {
		Directory dire = repo.findByDirectoryNameContainingIgnoreCase(directoryName);
		if (dire.getFiles().isEmpty()) {
			repo.deleteById(dire.getId());
		} else {
			System.out.println("Não é possivel apagar uma pasta que possua arquivos!!");
		}
	}

	// recuparando uma lista de directorys
	public List<Directory> findALL() {
		return repo.findAll();
	}

	// recuparando uma lista paginada de directorys
	public Page<Directory> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

}
