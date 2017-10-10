package br.gov.sp.fatec.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.view.View;



@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "carros")
public class Carro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "car_id")
	@JsonView({View.Main.class, View.Alternative.class})
	private Long id;
	
	@Column(name = "car_marca", length = 20, nullable = false)
	@JsonView({View.Main.class, View.Alternative.class})
	private String marca;
	
	@Column(name = "car_modelo", length = 20, nullable = false)
	@JsonView({View.Main.class, View.Alternative.class})
	private String modelo;
	
	@Column(name = "car_cor", length = 20, nullable = false)
	@JsonView({View.Main.class, View.Alternative.class})
	private String cor;
	
	@Column(name = "car_placa", length = 8, nullable = false)
	@JsonView({View.Main.class, View.Alternative.class})
	private String placa;
	
	@ManyToOne
	@JsonView({View.Main.class, View.Alternative.class})
    @XmlElement(name = "cliente")
	private Cliente cliente;	
	
	public Carro() {
		
	}
	

	public Carro(String marca, String modelo, String cor, String placa) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.cor = cor;
		this.placa = placa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
}
