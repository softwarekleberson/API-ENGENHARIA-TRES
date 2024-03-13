package br.com.engenharia.projeto.ProjetoFinal.dtos;

import jakarta.validation.Valid;

public record DadosCadastroEntrega(
				
		@Valid DadosCadastroEndereco endereco,
		String fraseEntrega
		
								  ) 
								  {

}
