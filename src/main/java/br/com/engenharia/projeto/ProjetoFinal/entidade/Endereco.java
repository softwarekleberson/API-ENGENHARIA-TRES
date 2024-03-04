package br.com.engenharia.projeto.ProjetoFinal.entidade;

import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosCadastroEndereco;
import jakarta.persistence.Embedded;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@MappedSuperclass
public abstract class Endereco {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	
	protected String logradouro;
	protected String numero;
	protected String bairro;
	protected String cep;
	protected String observacao;
		
	@Embedded
	protected TipoLogradouro tipoLogradouro;
	
	@Embedded
	protected TipoResidencia tipoResidencia;
	
	@Embedded
	protected Cidade cidade;
	
	public Endereco(@Valid DadosCadastroEndereco dados) {
		setBairro(dados.bairro());
		setCep(dados.cep());
		setCidade(dados);
		setLogradouro(dados.logradouro());
		setNumero(dados.numero());
		setObservacao(dados.observacao());
		setTipoLogradouro(dados);
		setTipoResidencia(dados);
		
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setLogradouro(String logradouro) {
		if(logradouro == null || logradouro.trim().length() == 0) {
			throw new IllegalArgumentException("Logradouro não deve ser nulo");
		}
		this.logradouro = logradouro;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void setBairro(String bairro) {
		if(bairro == null || bairro.trim().length() == 0) {
			throw new IllegalArgumentException("Bairro não deve ser nulo");
		}
		this.bairro = bairro;
	}

	public void setCep(String cep) {
		String regexCEP = "\\d{8}";
		if(!cep.matches(regexCEP)) {
			throw new IllegalArgumentException("Cep ");
		}
		this.cep = cep;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public void setTipoLogradouro(DadosCadastroEndereco tipoLogradouro) {
		if(tipoLogradouro.tipoLogradouro() == null || tipoLogradouro.tipoLogradouro().trim().length() == 0) {
			throw new IllegalArgumentException("Tipo de logradouro não deve ser nulo");
		}
		this.tipoLogradouro = new TipoLogradouro(tipoLogradouro);
	}

	public void setTipoResidencia(DadosCadastroEndereco tipoResidencia) {
		if(tipoResidencia.tipoResidencia() == null || tipoResidencia.tipoResidencia().trim().length() == 0) {
			throw new IllegalArgumentException("Tipo de residencia não deve ser nulo");

		}
		this.tipoResidencia = new TipoResidencia(tipoResidencia);
	}

	public void setCidade(DadosCadastroEndereco cidade) {
		this.cidade = new Cidade(cidade);
	}
}