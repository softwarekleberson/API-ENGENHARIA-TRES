package br.com.engenharia.projeto.ProjetoFinal.negocio.cliente.implementacao;

import br.com.engenharia.projeto.ProjetoFinal.Entidade.Cliente;

public class ValidarCliente extends ValidacaoAbstrataCliente{

	public String processar(Cliente dominio) {
						
		if(dominio.getGenero() == null) {
			sb.append("Genero cliente não informado");
		}
		
		if(isNull(dominio.getNome())) {
			sb.append("Nome cliente não informado");
		}
		
		if(!dominio.getCpf().matches("\\d{11}")) {
			sb.append("Cpf deve conter 11 digitos");
		}
		
		if(dominio.getNascimento() == null) {
			sb.append("Nacimento cliente não informado");
		}
		
		if(sb.length() != 0) {
			return sb.toString();
		}
		
		return null;
	}

}
