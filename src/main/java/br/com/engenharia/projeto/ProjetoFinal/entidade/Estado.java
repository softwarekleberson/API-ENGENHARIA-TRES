package br.com.engenharia.projeto.ProjetoFinal.entidade;

import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosCadastroEndereco;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Estado{

	private String estado;
	
	@Embedded
	private Pais pais;
	
	public Estado(DadosCadastroEndereco dados) {
		setEstado(dados.estado());
		setPais(dados);
	}
	
	public String getNome() {
		return estado;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		if(estado == null || estado.trim().length() == 0) {
			throw new IllegalArgumentException("Estado não deve ser nulo");
		}
		this.estado = estado;
	}
	
	public Pais getPais() {
		return pais;
	}
	
	public void setPais(DadosCadastroEndereco dados) {
		if(dados.pais() == null || dados.pais().trim().length() == 0) {
			throw new IllegalArgumentException("Pais não deve ser nulo");
		}
		this.pais = new Pais(dados);
	}

	public void setPais(String pais) {
		this.pais = new Pais(pais);
	}	
}