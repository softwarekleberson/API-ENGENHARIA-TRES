package br.com.engenharia.projeto.ProjetoFinal.dtos;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoCartao(
		
		@NotNull
		Long idCliente,
		
		@NotNull
		Long idCartao,
		
		String nomeImpresso,
		String codigo
			
									) {

}