package br.com.engenharia.projeto.ProjetoFinal.dtos;

import java.time.LocalDate;

import br.com.engenharia.projeto.ProjetoFinal.dominio.Genero;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroCliente(
		
		Genero genero,
		
		String nome,
		
		LocalDate nascimento,
		
		@NotBlank
		String cpf,
		
		@Valid DadosCadastroEmail email,
		
		@Valid DadosCadstroTelefone telefone,
		
		@Valid DadosCadastroSenha senha,
		
		@Valid DadosCadastroConfirmarSenha confirmarSenha

		
										) 

										{

}
