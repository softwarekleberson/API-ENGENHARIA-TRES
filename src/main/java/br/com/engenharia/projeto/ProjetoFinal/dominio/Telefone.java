package br.com.engenharia.projeto.ProjetoFinal.dominio;

import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosCadstroTelefone;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Telefone {

	private String ddd;
	private String telefone;
	
	@Enumerated(EnumType.STRING)
	private TipoTelefone tipoTelefone;
	
	public Telefone(DadosCadstroTelefone dados) {
		setDdd(dados.ddd());
		setTelefone(dados);
		setTipoTelefone(dados);
	}

	public String getDdd() {
		return ddd;
	}
	
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(DadosCadstroTelefone dadosCadstroTelefone) {
		this.telefone = dadosCadstroTelefone.telefone();
	}
	
	public TipoTelefone getTipoTelefone() {
		return tipoTelefone;
	}
	
	public void setTipoTelefone(DadosCadstroTelefone dadosCadstroTelefone) {
		this.tipoTelefone = dadosCadstroTelefone.tipo();
	}
	
}
