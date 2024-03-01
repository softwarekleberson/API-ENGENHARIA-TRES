package br.com.engenharia.projeto.ProjetoFinal.Entidade;

import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosCadastroEndereco;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Pais {

	private String pais;

	public Pais(DadosCadastroEndereco dados) {
		setPais(dados);
	}
	
	public String getPais() {
		return pais;
	}

	public void setPais(DadosCadastroEndereco dados) {
		if(dados.pais().isEmpty()) {
			throw new IllegalArgumentException("Pais não deve ser nulo");
		}
		
		this.pais = dados.pais();
	}

}
