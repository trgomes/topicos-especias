package br.gov.sp.fatec.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import br.gov.sp.fatec.view.View;

import com.fasterxml.jackson.annotation.JsonView;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "USR_USUARIO")
public class Usuario{

	@Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "USR_ID")
	@JsonView({View.All.class, View.Alternative.class})
	private Long id;
    
    @Column(name = "USR_NOME", unique=true, length = 20, nullable = false)
    @JsonView({View.Main.class, View.Alternative.class})
    private String nome;
    
    @Column(name = "USR_SENHA", length = 50, nullable = false)
    @JsonView(View.All.class)
    private String senha;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "UAU_USUARIO_AUTORIZACAO", 
    	joinColumns = { @JoinColumn(name = "USR_ID") }, 
    	inverseJoinColumns = { @JoinColumn(name = "AUT_ID") })
    @JsonView({View.Main.class, View.Alternative.class})
    @XmlElement(name = "autorizacao")
    private List<Autorizacao> autorizacoes;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * @return the autorizacoes
	 */
	public List<Autorizacao> getAutorizacoes() {
		return autorizacoes;
	}

	/**
	 * @param autorizacoes the autorizacoes to set
	 */
	public void setAutorizacoes(List<Autorizacao> autorizacoes) {
		this.autorizacoes = autorizacoes;
	}

}
