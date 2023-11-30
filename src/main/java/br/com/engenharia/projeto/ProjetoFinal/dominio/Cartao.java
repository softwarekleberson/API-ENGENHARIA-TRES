package br.com.engenharia.projeto.ProjetoFinal.dominio;

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
	private String codigo;
	private String numeroCartao;
	
	@Enumerated(EnumType.STRING)
	private Bandeira bandeira;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clientes_id")
	private Cliente cliente;
	
	public Cartao(@Valid DadosCadastroCartao dados) {
		setPrincipal(dados.principal());
		setBandeira(dados.bandeira());
		setCodigo(dados.codigo());
		setNomeImpresso(dados.nomeImpresso());
		setNumeroCartao(dados.numeroCartao());
		setCliente(dados.idCliente());
	}

	
	public void setCliente(Long idClinte) {
		this.cliente = new Cliente();
		cliente.setId(idClinte);
	}
	
	public boolean isPrincipal() {
		return principal;
	}
	
	public void setPrincipal(boolean principal) {
		System.out.println(principal);
		this.principal = principal;
	}
	
	public String getNomeImpresso() {
		return nomeImpresso;
	}
	
	public void setNomeImpresso(String nomeImpresso) {
		this.nomeImpresso = nomeImpresso;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public Bandeira getBandeira() {
		return bandeira;
	}
	
	public void setBandeira(Bandeira bandeira) {
		System.out.println(bandeira);
		this.bandeira = bandeira;
	}
	
	public String getNumeroCartao() {
		return numeroCartao;
	}
	
	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}
	
}

