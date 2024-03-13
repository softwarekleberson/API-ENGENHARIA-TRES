package br.com.engenharia.projeto.ProjetoFinal.entidade;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosAtualizacaoSenha;
import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosCadastroCliente;
import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosCadastroConfirmarSenha;
import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosCadastroEmail;
import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosCadastroEndereco;
import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosCadastroEntrega;
import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosCadastroSenha;
import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosCadastroTelefone;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity(name = "Cliente")
@Table(name = "clientes")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cliente {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	public static final int VERIFICA_NOME = 2;
	private String nome;
	
	public static final int VERICA_CPF = 11;
	private String cpf;
	
	private LocalDate nascimento;
	private String senha;
    private Boolean ativo;

    @Transient
    private String confirmar_Senha;

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
		
		setAtivo(true);
		setNome(dados.nome());
		setCpf(dados.cpf());
		setGenero(dados.genero());
		setNascimento(dados.nascimento());
		setSenha(dados.senha());
		setConfirmar_Senha(dados.confirmarSenha());
		setTelefone(dados.telefone());
		setEmail(dados.email());
		setEntrega(dados.entrega());
		setCobranca(dados.cobranca());
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getAtivo() {
		return ativo;
	}
	
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if(nome == null || nome.trim().length() <= VERIFICA_NOME) {
			throw new IllegalArgumentException("Nome deve possuir mais de 2 digitos");
		}
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		if(cpf == null || cpf.trim().length() != VERICA_CPF) {
			throw new IllegalArgumentException("Cpf deve conter apenas numeros");
		}
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
	
	public String getConfirmarSenha() {
		return confirmar_Senha;
	}

	public void setTelefone(DadosCadastroTelefone dados) {
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
	
	public void setSenha(DadosAtualizacaoSenha dados) {
		this.senha = dados.senha();
	}
	
	public void setConfirmar_Senha(DadosCadastroConfirmarSenha senha) {
		this.confirmar_Senha = senha.confirmarSenha();
	}
	
	public void CriptografarSenha(String senhaCriptografada) {
		System.out.println(senhaCriptografada);
		this.senha = senhaCriptografada;
	}
	
	public String devolveSenhaCriptografada() {
		return this.senha;
	}

	public void setConfirmar_Senha(String confirmar_Senha) {
		this.confirmar_Senha = confirmar_Senha;
	}
	
	public void setEmail(DadosCadastroEmail dados) {
		this.email = new Email(dados);
	}

	public Set<Entrega> getEntrega() {
		return entrega;
	}

	public void setEntrega(Set<DadosCadastroEntrega> entregas) {
	    this.entrega = entregas.stream()
	                            .map(entrega -> new Entrega(entrega)) // Convertendo DadosCadastroEntrega para Entrega
	                            .collect(Collectors.toSet());
	}

	public Set<Cobranca> getCobranca() {
		return cobranca;
	}

	public void setCobranca(Set<DadosCadastroEndereco> cobrancas) {
	    this.cobranca = cobrancas.stream()
	                              .map(cobranca -> new Cobranca(cobranca)) // Convertendo DadosCadastroEndereco para Cobranca
	                              .collect(Collectors.toSet());
	}

	public void excluir() {
		this.ativo = false;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", nascimento=" + nascimento + ", senha="
				+ senha + ", ativo=" + ativo + ", confirmar_Senha=" + confirmar_Senha + ", genero=" + genero
				+ ", telefone=" + telefone + ", cartoes=" + cartoes + ", email=" + email + ", entrega=" + entrega
				+ ", cobranca=" + cobranca + "]";
	}
}