package br.com.engenharia.projeto.ProjetoFinal.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.engenharia.projeto.ProjetoFinal.dominio.Cartao;
import br.com.engenharia.projeto.ProjetoFinal.dominio.Cliente;
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
	public String alterar(Cartao entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> consultar(Cartao entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean inativar(Cartao entidade) {
		// TODO Auto-generated method stub
		return false;
	}

	

	

}
