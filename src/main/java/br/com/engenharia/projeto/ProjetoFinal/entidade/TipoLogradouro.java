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
public class TipoLogradouro {

	private String tipoLogradouro;

	public TipoLogradouro(DadosCadastroEndereco dados) {
		setTipoLogradouro(dados.tipoLogradouro());
	}

	public String getTipoLogradouro() {
		return tipoLogradouro;
	}

	public void setTipoLogradouro(String tipoLogradouro) {
		if(tipoLogradouro == null || tipoLogradouro.trim().length() == 0) {
			throw new IllegalArgumentException("Tipo logradouro não deve ser nulo");
		}
		this.tipoLogradouro = tipoLogradouro;
	}

}