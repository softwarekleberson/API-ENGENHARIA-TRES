package br.com.engenharia.projeto.ProjetoFinal.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.engenharia.projeto.ProjetoFinal.dominio.Cliente;
import br.com.engenharia.projeto.ProjetoFinal.dominio.Cobranca;
import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosAtualizacaoEndereco;
import br.com.engenharia.projeto.ProjetoFinal.persistencia.CobrancaRepository;

public class CobrancaDao implements IdaoCobranca{

	@Autowired
	private CobrancaRepository repository;
	
	public CobrancaDao(CobrancaRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public String salvar(Cobranca entidade) {
		repository.save(entidade);
		return null;
	}

	@Override
	public String alterar(Cobranca entidade, DadosAtualizacaoEndereco dados) {
		if(dados.bairro() != null) {
			entidade.setBairro(dados.bairro());
		}
		if(dados.cep() != null) {
			entidade.setCep(dados.cep());
		}
		if(dados.logradouro() != null) {
			entidade.setLogradouro(dados.logradouro());
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
	public List<Cliente> consultar(Cobranca entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean inativar(Cobranca entidade) {
		repository.delete(entidade);
		return false;
	}

}
