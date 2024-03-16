package br.com.engenharia.projeto.ProjetoFinal.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosAtualizacaoEntregas;
import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosDetalhamentoEntrega;
import br.com.engenharia.projeto.ProjetoFinal.entidade.Entrega;

public interface IdaoEntrega {

	DadosDetalhamentoEntrega salvarNovoEntrega(Entrega entrega, Long clienteId);
	void salvar(Entrega entrega);
	Page<DadosDetalhamentoEntrega> listarEntregasDoCliente(Long clienteId, Pageable pageable);
	void excluir(Long clienteId, Long idEntrega);
	Entrega alterar(DadosAtualizacaoEntregas dados, Long clienteId, Long idEntrega);
}
