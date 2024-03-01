package br.com.engenharia.projeto.ProjetoFinal.negocio.cliente.implementacao;

import br.com.engenharia.projeto.ProjetoFinal.Entidade.Cliente;

public class ValidarEmail extends ValidacaoAbstrataCliente{
	
	public String processar(Cliente dominio) {
		
		if(!dominio.getEmail()
		  .getEmail().
		  matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")) {
			
			sb.append("Email deve ser valido");
		}
		
		if(sb.length() != 0) {
			return sb.toString();
		}
		
		return null;
	}

}
