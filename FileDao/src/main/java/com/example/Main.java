package com.example;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.example.dao.InterfaceDao;
import com.example.dao.PersonFileDao;
import com.example.model.Person;
import com.example.service.DataGenerator;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
//	static InterfaceDao<Person> dao = new PersonFileDao("c:/temp/txtDatabase.json");
	
	public static void main(String[] args) throws IOException {
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		List<Person> persons = DataGenerator.gerarPessoas(10);
		
		Map<Long, Person> database = DataGenerator.gerarPessoas(10).stream()
				.collect(Collectors.toMap(Person::getId, Function.identity()));
		
		System.out.println(gson.toJson(database));
		
		
	}
	
	
	static void printPersons(List<Person> pessoas) {
		System.out.println("------------- ANTES -----------------");
		pessoas.forEach(System.out::println);
		System.out.println("------------- DEPOIS -----------------");
		pessoas.forEach(System.out::println);
	}

}
