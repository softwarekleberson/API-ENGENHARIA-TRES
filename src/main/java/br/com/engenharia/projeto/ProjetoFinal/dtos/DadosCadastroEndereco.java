package br.com.engenharia.projeto.ProjetoFinal.dtos;

import jakarta.validation.constraints.NotNull;

public record DadosCadastroEndereco(
		
		@NotNull
		Long idCliente,
		
		String tipoResidencia,
		
		String tipoLogradouro,
		
		String logradouro,
		
		String numero,
		
		String bairro,
		
		String cep,
		
		String observacao,
		
		String fraseEntrega,
		
		String cidade,
		
		String estado,
		
		String pais
		
										) 
														{
}
