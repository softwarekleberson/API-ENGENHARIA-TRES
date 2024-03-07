package br.com.engenharia.projeto.ProjetoFinal.entidade;

import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosCadastroEntrega;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode
@Table(name = "entregas")
public class Entrega extends Endereco{

	private String fraseEntrega;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clientes_id")
	private Cliente cliente;
	
	private boolean ativo;
	
	public Entrega(@Valid DadosCadastroEntrega dados) {
		super(dados.endereco());
		setFraseEntrega(dados.fraseEntrega());
		setAtivo(true);
	}

	public void setClinte(Long idCliente) {
		this.cliente = new Cliente();
		cliente.setId(idCliente);
	}
	
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	public boolean isAtivo() {
		return ativo;
	}
	
	public void setFraseEntrega(String fraseEntrega) {
		if(fraseEntrega == null || fraseEntrega.trim().length() == 0) {
			throw new IllegalArgumentException("Frase de entrega não deve ser nulo");
		}
		this.fraseEntrega = fraseEntrega;
	}
}