package br.com.engenharia.projeto.ProjetoFinal.dao;

import java.util.List;

import br.com.engenharia.projeto.ProjetoFinal.dominio.Cliente;
import br.com.engenharia.projeto.ProjetoFinal.dominio.Entrega;

public interface IdaoEntrega {

	public String salvar(Entrega entidade);
	public String alterar(Entrega entidade);
	public List<Cliente> consultar(Entrega entidade);
	public boolean inativar(Entrega entidade);
	
}
