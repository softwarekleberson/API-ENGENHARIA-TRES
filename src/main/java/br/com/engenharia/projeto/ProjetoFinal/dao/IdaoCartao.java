package br.com.engenharia.projeto.ProjetoFinal.dao;

import java.util.List;

import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosAtualizacaoCartao;
import br.com.engenharia.projeto.ProjetoFinal.entidade.Cartao;
import br.com.engenharia.projeto.ProjetoFinal.entidade.Cliente;

public interface IdaoCartao {

	public String salvar(Cartao entidade);
	public List<Cliente> consultar(Cartao entidade);
	Cartao alterar(Long idCartao, DadosAtualizacaoCartao dados);
	public boolean inativar(Cartao entidade);
}
