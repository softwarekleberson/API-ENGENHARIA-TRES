package br.com.engenharia.projeto.ProjetoFinal.dao;

import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosAtualizacaoCartao;
import br.com.engenharia.projeto.ProjetoFinal.entidade.Cartao;

public interface IdaoCartao {

	public String salvar(Cartao entidade);
	Cartao alterar(Long idCartao, DadosAtualizacaoCartao dados);
	public void deletar(Long id);
}
