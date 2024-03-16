package br.com.engenharia.projeto.ProjetoFinal.dtos;

import jakarta.validation.Valid;

public record DadosAtualizacaoCobrancas (
		
		@Valid
		DadosAtualizacaoEndereco endereco
		
									  ){
}