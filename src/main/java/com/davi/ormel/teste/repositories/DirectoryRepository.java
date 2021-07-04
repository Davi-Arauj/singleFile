package com.davi.ormel.teste.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.davi.ormel.teste.domain.Directory;

@Repository
public interface DirectoryRepository extends JpaRepository<Directory,Integer>{

	Page<Directory> findByDirectoryNameContainingIgnoreCase(String directoryName, Pageable pageable);
	

	Directory findByDirectoryNameContainingIgnoreCase(String directoryName);
	
	Directory findByDirectoryName(String directoryName);

}
