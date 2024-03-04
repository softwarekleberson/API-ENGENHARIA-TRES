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
public class TipoResidencia {

	private String tipoResidencia;

	public TipoResidencia(DadosCadastroEndereco dados) {
		setTipoResidencia(dados.tipoResidencia());
	}

	public String getTipoResidencia() {
		return tipoResidencia;
	}

	public void setTipoResidencia(String tipoResidencia) {
		if(tipoResidencia == null || tipoResidencia.trim().length() == 0) {
			throw new IllegalArgumentException("Tipo residencia não deve ser nulo");
		}
		this.tipoResidencia = tipoResidencia;
	}
}