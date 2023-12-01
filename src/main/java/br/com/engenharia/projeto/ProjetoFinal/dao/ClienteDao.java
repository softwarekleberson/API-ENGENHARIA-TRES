package br.com.engenharia.projeto.ProjetoFinal.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.engenharia.projeto.ProjetoFinal.dominio.Cliente;
import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosAtualizacaoCliente;
import br.com.engenharia.projeto.ProjetoFinal.persistencia.ClienteRepository;

public class ClienteDao implements IdaoCliente {

	@Autowired
	private ClienteRepository repository;

	public ClienteDao(ClienteRepository repository) {
		this.repository = repository;
	}

	@Override
	public String salvar(Cliente entidade) {
		this.repository.save(entidade);
		return null;
	}

	@Override
	public String alterar(Cliente entidade, DadosAtualizacaoCliente dados) {
		if (dados.genero() != null) {
			entidade.setGenero(dados.genero());
		}
		if (dados.email() != null) {
			entidade.setEmail(dados.email());
		}
		if (dados.nome() != null) {
			entidade.setNome(dados.nome());
		}
		if (dados.nascimento() != null) {
			entidade.setNascimento(dados.nascimento());
		}
		if (dados.email() != null) {
			entidade.setEmail(dados.email());
		}
		if (dados.telefone().ddd() != null) {
			entidade.getTelefone().setDdd(dados.telefone().ddd());
			;
		}
		if (dados.telefone().telefone() != null) {
			entidade.getTelefone().setTelefone(dados.telefone());
		}
		if (dados.telefone().tipo() != null) {
			entidade.getTelefone().setTipoTelefone(dados.telefone());
		}
		if (dados.senha() != null) {
			entidade.setSenha(dados.senha());
		}
		return null;
	}

	@Override
	public Optional<Cliente> consultar(Cliente entidade) {
		
		String cpfCliente = entidade.getCpf();
		if(cpfCliente == null) {
			return null;
		}
		
		Optional<Cliente> cpfVerifica = repository.findByCpf(cpfCliente);
		return cpfVerifica;
	}

	@Override
	public String excluir(Cliente entidade) {
		entidade.setAtivo(false);
		return null;
	}

}
