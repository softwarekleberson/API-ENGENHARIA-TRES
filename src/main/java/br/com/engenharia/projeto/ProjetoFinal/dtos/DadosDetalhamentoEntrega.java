package br.com.engenharia.projeto.ProjetoFinal.dtos;

import br.com.engenharia.projeto.ProjetoFinal.entidade.Cidade;
import br.com.engenharia.projeto.ProjetoFinal.entidade.Entrega;
import br.com.engenharia.projeto.ProjetoFinal.entidade.Estado;
import br.com.engenharia.projeto.ProjetoFinal.entidade.Pais;
import br.com.engenharia.projeto.ProjetoFinal.entidade.TipoLogradouro;
import br.com.engenharia.projeto.ProjetoFinal.entidade.TipoResidencia;

public record DadosDetalhamentoEntrega(
		
		Long id, String logradouro, String numero,
		String bairro, String cep, String observacao,
		String fraseEntrega, TipoLogradouro tipoLogradouto,
		TipoResidencia tipoResidencia, Cidade cidade,
		Estado estado, Pais pais
		
									  				) 
{
	
	public DadosDetalhamentoEntrega(Entrega entrega) {
		this(entrega.getId(), entrega.getLogradouro(), entrega.getNumero(),
				entrega.getBairro(), entrega.getCep(), entrega.getObservacao(),
				entrega.getFraseEntrega(), entrega.getTipoLogradouro(),
				entrega.getTipoResidencia(), entrega.getCidade(),
				entrega.getCidade().getEstado(), 
				entrega.getCidade().getEstado().getPais());
	}
}