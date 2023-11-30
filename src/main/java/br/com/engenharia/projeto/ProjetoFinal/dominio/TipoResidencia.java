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
public class TipoResidencia {

	private String tipoResidencia;

	public TipoResidencia(DadosCadastroEndereco dados) {
		setTipoResidencia(dados.tipoResidencia());
	}

	public String getTipoResidencia() {
		return tipoResidencia;
	}

	public void setTipoResidencia(String tipoResidencia) {
		this.tipoResidencia = tipoResidencia;
	}

}
