package com.davi.ormel.teste.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Directory implements File,Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String directoryName; 
	private String meuLocal;
	
    @JsonIgnore
	@ManyToMany
	@JoinTable(name = "DIRECTORY_SINGLEFILE",
	joinColumns = @JoinColumn(name= "directory_id"),
	inverseJoinColumns = @JoinColumn(name="singlefile_id")
	)
	private List<SingleFile> files = new ArrayList<>();
	
	public Directory() {}
	public Directory(String directoryName,String meuLocal) {
		this.directoryName = directoryName;
		this.meuLocal = meuLocal;
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
	public List<SingleFile> getFiles() {
		return files;
	}
	public void setFiles(List<SingleFile> files) {
		this.files = files;
	}
	
}
