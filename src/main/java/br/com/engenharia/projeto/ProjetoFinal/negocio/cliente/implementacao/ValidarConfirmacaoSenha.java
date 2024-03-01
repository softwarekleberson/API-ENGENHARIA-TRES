package br.com.engenharia.projeto.ProjetoFinal.negocio.cliente.implementacao;

import br.com.engenharia.projeto.ProjetoFinal.Entidade.Cliente;

public class ValidarConfirmacaoSenha extends ValidacaoAbstrataCliente{

	@Override
	public String processar(Cliente dominio) {
		
		if(!dominio.getSenha().matches(dominio.getConfirmar_Senha())) {
			sb.append("Confirme a senha Novamente");
			return sb.toString();
		}
		
		 return null;		
	}

}
