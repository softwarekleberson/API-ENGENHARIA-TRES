package br.com.engenharia.projeto.ProjetoFinal.dtos;

import java.time.LocalDate;

import br.com.engenharia.projeto.ProjetoFinal.dominio.Cliente;
import br.com.engenharia.projeto.ProjetoFinal.dominio.Email;

public record DadosDetalhamentoCliente(
		String nome, LocalDate nascimento, Email email,
		String ddd, String telefone
		
		)

{

	public DadosDetalhamentoCliente(Cliente cliente) {
		this(cliente.getNome(), cliente.getNascimento(),
			 cliente.getEmail(), cliente.getTelefone().getDdd(),
			 cliente.getTelefone().getTelefone());
	}

}
