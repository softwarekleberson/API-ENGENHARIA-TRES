package br.com.engenharia.projeto.ProjetoFinal.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoCobrancas (
		
		@NotNull
		Long idCliente,
		
		@Valid
		DadosAtualizacaoEndereco cobranca
		
									  ){
}
