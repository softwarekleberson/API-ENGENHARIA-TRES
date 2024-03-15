package br.com.engenharia.projeto.ProjetoFinal.dtos;

import jakarta.validation.Valid;

public record DadosCadastroCobranca(
		
		@Valid DadosCadastroEndereco endereco
		
									) {
}
