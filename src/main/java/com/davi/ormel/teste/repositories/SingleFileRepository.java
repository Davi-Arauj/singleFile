package com.davi.ormel.teste.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.davi.ormel.teste.domain.SingleFile;

@Repository
public interface SingleFileRepository extends JpaRepository<SingleFile,Integer>{


	public Page<SingleFile> findByFileNameContainingIgnoreCase(String fileName, Pageable pageable);
	
	public SingleFile findByFileName(String fileName);
}
