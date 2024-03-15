package br.com.engenharia.projeto.ProjetoFinal.dtos;

import jakarta.validation.Valid;

public record DadosAtualizacaoEntregas (
		
		@Valid
		DadosAtualizacaoEndereco entrega,
		
		String fraseEntrega
									  ){
}
