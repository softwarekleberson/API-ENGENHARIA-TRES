package br.com.engenharia.projeto.ProjetoFinal.controle;

import java.util.List;

import br.com.engenharia.projeto.ProjetoFinal.dominio.Cliente;

public interface IfachadaCliente {

	public String salvar(Cliente entidade);
	public String alterar(Cliente entidade);
	public List<Cliente> consultar(Cliente entidade);
	public String excluir(Cliente entidade);
}
