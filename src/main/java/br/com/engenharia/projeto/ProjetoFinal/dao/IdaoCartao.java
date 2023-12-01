package br.com.engenharia.projeto.ProjetoFinal.dao;

import java.util.List;

import br.com.engenharia.projeto.ProjetoFinal.dominio.Cartao;
import br.com.engenharia.projeto.ProjetoFinal.dominio.Cliente;
import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosAtualizacaoCartao;
import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosAtualizacaoCliente;

public interface IdaoCartao {

	public String salvar(Cartao entidade);
	public List<Cliente> consultar(Cartao entidade);
	public String alterar(Cartao entidade, DadosAtualizacaoCartao dados);
	public boolean inativar(Cartao entidade);
}
