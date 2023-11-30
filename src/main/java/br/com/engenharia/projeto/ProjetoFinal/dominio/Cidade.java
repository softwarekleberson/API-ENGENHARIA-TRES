package br.com.engenharia.projeto.ProjetoFinal.dominio;

import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosCadastroEndereco;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Embeddable
public class Cidade {

	private String cidade;
	
	@Embedded
	private Estado estado;
	
	public Cidade(DadosCadastroEndereco dados) {
		setCidade(dados.cidade());
		setEstado(dados);
	}
	
	public Cidade(String cidade, Estado estado) {
		this.cidade = cidade;
		this.estado = estado;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(DadosCadastroEndereco dados) {
		System.out.println(dados.estado());
		this.estado = new Estado(dados);
	}
	
}
