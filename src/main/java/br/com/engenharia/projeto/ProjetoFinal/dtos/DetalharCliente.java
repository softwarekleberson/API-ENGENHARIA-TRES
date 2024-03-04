package br.com.engenharia.projeto.ProjetoFinal.dtos;

import br.com.engenharia.projeto.ProjetoFinal.entidade.Cliente;
import br.com.engenharia.projeto.ProjetoFinal.entidade.Email;

public record DetalharCliente(
		
		Long id, String nome, Email email
		
		) {

	public DetalharCliente(Cliente cliente) {
		this(cliente.getId(), cliente.getNome(), cliente.getEmail());
	}
}
