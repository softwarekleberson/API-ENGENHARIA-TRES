package br.com.engenharia.projeto.ProjetoFinal.negocio.cliente.implementacao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.engenharia.projeto.ProjetoFinal.Entidade.Cliente;

public class ValidarSenha extends ValidacaoAbstrataCliente{

	public String processar(Cliente dominio) {
				
		if(dominio.getSenha().trim().length() < 8) {
			sb.append("Deve conter no minimo 8 caracteres");
			System.out.println("Deve conter no minimo 8 caracteres");
		}
		
		String pattern = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\",.<>?]).*$";
	    Pattern regex = Pattern.compile(pattern);
	    Matcher matcher = regex.matcher(dominio.getSenha());
		
	    if (!matcher.matches()) {
            sb.append("Senha não aceita");
            System.out.println("Senha não aceita");
        } 
	    
	    if(sb.length() != 0) {
			return sb.toString();
		}
		
		return null;
	}

}
