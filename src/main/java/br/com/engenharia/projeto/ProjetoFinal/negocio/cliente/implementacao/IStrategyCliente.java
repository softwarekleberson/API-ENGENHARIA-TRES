package br.com.engenharia.projeto.ProjetoFinal.negocio.cliente.implementacao;

import br.com.engenharia.projeto.ProjetoFinal.entidade.Cliente;
import br.com.engenharia.projeto.ProjetoFinal.infra.TratadorErros.ValidacaoExcepetion;

public interface IStrategyCliente {

	public String processar(Cliente dominio) throws ValidacaoExcepetion;
}
