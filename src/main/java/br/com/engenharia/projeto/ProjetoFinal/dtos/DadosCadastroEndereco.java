package br.com.engenharia.projeto.ProjetoFinal.dtos;

import jakarta.validation.constraints.NotNull;

public record DadosCadastroEndereco(
		
		@NotNull
		String tipoResidencia,
		
		@NotNull
		String tipoLogradouro,
		
		@NotNull
		String logradouro,
		
		@NotNull
		String numero,
		
		@NotNull
		String bairro,
		
		@NotNull
		String cep,
		
		String observacao,

		@NotNull
		String cidade,
		
		@NotNull
		String estado,
		
		@NotNull
		String pais
		
										) 
										{ 
}
