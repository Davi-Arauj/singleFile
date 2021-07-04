package com.davi.ormel.teste.domain;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.io.File; 

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Aluno implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nameAluno;
	
	Calendar cal = GregorianCalendar.getInstance();
	private String directory = "/home/d/Documentos/Estudos-Davi/SpringBoot/"+String.valueOf(cal.get(Calendar.YEAR));
	File f1 = new File(directory);
	
	private boolean resp = f1.mkdir();
	
	
	public Aluno() {}

	public Aluno(String nameAluno) {		
		this.setNameAluno(nameAluno);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNameAluno() {
		return nameAluno;
	}

	public void setNameAluno(String nameAluno) {
		this.nameAluno = nameAluno;
	}

	public String getDirectory() {
		return directory;
	}

	public void setDirectory(String directory) {
		this.directory = directory;
	}

	

	
}
