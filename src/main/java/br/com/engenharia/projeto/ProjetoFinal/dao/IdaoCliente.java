package br.com.engenharia.projeto.ProjetoFinal.dao;

import java.util.List;
import java.util.Optional;

import br.com.engenharia.projeto.ProjetoFinal.dominio.Cliente;
import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosAtualizacaoCliente;

public interface IdaoCliente {

	public String salvar(Cliente entidade);
	public String alterar(Cliente entidade, DadosAtualizacaoCliente dados);
	public Optional<Cliente> consultar(Cliente entidade);
	public String excluir(Cliente entidade);
	
}
