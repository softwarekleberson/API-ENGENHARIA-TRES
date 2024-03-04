package br.com.engenharia.projeto.ProjetoFinal.dtos;

import br.com.engenharia.projeto.ProjetoFinal.entidade.TipoTelefone;

public record DadosCadastroTelefone(
		
		String ddd,
		String telefone,
		TipoTelefone tipo
		
								)
									{

}
