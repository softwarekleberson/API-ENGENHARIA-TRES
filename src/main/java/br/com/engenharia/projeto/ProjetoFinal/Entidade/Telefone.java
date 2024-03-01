package br.com.engenharia.projeto.ProjetoFinal.Entidade;

import java.util.Objects;

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

	public static final int VERIFICA_DDD = 2;
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
		String verificaDdd = Objects.requireNonNull(ddd, "Ddd deve conter 2 digitos");
		if(verificaDdd.length() != VERIFICA_DDD) {
			throw new IllegalArgumentException("Ddd deve conter 2 digitos");
		}
		this.ddd = ddd;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(DadosCadstroTelefone dadosCadstroTelefone) {
		String verifica_telefone = dadosCadstroTelefone.telefone();
		if(verifica_telefone.length() != 8 || verifica_telefone.length() != 9) {
			throw new IllegalArgumentException("Telefone deve conter 8 ou 9 digitos");
		}
		
		this.telefone = dadosCadstroTelefone.telefone();
	}
	
	public TipoTelefone getTipoTelefone() {
		return tipoTelefone;
	}
	
	public void setTipoTelefone(DadosCadstroTelefone dadosCadstroTelefone) {
		this.tipoTelefone = dadosCadstroTelefone.tipo();
	}
	
}
