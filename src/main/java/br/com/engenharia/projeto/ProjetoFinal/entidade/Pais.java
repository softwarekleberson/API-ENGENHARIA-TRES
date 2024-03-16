package br.com.engenharia.projeto.ProjetoFinal.entidade;

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
		if(dados.pais() == null || dados.pais().trim().length() == 0) {
			throw new IllegalArgumentException("Pais não deve ser nulo");
		}
		this.pais = dados.pais();
	}
	
	public void setPaisUpdate(String pais) {
		if(pais == null || pais.trim().length() == 0) {
			throw new IllegalArgumentException("Pais não deve ser nulo");
		}
		this.pais = pais;
	}
}