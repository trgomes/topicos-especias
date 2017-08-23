package br.gov.sp.fatec;

import java.util.ArrayList;

public class Oficina {
	
	private String nome;
	private String cnpj;
	
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	
	
	public Oficina() {
		
	}
	
	public Oficina(String nome, String cnpj) {
		this.nome = nome;
		this.cnpj = cnpj;
		this.clientes = new ArrayList<Cliente>();
	}
	
		
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	// Adiciona os clientes à lista
	public void addClientes( Cliente cliente) {
		this.clientes.add(cliente);
	}
	
	
	// Cria uma String com todos os clientes
	public String exibeClientes() {
		
		String strCli = "";
		
		for (Cliente c : clientes) {
			strCli += " " + c.getNome() + ",";
		}
		
		return strCli;
	}
	
	
	public String toString() {
		return "Oficina: " + nome +
			   " CNPJ: " + cnpj +
			   " Clientes:" + exibeClientes();
	}
	
	

}
