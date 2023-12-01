package br.com.engenharia.projeto.ProjetoFinal.dtos;

import br.com.engenharia.projeto.ProjetoFinal.dominio.Cidade;
import br.com.engenharia.projeto.ProjetoFinal.dominio.Cobranca;
import br.com.engenharia.projeto.ProjetoFinal.dominio.Entrega;

public record DadosDetalhamentoEntrega(
		
		Long id,
		String numero,
		String bairro,
		String cep,
		String observacao,
		Cidade cidade
		
		) {

	public DadosDetalhamentoEntrega(Entrega dados) {
		this(dados.getCliente().getId(), dados.getNumero(), dados.getBairro(),
			 dados.getCep(), dados.getObservacao(),
			 dados.getCidade());
	}
}
