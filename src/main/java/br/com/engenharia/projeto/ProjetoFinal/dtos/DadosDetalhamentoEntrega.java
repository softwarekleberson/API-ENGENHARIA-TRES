package br.com.engenharia.projeto.ProjetoFinal.dtos;

import br.com.engenharia.projeto.ProjetoFinal.entidade.Cidade;
import br.com.engenharia.projeto.ProjetoFinal.entidade.Entrega;

public record DadosDetalhamentoEntrega(
		
		Long id,
		Long idCliente,
		String numero,
		String bairro,
		String cep,
		String observacao,
		Cidade cidade
		
		) {

	public DadosDetalhamentoEntrega(Entrega dados) {
		this(dados.getId(),dados.getCliente().getId(), dados.getNumero(), dados.getBairro(),
			 dados.getCep(), dados.getObservacao(),
			 dados.getCidade());
	}
}
