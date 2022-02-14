package com.example.dao;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.example.model.Person;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class PersonFileManager {
	static private final File databaseDir = new File("c:/temp/database/");
	static private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

	PersonFileManager() {};
	
	/**
	 * Salva todos os registros.
	 * @param persons
	 * @throws IOException
	 */
	static public void save(List<Person> persons) {
		for(Person person : persons) { 
			try {
				save(person);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
	}
	
	/**
	 * Carrega todos os registros.
	 * @return
	 * @throws IOException
	 */
	static public List<Person> load() {
		List<Person> persons = new ArrayList<>();
		for(File file : databaseDir.listFiles()) {
			Long id = Long.valueOf(file.getName());
			persons.add( load(id) );
		}
		Collections.sort(persons);
		return persons;
	}
	
	/**
	 * Salva o person no disco.
	 * @param person
	 * @throws IOException
	 */
	static public void save(Person person) {
		String json = gson.toJson(person);
		try {
			Long id = person.getId();
			FileUtils.writeStringToFile(new File(databaseDir, id.toString()), json, "utf-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Carrega do disco o person pelo seu ID, ou null de não existir o registro.
	 * @param id
	 * @return
	 */
	static public Person load(Long id) {
		Person person = null;
		File file = new File(databaseDir, id.toString());
		if(file.exists()) {
			try {
				String json = FileUtils.readFileToString(file,"utf-8");
				person = gson.fromJson(json, Person.class);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("ID não existe=" + id);
		}
		return person;
	}
	
	static public boolean delete(Long id) {
		File file = new File(databaseDir, id.toString());
		if(file.exists()) {
			try {
				FileUtils.delete(new File(databaseDir, id.toString()));
				return true;
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("ID não existe=" + id);
		}
		return false;
	}
}
