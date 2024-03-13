package br.com.engenharia.projeto.ProjetoFinal.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosAtualizacaoCartao;
import br.com.engenharia.projeto.ProjetoFinal.entidade.Cartao;

public interface IdaoCartao {

	public String salvar(Cartao entidade);
	Page pegaTodosCartaoes(Pageable paginacao);
	Cartao alterar(Long idCartao, DadosAtualizacaoCartao dados);
	public void deletar(Long id);
}
