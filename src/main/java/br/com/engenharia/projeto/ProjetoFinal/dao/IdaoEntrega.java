package br.com.engenharia.projeto.ProjetoFinal.dao;

import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosAtualizacaoEntregas;
import br.com.engenharia.projeto.ProjetoFinal.entidade.Entrega;

public interface IdaoEntrega {

	public void salvar(Entrega entrega);
	public void alterar(Entrega entidade, DadosAtualizacaoEntregas dados);
	public void excluir(Entrega cliente);

}
