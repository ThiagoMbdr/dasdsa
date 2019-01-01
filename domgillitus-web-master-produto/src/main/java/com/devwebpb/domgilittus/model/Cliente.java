package com.devwebpb.domgilittus.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_cliente")
    private Long id;

    @Column(name = "nm_cliente", nullable = false)
    private String nome;

    @Column(name = "nm_telefone", nullable = false)
    @NotBlank
    private String telefone;

    @Column(name = "nm_rua")
    private String rua;

    @Column(name = "nu_numero")
    private int numero;

    @Column(name = "nm_bairro")
    private String bairro;

    @Column(name = "nm_ponto_referencia")
    private String pontoReferencia;

    @Column(name = "dt_cadastro", insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable=false)
    @Temporal(TemporalType.DATE)
    private Date dataCadastro;

    public Cliente() {
    }

    public Cliente(String nome, String telefone, String rua, int numero, String bairro, String pontoReferencia, Date dataCadastro) {
        this.nome = nome;
        this.telefone = telefone;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.pontoReferencia = pontoReferencia;
        this.dataCadastro = dataCadastro;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getPontoReferencia() {
        return pontoReferencia;
    }

    public void setPontoReferencia(String pontoReferencia) {
        this.pontoReferencia = pontoReferencia;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
