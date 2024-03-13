package br.com.engenharia.projeto.ProjetoFinal.negocio.cliente.senha.implementacao.put;

import org.springframework.stereotype.Service;

import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosAtualizacaoSenha;

@Service
public class ValidarConfirmacaoSenhaUpdate implements IStrategyUpdateSenha{

	@Override
	public String processar(DadosAtualizacaoSenha dados) {
		
		if(!dados.senha().matches(dados.confirmarSenha().confirmarSenha())) {
			throw new IllegalArgumentException("primeira senha não corresponde a confirmar senha");
		}
		
		 return null;		
	}
}