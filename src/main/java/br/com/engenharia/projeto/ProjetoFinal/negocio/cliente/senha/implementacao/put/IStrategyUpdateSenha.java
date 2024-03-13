package br.com.engenharia.projeto.ProjetoFinal.negocio.cliente.senha.implementacao.put;

import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosAtualizacaoSenha;

public interface IStrategyUpdateSenha {

	String processar(DadosAtualizacaoSenha dados); 
}
