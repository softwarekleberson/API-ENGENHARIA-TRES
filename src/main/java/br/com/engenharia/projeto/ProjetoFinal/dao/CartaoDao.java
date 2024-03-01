package br.com.engenharia.projeto.ProjetoFinal.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.engenharia.projeto.ProjetoFinal.Entidade.Cartao;
import br.com.engenharia.projeto.ProjetoFinal.Entidade.Cliente;
import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosAtualizacaoCartao;
import br.com.engenharia.projeto.ProjetoFinal.persistencia.CartaoRepository;

public class CartaoDao implements IdaoCartao{

	@Autowired
	private CartaoRepository repository;
	
	public CartaoDao(CartaoRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public String salvar(Cartao entidade) {
		repository.save(entidade);
		return null;
	}

	@Override
	public String alterar(Cartao entidade, DadosAtualizacaoCartao dados) {
		if(dados.nomeImpresso() != null) {
			entidade.setNomeImpresso(dados.nomeImpresso());
		}
		if(dados.codigo() != null) {
			entidade.setCodigo(dados.codigo());
		}
		return null;
	}
	
	@Override
	public List<Cliente> consultar(Cartao entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean inativar(Cartao entidade) {
		repository.delete(entidade);
		return false;
	}	

}
