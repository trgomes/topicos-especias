package br.gov.sp.fatec;

public class Carro {
	
	private String placa;	
	private String marca;
	private String modelo;
	

	public Carro() {
		
	}
	
	
	public Carro(String placa, String marca, String modelo) {
		super();
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
	}
	
	
	
	public String getPlaca() {
		return placa;
	}



	public void setPlaca(String placa) {
		this.placa = placa;
	}



	public String getMarca() {
		return marca;
	}



	public void setMarca(String marca) {
		this.marca = marca;
	}



	public String getModelo() {
		return modelo;
	}



	public void setModelo(String modelo) {
		this.modelo = modelo;
	}



	public String toString() {
		return "Placa: " + this.placa +
			   " Marca: " + this.marca + 
			   " Modelo: " + this.modelo;
	}
	
	
	
}
