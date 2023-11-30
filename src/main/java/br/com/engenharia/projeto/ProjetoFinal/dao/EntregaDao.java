package br.com.engenharia.projeto.ProjetoFinal.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.engenharia.projeto.ProjetoFinal.dominio.Cliente;
import br.com.engenharia.projeto.ProjetoFinal.dominio.Entrega;
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
	public String alterar(Entrega entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> consultar(Entrega entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean inativar(Entrega entidade) {
		// TODO Auto-generated method stub
		return false;
	}

}
