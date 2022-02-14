package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.example.model.Person;
import com.github.javafaker.Faker;

public class DataGenerator {
	private static final Faker faker = new Faker(new Locale("pt-br"));

	public static List<Person> gerarPessoas(int quantidade){
	List<Person> persons = new ArrayList<>();
	
	for(long id=1; id <= quantidade; id++) {
		Person person = new Person();
		person.setId(id);
		person.setRg(faker.idNumber().valid());
		person.setPronome(faker.name().prefix());
		person.setNome(faker.name().firstName());
		person.setSobrenome(faker.name().lastName());
		person.setIdade(faker.number().numberBetween(18, 99));
		person.setEmail(faker.internet().emailAddress());
		person.setTelefone(faker.phoneNumber().cellPhone());
		person.setCidade(faker.address().city());
		person.setEstado(faker.address().state());
		person.setPais("Brasil");
		person.setProfissao(faker.job().title());
		persons.add(person);
	}
	return persons;
}
	
	public static Map<Long, Person> gerarPessoasMap(int quantidade) {
		Map<Long, Person> database = DataGenerator.gerarPessoas(10).stream()
				.collect(Collectors.toMap(Person::getId, Function.identity()));
		return database;
	}
}
