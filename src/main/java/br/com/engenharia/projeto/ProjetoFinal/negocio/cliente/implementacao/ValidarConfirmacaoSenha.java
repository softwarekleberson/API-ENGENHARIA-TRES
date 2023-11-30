package br.com.engenharia.projeto.ProjetoFinal.negocio.cliente.implementacao;

import br.com.engenharia.projeto.ProjetoFinal.dominio.Cliente;

public class ValidarConfirmacaoSenha extends ValidacaoAbstrataCliente{

	@Override
	public String processar(Cliente dominio) {
		
		if(!dominio.getSenha().matches(dominio.getConfirmarSenha())) {
			sb.append("Confirme a senha Novamente");
			return sb.toString();
		}
		
		 return null;		
	}

}
