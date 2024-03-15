package br.com.engenharia.projeto.ProjetoFinal.dtos;

import br.com.engenharia.projeto.ProjetoFinal.entidade.Cidade;
import br.com.engenharia.projeto.ProjetoFinal.entidade.Cobranca;
import br.com.engenharia.projeto.ProjetoFinal.entidade.Estado;
import br.com.engenharia.projeto.ProjetoFinal.entidade.Pais;
import br.com.engenharia.projeto.ProjetoFinal.entidade.TipoLogradouro;
import br.com.engenharia.projeto.ProjetoFinal.entidade.TipoResidencia;

public record DadosDetalhamentoCobranca(
		
		Long id, String logradouro, String numero,
		String bairro, String cep, String observacao,
		TipoLogradouro tipoLogradouto,
		TipoResidencia tipoResidencia, Cidade cidade,
		Estado estado, Pais pais
		
		
		) {

	public DadosDetalhamentoCobranca(Cobranca cobranca) {
		this(cobranca.getId(), cobranca.getLogradouro(), cobranca.getNumero(),
				cobranca.getBairro(), cobranca.getCep(), cobranca.getObservacao(),
				cobranca.getTipoLogradouro(),
				cobranca.getTipoResidencia(), cobranca.getCidade(),
				cobranca.getCidade().getEstado(), 
				cobranca.getCidade().getEstado().getPais());
	}
}
