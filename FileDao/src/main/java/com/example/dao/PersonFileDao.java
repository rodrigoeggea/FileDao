package com.example.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.PropertyUtils;

import com.example.model.Person;

public class PersonFileDao implements InterfaceDao<Person> {
	final BeanUtilsBean bub = new BeanUtilsBean();

	/**
	 * Salva um novo objeto com novo ID sequencial, se Person já tiver um ID será ignorado.
	 */
	@Override
	public boolean save(Person person) {
		Long id = getLastId() + 1;
		person.setId(id);
		PersonFileManager.save(person);
		return false;
	}

	public long getLastId() {
		return PersonFileManager.load().stream().mapToLong(p -> p.getId()).max().orElse(0);
	}
	
	@Override
	public Person find(Long id) {
		return PersonFileManager.load(id);
	}

	@Override
	public List<Person> findAll() {
		return PersonFileManager.load();
	}

	@Override
	public void update(Person person) {
		Long id = person.getId();
		if(id == null) {
			System.out.println("UPDATE ERRO: Person com ID nulo.");
			return;
		}
		Person personToUpdate = PersonFileManager.load(id);
		if(personToUpdate == null) {
			System.out.println("UPDATE ERRO: ID não existe na base: " + id);
			return;
		}
		// Atualiza
		PersonFileManager.save(person);
	}

	@Override
	public boolean delete(Person person) {
		return PersonFileManager.delete(person.getId());
	}

	@Override
	public List<Person> find(String atributo, Object value) {
		List<Person> persons = PersonFileManager.load();
		List<Person> achados = new ArrayList<>();
		
		for(Person person : persons ) {
			try {
				if(PropertyUtils.getSimpleProperty(person, atributo).equals(value)) {
					achados.add(person);
				}
			} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
				System.out.println(e.getMessage());
			}
		}
		return achados;
	}
}
