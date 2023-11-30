package br.com.engenharia.projeto.ProjetoFinal.dtos;

import java.time.LocalDate;

import br.com.engenharia.projeto.ProjetoFinal.dominio.Cliente;

public record DadosDetalhamentoCliente(

		String nome, LocalDate nascimento)

{

	public DadosDetalhamentoCliente(Cliente cliente) {
		this(cliente.getNome(), cliente.getNascimento());
	}

}
