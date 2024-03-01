package br.com.engenharia.projeto.ProjetoFinal.Entidade;

import java.util.Objects;

import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosCadastroEndereco;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "entregas")
public class Entrega {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String logradouro;
	private String numero;
	private String bairro;
	private String cep;
	private String observacao;
	private String fraseEntrega;
	
	@Embedded
	private TipoLogradouro tipoLogradouro;
	
	@Embedded
	private TipoResidencia tipoResidencia;
	
	@Embedded
	private Cidade cidade;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clientes_id")
	private Cliente cliente;
	
	private boolean ativo;
	
	public Entrega(@Valid DadosCadastroEndereco dados) {
		setClinte(dados.idCliente());
		setLogradouto(dados.logradouro());
		setNumero(dados.numero());
		setBairro(dados.bairro());
		setCep(dados.cep());
		setObservacao(dados.observacao());
		setFraseEntrega(dados.fraseEntrega());
		setTipoLogradouro(dados);
		setTipoResidencia(dados);
		setCidade(dados);
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
	
	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouto(String logradouro) {
		if(logradouro.isEmpty()) {
			throw new IllegalArgumentException("Logradouro não deve ser nulo");
		}
		
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		if(numero.isEmpty()) {
			throw new IllegalArgumentException("Numero não deve ser nulo");
		}
		
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		if(bairro.isEmpty()) {
			throw new IllegalArgumentException("Bairro não deve ser nulo");
		}
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		String padrao = "\\d{5}|\\d{8}|\\d{9}";
	    if(!cep.matches(padrao)) {
	       throw new IllegalArgumentException("Cep deve conter 5, 8 ou 9 digitos");
	    }
	    
		this.cep = cep;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getFraseEntrega() {
		return fraseEntrega;
	}
	
	public void setFraseEntrega(String fraseEntrega) {
		if(fraseEntrega.isEmpty()) {
			throw new IllegalArgumentException("Frase de entrega não deve ser nulo");
		}
		this.fraseEntrega = fraseEntrega;
	}
	
	public TipoLogradouro getTipoLogradouro() {
		return tipoLogradouro;
	}

	public void setTipoLogradouro(DadosCadastroEndereco dados) {
		this.tipoLogradouro = new TipoLogradouro(dados);
	}

	public TipoResidencia getTipoResidencia() {
		return tipoResidencia;
	}

	public void setTipoResidencia(DadosCadastroEndereco dados) {
		this.tipoResidencia = new TipoResidencia(dados);
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(DadosCadastroEndereco dados) {
		this.cidade = new Cidade(dados);
	}
	
}