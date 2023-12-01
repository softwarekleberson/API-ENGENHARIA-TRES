package br.com.engenharia.projeto.ProjetoFinal.dtos;

import br.com.engenharia.projeto.ProjetoFinal.dominio.Cidade;
import br.com.engenharia.projeto.ProjetoFinal.dominio.Cobranca;

public record DadosDetalhamentoCobranca(
		
		Long id,
		String numero,
		String bairro,
		String cep,
		String observacao,
		Cidade cidade
		
		) {

	public DadosDetalhamentoCobranca(Cobranca dados) {
		this(dados.getCliente().getId(), dados.getNumero(), dados.getBairro(),
			 dados.getCep(), dados.getObservacao(),
			 dados.getCidade());
	}
}
