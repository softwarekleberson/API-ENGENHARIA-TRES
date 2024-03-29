package br.com.engenharia.projeto.ProjetoFinal.dtos;

import br.com.engenharia.projeto.ProjetoFinal.entidade.Bandeira;
import br.com.engenharia.projeto.ProjetoFinal.entidade.Cartao;

public record DadosDetalhamentoCartao(
		
		Long idCliente,
		Long id,
		String nomeImpresso,
		String codigo,
		Bandeira bandeira
									  ) {

	public DadosDetalhamentoCartao(Cartao dados) {
		this(dados.getCliente().getId(), dados.getId() ,dados.getNomeImpresso(), dados.getCodigo(),
			 dados.getBandeira());
	}
}
