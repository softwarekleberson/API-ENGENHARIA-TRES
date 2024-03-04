package br.com.engenharia.projeto.ProjetoFinal.dao;

import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosAtualizacaoCliente;
import br.com.engenharia.projeto.ProjetoFinal.entidade.Cobranca;

public interface IdaoCobranca {

	public void salvar(Cobranca cobranca);
	public void alterar(Cobranca cobranca, DadosAtualizacaoCliente dados);
	public void excluir(Cobranca cobranca);
}
