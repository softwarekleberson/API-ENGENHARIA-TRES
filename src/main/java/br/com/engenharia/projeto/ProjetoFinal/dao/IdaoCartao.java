package br.com.engenharia.projeto.ProjetoFinal.dao;

import java.util.List;

import br.com.engenharia.projeto.ProjetoFinal.dominio.Cartao;
import br.com.engenharia.projeto.ProjetoFinal.dominio.Cliente;

public interface IdaoCartao {

	public String salvar(Cartao entidade);
	public String alterar(Cartao entidade);
	public List<Cliente> consultar(Cartao entidade);
	public boolean inativar(Cartao entidade);
}
