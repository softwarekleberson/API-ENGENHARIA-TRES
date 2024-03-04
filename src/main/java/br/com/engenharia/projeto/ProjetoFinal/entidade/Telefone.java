package br.com.engenharia.projeto.ProjetoFinal.entidade;

import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosCadastroTelefone;
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
	
	public Telefone(DadosCadastroTelefone dados) {
		setDdd(dados.ddd());
		setTelefone(dados);
		setTipoTelefone(dados);
	}

	public String getDdd() {
		return ddd;
	}
	
	public void setDdd(String ddd) {
		String regexDDD = "\\d{2}";
		if(!ddd.matches(regexDDD)) {
			throw new IllegalArgumentException("Ddd deve posusir 2 digitos");
		}
		this.ddd = ddd;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(DadosCadastroTelefone dadosCadstroTelefone) {
        String regexTelefone = "\\d{8,9}";
        if(!dadosCadstroTelefone.telefone().matches(regexTelefone)) {
        	throw new IllegalArgumentException("Telefone deve conter 8 ou 9 digitos");
        }
		this.telefone = dadosCadstroTelefone.telefone();
	}
	
	public TipoTelefone getTipoTelefone() {
		return tipoTelefone;
	}
	
	public void setTipoTelefone(DadosCadastroTelefone dadosCadstroTelefone) {
		this.tipoTelefone = dadosCadstroTelefone.tipo();
	}
	
}