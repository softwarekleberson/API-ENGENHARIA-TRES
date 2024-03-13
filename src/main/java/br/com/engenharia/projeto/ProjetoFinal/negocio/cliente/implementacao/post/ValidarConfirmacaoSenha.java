package br.com.engenharia.projeto.ProjetoFinal.negocio.cliente.implementacao.post;

import org.springframework.stereotype.Service;
import br.com.engenharia.projeto.ProjetoFinal.entidade.Cliente;

@Service
public class ValidarConfirmacaoSenha implements IStrategyCliente{

	@Override
	public String processar(Cliente dominio) {
		
		if(!dominio.getSenha().matches(dominio.getConfirmar_Senha())) {
			throw new IllegalArgumentException("primeira senha não corresponde a confirmar senha");
		}
		
		 return null;		
	}
}