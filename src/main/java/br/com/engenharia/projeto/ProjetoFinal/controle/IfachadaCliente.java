package br.com.engenharia.projeto.ProjetoFinal.controle;

import java.util.List;

import br.com.engenharia.projeto.ProjetoFinal.Entidade.Cliente;
import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosAtualizacaoCliente;

public interface IfachadaCliente {

	public String salvar(Cliente entidade);
	public String alterar(Cliente entidade, DadosAtualizacaoCliente dados);
	public List<Cliente> consultar(Cliente entidade);
	public String excluir(Cliente entidade);
}
