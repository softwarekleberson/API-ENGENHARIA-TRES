package br.com.engenharia.projeto.ProjetoFinal.dtos;

import br.com.engenharia.projeto.ProjetoFinal.entidade.TipoTelefone;

public record DadosAtualizacaoTelefone(
		
		String ddd,
		String telefone,
		TipoTelefone tipo
		
								)
									{

}
