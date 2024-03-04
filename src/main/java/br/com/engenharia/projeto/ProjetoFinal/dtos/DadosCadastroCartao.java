package br.com.engenharia.projeto.ProjetoFinal.dtos;

import br.com.engenharia.projeto.ProjetoFinal.entidade.Bandeira;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroCartao(
		
		@NotNull
		Long idCliente,
		
		boolean principal,
		
		String numeroCartao,
		
		String nomeImpresso,
		
		String codigo,
		
		Bandeira bandeira
		
									)

									{
}
