package br.com.engenharia.projeto.ProjetoFinal.dominio;

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
		System.out.println(dados.pais());
		this.pais = dados.pais();
	}

}
