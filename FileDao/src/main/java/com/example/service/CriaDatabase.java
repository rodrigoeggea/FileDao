package com.example.service;

import java.util.List;

import com.example.dao.InterfaceDao;
import com.example.dao.PersonFileDao;
import com.example.model.ObjectUtils;
import com.example.model.Person;

public class CriaDatabase {
	static final InterfaceDao<Person> dao = new PersonFileDao();
	
	public static void main(String[] args) {
		System.out.println("--- APAGANDO A DATABASE ---");
		apagaDatabase();
		
		System.out.println("--- CARREGANDO NOVOS DADOS ---");
		criaDatabase();
	}
	
	/**
	 * Cria nova database
	 */
	static void criaDatabase() {
		List<Person> persons = DataGenerator.gerarPessoas(10); 
		for(Person person : persons) {
			dao.save(person);
		}
		// Printa
		dao.findAll().forEach(System.out::println);
		
		// Tamanho em bytes
		System.out.println("Tamanho: " + ObjectUtils.sizeof(persons) + " bytes");
	}
	
	/**
	 * Apaga todos os dados
	 */
	static void apagaDatabase() {
		for(Person person : dao.findAll()) {
			dao.delete(person);
		}
		// Printa
		dao.findAll().forEach(System.out::println);
	}
}
