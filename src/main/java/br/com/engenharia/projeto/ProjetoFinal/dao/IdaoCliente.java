package br.com.engenharia.projeto.ProjetoFinal.dao;

import java.util.List;

import br.com.engenharia.projeto.ProjetoFinal.dominio.Cliente;

public interface IdaoCliente {

	public String salvar(Cliente entidade);
	public String alterar(Cliente entidade);
	public List<Cliente> consultar(Cliente entidade);
	public boolean inativar(Cliente entidade);
	public String alterarEndercoCobranca(Cliente entidade);
	public String alterarEndercoEntrega(Cliente entidade);
	public String excluir(Cliente entidade);
	
}
