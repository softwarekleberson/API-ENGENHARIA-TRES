package br.com.engenharia.projeto.ProjetoFinal.entidade;

import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosCadastroCobranca;
import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosCadastroEndereco;
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
	
	private boolean ativo;
	
	public Cobranca(@Valid DadosCadastroCobranca dados) {
		super(dados.endereco());
		setAtivo(true);
	}

	public void setClinte(Long idCliente) {
		this.cliente = new Cliente();
		cliente.setId(idCliente);
	}
	
	public void setAtivo(boolean ativo) {
		System.out.println("ativo cobranca");
		this.ativo = ativo;
	}

	public void setTipoLogradouro(String tipoLogradouro) {
		this.tipoLogradouro = new TipoLogradouro();
		this.tipoLogradouro.setTipoLogradouro(tipoLogradouro);
	}

	public void setTipoResidencia(String tipoResidencia) {
		this.tipoResidencia = new TipoResidencia();
		this.tipoResidencia.setTipoResidencia(tipoResidencia);
	}

	public void setCidade(String cidade) {
		this.cidade = new Cidade();
		this.cidade.setCidade(cidade);
	}

	public void setEstado(String estado) {
		this.cidade = new Cidade();
		this.cidade.setEstado(estado);
	}
}