package br.com.engenharia.projeto.ProjetoFinal.dominio;

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
		this.estado = estado;
	}
	
	public Pais getPais() {
		return pais;
	}
	
	public void setPais(DadosCadastroEndereco dados) {
		this.pais = new Pais(dados);
	}
	
}
