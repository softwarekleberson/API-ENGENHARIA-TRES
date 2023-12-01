package br.com.engenharia.projeto.ProjetoFinal.dtos;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoEndereco(
		
		@NotNull
		Long id,
		
		String logradouro,
		String numero,
		String bairro,
		String cep,
		String observacao
		
		) {

}
