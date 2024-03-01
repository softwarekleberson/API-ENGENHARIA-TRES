package br.com.engenharia.projeto.ProjetoFinal.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.engenharia.projeto.ProjetoFinal.Entidade.Cliente;
import br.com.engenharia.projeto.ProjetoFinal.Entidade.Entrega;
import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosAtualizacaoEndereco;
import br.com.engenharia.projeto.ProjetoFinal.persistencia.EntregaRepository;

public class EntregaDao implements IdaoEntrega{

	@Autowired
	private EntregaRepository repository;
	
	public EntregaDao(EntregaRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public String salvar(Entrega entidade) {
		repository.save(entidade);
		return null;
	}

	@Override
	public String alterar(Entrega entidade, DadosAtualizacaoEndereco dados) {
		if(dados.bairro() != null) {
			entidade.setBairro(dados.bairro());
		}
		if(dados.cep() != null) {
			entidade.setCep(dados.cep());
		}
		if(dados.logradouro() != null) {
			entidade.setLogradouto(dados.logradouro());;
		}
		if(dados.observacao() != null) {
			entidade.setObservacao(dados.observacao());
		}
		if(dados.numero() != null) {
			entidade.setNumero(dados.numero());
		}
		return null;
	}

	@Override
	public List<Cliente> consultar(Entrega entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean inativar(Entrega entidade) {
		repository.delete(entidade);
		return false;
	}

}
