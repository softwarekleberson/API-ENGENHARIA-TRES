package br.com.engenharia.projeto.ProjetoFinal.negocio.cliente.implementacao;

import br.com.engenharia.projeto.ProjetoFinal.Entidade.Cliente;
import br.com.engenharia.projeto.ProjetoFinal.Entidade.Telefone;

public class ValidarTelefone extends ValidacaoAbstrataCliente{

	public String processar(Cliente dominio) {
		
		if(dominio.getTelefone().getTelefone().trim().toLowerCase() == null) {
			sb.append("Necessario ao menos 1 telefone");
		}
		
		else {
			Telefone tel = dominio.getTelefone();
			if(tel.getDdd().trim().length() != 2) {
				System.out.println("ddd invalido");
				sb.append("Ddd incorreto");
			}
			
			if(tel.getTelefone().trim().length() != 9) {
				System.out.println("telefone invalido");
				sb.append("telefone deve conter 9 digitos");
			}
			
			if(isNull(tel.getTipoTelefone())) {
				sb.append("Tipo telefone é obrigatiorio");
			}		
		}
	
		if(sb.length() != 0) {
			return sb.toString();
		}
		
		return null;
	}

}
