package br.com.engenharia.projeto.ProjetoFinal.dtos;

import java.time.LocalDate;

import br.com.engenharia.projeto.ProjetoFinal.entidade.Genero;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoCliente(
		
		@NotNull
		Long idCliente,
		
		Genero genero,
		
		String nome,
		
		LocalDate nascimento,
		
		@Valid DadosCadastroEmail email,
		
		@Valid DadosAtualizacaoTelefone telefone
						
		) {
}