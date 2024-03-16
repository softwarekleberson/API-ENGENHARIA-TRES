package br.com.engenharia.projeto.ProjetoFinal.entidade;

import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosCadastroCobranca;
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
@Table(name = "cobrancas")
public class Cobranca extends Endereco{
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clientes_id")
	private Cliente cliente;
	
	private boolean ativo = true;
	
	public Cobranca(@Valid DadosCadastroCobranca dados) {
		super(dados.endereco());
	}

	public void setCliente(Long clienteId) {
		this.cliente = new Cliente();
		cliente.setId(clienteId);
		System.out.println("cobranca " + this.cliente.getId());
	}
}