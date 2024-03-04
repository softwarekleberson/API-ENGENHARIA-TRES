package br.com.engenharia.projeto.ProjetoFinal.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosAtualizacaoEntrega;
import br.com.engenharia.projeto.ProjetoFinal.entidade.Entrega;
import br.com.engenharia.projeto.ProjetoFinal.persistencia.EntregaRepository;

@Service
public class EntregaDao implements IdaoEntrega{

	@Autowired
	private EntregaRepository repository;
	
	public EntregaDao(EntregaRepository repository) {
		this.repository = repository;
	}

	@Override
	public void salvar(Entrega entrega) {
		this.repository.save(entrega);
	}

	@Override
	public void alterar(Entrega entidade, DadosAtualizacaoEntrega dados) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(Entrega cliente) {
		// TODO Auto-generated method stub
		
	}
	
	
}
