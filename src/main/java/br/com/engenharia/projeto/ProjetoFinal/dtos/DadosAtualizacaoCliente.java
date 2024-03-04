package br.com.engenharia.projeto.ProjetoFinal.dtos;


import java.time.LocalDate;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoCliente(
		
		@NotNull
		Long idCliente,
		
		Generated genero,
		
		String nome,
		
		LocalDate nascimento,
		
		@Valid DadosCadastroEmail email,
		
		@Valid DadosCadastroTelefone telefone,
		
		@Valid DadosCadastroSenha senha
		
		) {

}
