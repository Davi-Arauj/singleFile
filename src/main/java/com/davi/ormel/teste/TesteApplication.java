package com.davi.ormel.teste;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.davi.ormel.teste.repositories.DirectoryRepository;
import com.davi.ormel.teste.repositories.SingleFileRepository;

@SpringBootApplication
public class TesteApplication implements CommandLineRunner{
	
	@Autowired
	private SingleFileRepository fileRepository;
	@Autowired
	private DirectoryRepository directoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(TesteApplication.class, args);
	
	}
	/*SingleFile sg = new SingleFile();
	SingleFile sg1 = new SingleFile();
	SingleFile sg2 = new SingleFile();
	SingleFile sg3 = new SingleFile();
	SingleFile sg4 = new SingleFile();
	
	Directory directory = new Directory();
	Directory directory1 = new Directory();
	
*/
	@Override
	public void run(String... args) throws Exception {
	/*	directory.setDirectoryName("pastateste");
		directory.setMeuLocal("C:/");
		directory.isDirectory(true);
		directory.isFile(false);
		
		directory1.setDirectoryName("pastateste1");
		directory1.setMeuLocal("C:/pastateste/");
		directory1.isDirectory(true);
		directory1.isFile(false);
		

		
		sg.setFileName("Aluno.java");
		sg.setDirectoryName(directory.getDirectoryName());
		sg.isFile(true);
		sg.isDirectory(false);
				
		sg1.setFileName("Aluno.php");
		sg1.setDirectoryName(directory.getDirectoryName());
		sg1.isFile(true);
		sg1.isDirectory(false);
		
		sg2.setFileName("Aluno.spring");
		sg2.setDirectoryName(directory.getDirectoryName());
		sg2.isFile(true);
		sg2.isDirectory(false);
		
		sg3.setFileName("Aluno.react");
		sg3.setDirectoryName(directory1.getDirectoryName());
		sg3.isFile(true);
		sg3.isDirectory(false);
		
		sg4.setFileName("Aluno.vueJS");
		sg4.setDirectoryName(directory1.getDirectoryName());
		sg4.isFile(true);
		sg4.isDirectory(false);
		
		
		directory.getFiles().addAll(Arrays.asList(sg,sg1,sg2));
		directory1.getFiles().addAll(Arrays.asList(sg3,sg4));
		
		sg.getDirectories().add(directory);
		sg1.getDirectories().add(directory);
		sg2.getDirectories().add(directory);
		sg3.getDirectories().add(directory1);
		sg4.getDirectories().add(directory1);
		
		fileRepository.saveAll(Arrays.asList(sg,sg1,sg2,sg3,sg4));
		directoryRepository.saveAll(Arrays.asList(directory,directory1));
		
		*/
		
		
	}
	
}
