package com.davi.ormel.teste.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.davi.ormel.teste.domain.Directory;
import com.davi.ormel.teste.domain.SingleFile;
import com.davi.ormel.teste.repositories.SingleFileRepository;
import com.davi.ormel.teste.services.exception.ObjectNotFoundException;

@Service
public class SingleFileService {

	@Autowired
	private SingleFileRepository repo;

	// buscando o arquivo pelo id
	public SingleFile find(Integer id) {
		Optional<SingleFile> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ",Tipo: " + SingleFile.class.getName()));
	}

	// inserindo um arquivo
	public SingleFile insert(SingleFile obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	// atualizando um arquivo
	public SingleFile update(SingleFile obj) {
		find(obj.getId());
		return repo.save(obj);
	}

	// apagando um arquivo por o id
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {

		}
	}
	
	// apagando um arquivo por o nome
	public void deleteByFileName(String fileName) {
		SingleFile sg = repo.findByFileName(fileName);
		repo.delete(sg);
	}

	// recuparando uma lista de arquivos
	public List<SingleFile> findALL() {
		return repo.findAll();
	}

	public Page<SingleFile> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

	

}
