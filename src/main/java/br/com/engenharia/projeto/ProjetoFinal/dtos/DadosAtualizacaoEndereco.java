package br.com.engenharia.projeto.ProjetoFinal.dtos;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoEndereco(
		
		@NotNull
		Long idEndereco,
		
		String tipoResidencia,
		
		String tipoLogradouro,
		
		String logradouro,
		
		String numero,
		
		String bairro,
				
		String cep,
		
		String observacao,

		String cidade,
		
		String estado,
		
		String pais
									) {

}
