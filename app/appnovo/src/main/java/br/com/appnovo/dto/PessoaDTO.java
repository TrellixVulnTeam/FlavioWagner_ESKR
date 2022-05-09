package br.com.appnovo.dto;

import java.util.Date;

import br.com.appnovo.model.Pessoa;

public class PessoaDTO {
	private Integer id;
	private String nome;
	private String descricao;
	private Date nascimento;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public PessoaDTO(Integer id,String nome, String descricao, Date nascimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.nascimento = nascimento;
	}	
	
	
	public PessoaDTO(Pessoa pessoa) {
		this.id = pessoa.getId();
		this.nome = pessoa.getNome();
		this.descricao = pessoa.getDescricao();
		this.nascimento = pessoa.getNascimento();
	}		
}
