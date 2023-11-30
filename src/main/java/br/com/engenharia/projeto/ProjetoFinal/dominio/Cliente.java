package br.com.engenharia.projeto.ProjetoFinal.dominio;

import java.time.LocalDate;
import java.util.Set;

import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosCadastroCliente;
import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosCadastroConfirmarSenha;
import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosCadastroEmail;
import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosCadastroSenha;
import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosCadstroTelefone;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Cliente")
@Table(name = "clientes")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cliente {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String nome;
	private String cpf;
	private LocalDate nascimento;
	private String senha;
	
	@Column(nullable = true, insertable = false, updatable = false)
	private String confirmarSenha;

	@Enumerated(EnumType.STRING)
	private Genero genero;

	@Embedded
	private Telefone telefone;

	@OneToMany(mappedBy = "cliente")
	private Set<Cartao> cartoes;

	@Embedded
	private Email email;

	@OneToMany(mappedBy = "cliente")
	private Set<Entrega> entrega;

	@OneToMany(mappedBy = "cliente")
	private Set<Cobranca> cobranca;

	public Cliente(@Valid DadosCadastroCliente dados) {
		
		setNome(dados.nome());
		setCpf(dados.cpf());
		setGenero(dados.genero());
		setNascimento(dados.nascimento());
		setSenha(dados.senha());
		setConfirmarSenha(dados.confirmarSenha());
		setTelefone(dados.telefone());
		setEmail(dados.email());
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getNascimento() {
		return nascimento;
	}

	public void setNascimento(LocalDate nacimento) {
		this.nascimento = nacimento;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(DadosCadstroTelefone dados) {
		this.telefone = new Telefone(dados);
	}
	
	public Set<Cartao> getCartoes() {
		return cartoes;
	}

	public void setCartoes(Set<Cartao> cartoes) {
		this.cartoes = cartoes;
	}

	public Email getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(DadosCadastroSenha dados) {
		this.senha = dados.senha();
	}
	
	public void setConfirmarSenha(DadosCadastroConfirmarSenha senha) {
		this.confirmarSenha = senha.confirmarSenha();
	}
	
	public void CriptografarSenha(String senhaCriptografada) {
		this.senha = senhaCriptografada;
	}

	public String getConfirmarSenha() {
		return confirmarSenha;
	}
	
	public void setEmail(DadosCadastroEmail dados) {
		this.email = new Email(dados);
	}

	public Set<Entrega> getEntrega() {
		return entrega;
	}

	public void setEntrega(Set<Entrega> entrega) {
		this.entrega = entrega;
	}

	public Set<Cobranca> getCobranca() {
		return cobranca;
	}

	public void setCobranca(Set<Cobranca> cobranca) {
		this.cobranca = cobranca;
	}
	
}
