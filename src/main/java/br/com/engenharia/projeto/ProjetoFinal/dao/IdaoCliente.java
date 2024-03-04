package br.com.engenharia.projeto.ProjetoFinal.dao;

import java.util.Optional;

import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosAtualizacaoCliente;
import br.com.engenharia.projeto.ProjetoFinal.entidade.Cliente;

public interface IdaoCliente {

	public void salvar(Cliente entidade);
	public void alterar(Cliente entidade, DadosAtualizacaoCliente dados);
	public Optional<Cliente> consultar(Cliente entidade);
	public void excluir(Cliente entidade);
}
