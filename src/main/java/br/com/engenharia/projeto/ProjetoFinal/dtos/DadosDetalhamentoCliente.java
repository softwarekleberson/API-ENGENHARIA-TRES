package br.com.engenharia.projeto.ProjetoFinal.dtos;

import java.time.LocalDate;

import br.com.engenharia.projeto.ProjetoFinal.entidade.Cliente;
import br.com.engenharia.projeto.ProjetoFinal.entidade.Email;

public record DadosDetalhamentoCliente(
		Long id, String nome, LocalDate nascimento, Email email,
		String ddd, String telefone
		
		)

{

	public DadosDetalhamentoCliente(Cliente cliente) {
		this(cliente.getId() ,cliente.getNome(), cliente.getNascimento(),
			 cliente.getEmail(), cliente.getTelefone().getDdd(),
			 cliente.getTelefone().getTelefone());
	}

}
