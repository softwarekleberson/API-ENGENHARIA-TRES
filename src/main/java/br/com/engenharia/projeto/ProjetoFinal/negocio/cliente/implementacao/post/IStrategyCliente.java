package br.com.engenharia.projeto.ProjetoFinal.negocio.cliente.implementacao.post;

import br.com.engenharia.projeto.ProjetoFinal.entidade.Cliente;

public interface IStrategyCliente {

	public String processar(Cliente dominio);
}
