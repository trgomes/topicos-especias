package br.gov.sp.fatec.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.view.View;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "clientes")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cli_id")
	@JsonView({View.Main.class, View.Alternative.class})
	private Long id;
	
	@Column(name = "cli_nome", length = 20, nullable = false)
	@JsonView({View.Main.class, View.Alternative.class})
	private String nome;
	
	@Column(name = "cli_cpf", unique = true, length = 15, nullable = false)
	@JsonView({View.Main.class, View.Alternative.class})
	private String cpf;
	
	public Cliente() {
		
	}
	
	public Cliente(String nome, String cpf) {
		super();
		this.nome = nome;
		this.cpf = cpf;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
}
