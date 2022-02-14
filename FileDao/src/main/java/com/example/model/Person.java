package com.example.model;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable, Clonador<Person>, Comparable<Person>{
	private static final long serialVersionUID = 1L;
	private Long   id;
	private String rg;
	private String pronome;
	private String nome;
	private String sobrenome;
	private Integer idade;
	private String email;
	private String telefone;
	private String cidade;
	private String estado;
	private String pais;
	private String profissao;
	
	public Long getId() {
		return id;
	}
	public String getRg() {
		return rg;
	}
	public String getPronome() {
		return pronome;
	}
	public String getNome() {
		return nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public Integer getIdade() {
		return idade;
	}
	public String getEmail() {
		return email;
	}
	public String getTelefone() {
		return telefone;
	}
	public String getCidade() {
		return cidade;
	}
	public String getEstado() {
		return estado;
	}
	public String getPais() {
		return pais;
	}
	public String getProfissao() {
		return profissao;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public void setPronome(String pronome) {
		this.pronome = pronome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(cidade, email, estado, id, idade, nome, pais, profissao, pronome, rg, sobrenome, telefone);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Person))
			return false;
		Person other = (Person) obj;
		return Objects.equals(cidade, other.cidade) && Objects.equals(email, other.email)
				&& Objects.equals(estado, other.estado) && Objects.equals(id, other.id)
				&& Objects.equals(idade, other.idade) && Objects.equals(nome, other.nome)
				&& Objects.equals(pais, other.pais) && Objects.equals(profissao, other.profissao)
				&& Objects.equals(pronome, other.pronome) && Objects.equals(rg, other.rg)
				&& Objects.equals(sobrenome, other.sobrenome) && Objects.equals(telefone, other.telefone);
	}
	
	@Override
	public int compareTo(Person person) {
		return this.id.compareTo(person.getId()); 
	}
	
	@Override
	public String toString() {
		return String.format(
				"Person [id=%s, rg=%s, pronome=%s, nome=%s, sobrenome=%s, idade=%s, email=%s, telefone=%s, cidade=%s, estado=%s, pais=%s, profissao=%s]",
				id, rg, pronome, nome, sobrenome, idade, email, telefone, cidade, estado, pais, profissao);
	}
}
