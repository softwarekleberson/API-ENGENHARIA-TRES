package br.com.engenharia.projeto.ProjetoFinal.dao;

import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosAtualizacaoEntregas;
import br.com.engenharia.projeto.ProjetoFinal.entidade.Entrega;

public interface IdaoEntrega {

	public void salvar(Entrega entrega);
	void exluir(Long clienteId);
	Entrega alterar(DadosAtualizacaoEntregas dados, Long clienteId, Long idEntrega);
}
