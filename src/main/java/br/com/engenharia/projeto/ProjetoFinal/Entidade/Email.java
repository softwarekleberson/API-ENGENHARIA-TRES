package br.com.engenharia.projeto.ProjetoFinal.Entidade;

import java.util.regex.Pattern;

import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosCadastroEmail;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
public class Email {

	private String email;
	
	public Email(DadosCadastroEmail dados) {
		setEmail(dados.email());
	}
	
	public Email(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
	      if (!Pattern.matches(regex, email)) {
	    	  throw new IllegalArgumentException("O endereço de e-mail fornecido"
	    	  								   + " é inválido. Por favor, verifique"
	    	  								   + " e tente novamente.");
	      }
	      
		this.email = email;
	}
	
}