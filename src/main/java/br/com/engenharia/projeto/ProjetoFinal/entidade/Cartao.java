package br.com.engenharia.projeto.ProjetoFinal.entidade;

import java.util.Objects;

import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosCadastroCartao;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "cartoes")
public class Cartao {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private boolean principal = false;
	
	private String nomeImpresso;
	
	public static final int CODIGO_CARTAO_CREDITO = 3;
	private String codigo;
	
	public static final int NUMERO_CARTAO_CARTAO = 16;
	private String numeroCartao;
	
	@Enumerated(EnumType.STRING)
	private Bandeira bandeira;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clientes_id")
	private Cliente cliente;
	private boolean ativo;
	
	public Cartao(@Valid DadosCadastroCartao dados) {
		setPrincipal(dados.principal());
		setBandeira(dados.bandeira());
		setCodigo(dados.codigo());
		setNomeImpresso(dados.nomeImpresso());
		setNumeroCartao(dados.numeroCartao());
		setCliente(dados.idCliente());
		setAtivo(true);
	}

	public boolean isAtivo() {
		return ativo;
	}
	
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	public void setCliente(Long idClinte) {
		this.cliente = new Cliente();
		cliente.setId(idClinte);
	}
	
	public boolean isPrincipal() {
		return principal;
	}
	
	public void setPrincipal(boolean principal) {
		this.principal = principal;
	}
	
	public String getNomeImpresso() {
		return nomeImpresso;
	}
	
	public void setNomeImpresso(String nomeImpresso) {
		if(nomeImpresso == null || nomeImpresso.trim().isEmpty()) {
			throw new IllegalArgumentException("Nome deve possuir mais de 2 digitos");
		}
		this.nomeImpresso = nomeImpresso;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		if(codigo == null || codigo.trim().length() != CODIGO_CARTAO_CREDITO) {
			throw new IllegalArgumentException("Codigo do cartão deve ter 3 digitos");
		}
		this.codigo = codigo;
	}
	
	public Bandeira getBandeira() {
		return bandeira;
	}
	
	public void setBandeira(Bandeira bandeira) {
		this.bandeira = bandeira;
	}
	
	public String getNumeroCartao() {
		return numeroCartao;
	}
	
	public void setNumeroCartao(String numeroCartao) {
		if(numeroCartao == null || numeroCartao.trim().length() != NUMERO_CARTAO_CARTAO) {
			throw new IllegalArgumentException("Codigo do cartão deve possuir 16 digitos");
		}
		this.numeroCartao = numeroCartao;
	}
}