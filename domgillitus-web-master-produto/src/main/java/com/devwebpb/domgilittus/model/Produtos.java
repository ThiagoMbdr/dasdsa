package com.devwebpb.domgilittus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_produtos")
public class Produtos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nm_nome", nullable = false)
	private String nome;

	@Column(name = "nm_descricao")
	private String descricao;

	@ManyToOne()
	@JoinColumn(name = "cd_tipo_produto")
	private Tipo tipo;

	@Column(name = "nm_valor", nullable = false)
	private float valor;

	@Column(name = "fl_disponivel")
	private boolean disponivel;

	public Produtos(Long id, String nome, String descricao, Tipo tipo, float valor, boolean disponivel) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.tipo = tipo;
		this.valor = valor;
		this.disponivel = disponivel;
	}

	public Produtos() {
		super();

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

}
