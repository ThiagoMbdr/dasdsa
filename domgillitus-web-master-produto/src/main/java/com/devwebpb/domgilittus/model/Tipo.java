package com.devwebpb.domgilittus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_tipoproduto")
public class Tipo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_tipo_produto")
	private Long id;

	@Column(name = "nm_tipo", nullable = false)
	private String tipo;

	@Column(name = "nm_descricao")
	private String descricao;

	public Tipo(Long id, String tipo, String descricao) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.descricao = descricao;
	}

	public Tipo() {
		super();

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
