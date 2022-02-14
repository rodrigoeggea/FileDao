package com.example;

import java.io.IOException;
import java.util.List;

import com.example.dao.InterfaceDao;
import com.example.dao.PersonFileDao;
import com.example.dao.PersonFileManager;
import com.example.model.Person;
import com.example.service.DataGenerator;

public class Hello {

	public static void main(String[] args) throws IOException {

		InterfaceDao<Person> dao = new PersonFileDao();
		
		//createLocalDatabase();
		
		dao.find("idade", 50).forEach(System.out::println);
		
		
//		Person person = new Person();
//		person.setNome("Rodrigo");
//		person.setSobrenome("Fagundes");
		
//		System.out.println("--- listando ---");
//		dao.findAll().forEach(System.out::println);
//		
//		System.out.println("--- procurando ---");
		
		
		//System.out.println(dao.find(20L));
		
		//System.out.println(dao.find("nome", "Alexandre"));
		
		//dao.find("nome", "Clara").forEach(System.out::println);
//		Person person = dao.find(900L);
//		System.out.println(person);
		
		
		
//		Person person = dao.find(10L);
//		person.setNome("Rodrigo");
//		dao.update(person);
//		
//		
//		dao.findAll().forEach(System.out::println);
		
		//createLocalDatabase();
		//System.out.println(dao.find(20L));
		
		//loadLocalDatabase();
		System.out.println("--- FIM ---");
	}
	
	static void createLocalDatabase() throws IOException {
		System.out.println("--- CRIANDO BASE DE DADOS ---");
		System.out.println("--- GERANDO PESSOAS ---");
		List<Person> persons = DataGenerator.gerarPessoas(10000);
		System.out.println("--- SALVANDO NO DISCO ---");
		PersonFileManager.save(persons);
		persons.forEach(System.out::println);
	}
	
	static void loadLocalDatabase() throws IOException {
		List<Person> persons = PersonFileManager.load();
		persons.forEach(System.out::println);
	}

}
