package br.com.engenharia.projeto.ProjetoFinal.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosAtualizacaoEndereco;
import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosDetalhamentoCobranca;
import br.com.engenharia.projeto.ProjetoFinal.entidade.Cobranca;

public interface IdaoCobranca {

	public void salvar(Cobranca cobranca);
	Page<DadosDetalhamentoCobranca> listarEnderecosCobrancaDoCliente(Long clienteId, Pageable pageable);
	void excluir(Long clienteId, Long idCobranca);
	DadosDetalhamentoCobranca salvarNovaCobranca(Cobranca cobranca, Long clienteId);
	Cobranca alterar(DadosAtualizacaoEndereco dados, Long clienteId, Long idCobranca);
}
