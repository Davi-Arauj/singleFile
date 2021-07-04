package com.davi.ormel.teste.dto;

import java.io.Serializable;

import com.davi.ormel.teste.domain.Directory;
import com.davi.ormel.teste.domain.File;

public class DirectoryDTO implements Serializable,File{

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String directoryName;
	private String meuLocal;
	
	public DirectoryDTO() {}

	public DirectoryDTO(Directory directory) {
		super();
		this.id = directory.getId();
		this.directoryName = directory.getDirectoryName();
		this.meuLocal = directory.getMeuLocal();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDirectoryName() {
		return directoryName;
	}

	public void setDirectoryName(String directoryName) {
		this.directoryName = directoryName;
	}

	@Override
	public boolean isFile(boolean opc) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDirectory(boolean opc) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getMeuLocal() {
		return meuLocal;
	}

	public void setMeuLocal(String meuLocal) {
		this.meuLocal = meuLocal;
	}

	
	
	
}
