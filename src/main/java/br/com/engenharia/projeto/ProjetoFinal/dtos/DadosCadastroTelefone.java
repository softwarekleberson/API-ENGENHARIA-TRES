package br.com.engenharia.projeto.ProjetoFinal.dtos;

import br.com.engenharia.projeto.ProjetoFinal.Entidade.TipoTelefone;

public record DadosCadstroTelefone(
		
		String ddd,
		String telefone,
		TipoTelefone tipo
		
								)
									{

}
