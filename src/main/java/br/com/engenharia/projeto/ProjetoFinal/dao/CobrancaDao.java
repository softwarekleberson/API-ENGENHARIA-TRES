package br.com.engenharia.projeto.ProjetoFinal.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosAtualizacaoCliente;
import br.com.engenharia.projeto.ProjetoFinal.entidade.Cobranca;
import br.com.engenharia.projeto.ProjetoFinal.persistencia.CobrancaRepository;

@Service
public class CobrancaDao implements IdaoCobranca{

	@Autowired
	private CobrancaRepository repository;
	
	public CobrancaDao(CobrancaRepository repository) {
		this.repository = repository;
	}

	@Override
	public void salvar(Cobranca cobranca) {
		this.repository.save(cobranca);
	}

	@Override
	public void alterar(Cobranca cobranca, DadosAtualizacaoCliente dados) {
		// TODO Auto-generated method stub
	}

	@Override
	public void excluir(Cobranca cobranca) {
		// TODO Auto-generated method stub
	}
}