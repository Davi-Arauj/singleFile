package com.davi.ormel.teste.dto;

import java.io.Serializable;

import com.davi.ormel.teste.domain.SingleFile;

public class SingleFileDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String fileName;
	private String directoryName;
	
	public SingleFileDTO() {}

	public SingleFileDTO(SingleFile sg) {
		this.id = sg.getId();
		this.fileName = sg.getFileName();
		this.directoryName = sg.getDirectoryName();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getDirectoryName() {
		return directoryName;
	}

	public void setDirectoryName(String directoryName) {
		this.directoryName = directoryName;
	}

	
	
	
	
}
