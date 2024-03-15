package br.com.engenharia.projeto.ProjetoFinal.dao;

import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosAtualizacaoCobrancas;
import br.com.engenharia.projeto.ProjetoFinal.entidade.Cobranca;
import br.com.engenharia.projeto.ProjetoFinal.entidade.Endereco;

public interface IdaoCobranca {

	public void salvar(Cobranca cobranca);
	void excluir(Long clienteId, Long idCobranca);
	Cobranca alterar(DadosAtualizacaoCobrancas dados, Long clienteId, Long idCobranca);
}
