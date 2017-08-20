package br.gov.sp.fatec;

public class Cliente {
	
	private String nome;
	private String cpf;
	
	private Carro carro = new Carro();	
	

	public Cliente() {
		
	}
	
	public Cliente (String nome, String cpf, Carro carro) {
		this.nome = nome;
		this.cpf = cpf;
		this.carro = carro;
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
	
	
	public Carro getCarro() {
		return carro;
	}

	
	public void setCarro(Carro carro) {
		this.carro = carro;
	}


	public String toString() {
		return "Nome: " + this.nome + 
			   " CPF: " + this.cpf +
			   " Carro: " + this.carro.getModelo();
	}

}
