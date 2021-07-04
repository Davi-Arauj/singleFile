package com.davi.ormel.teste.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class SingleFile implements File,Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String fileName;
	private String directoryName;
	
	@ManyToMany(mappedBy = "files")
	private List<Directory> directories = new ArrayList<>();
	
	public SingleFile() {
		
	}
	
	public SingleFile(String fileName,String directory) {
		super();
		this.fileName = fileName;
		this.setDirectoryName(directory);
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

	
	

	public List<Directory> getDirectories() {
		return directories;
	}

	public void setDirectories(List<Directory> directories) {
		this.directories = directories;
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

	public String getDirectoryName() {
		return directoryName;
	}

	public void setDirectoryName(String directoryName) {
		this.directoryName = directoryName;
	}
	
	

}
