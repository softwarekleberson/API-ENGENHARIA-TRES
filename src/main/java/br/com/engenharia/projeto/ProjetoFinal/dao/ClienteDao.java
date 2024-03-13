package br.com.engenharia.projeto.ProjetoFinal.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosAtualizacaoCliente;
import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosDetalhamentoCliente;
import br.com.engenharia.projeto.ProjetoFinal.entidade.Cliente;
import br.com.engenharia.projeto.ProjetoFinal.persistencia.ClienteRepository;

@Service
public class ClienteDao implements IdaoCliente {

	@Autowired
	private ClienteRepository repository;

	public ClienteDao(ClienteRepository repository) {
		this.repository = repository;
	}

	@Override
	public void salvar(Cliente entidade) {
		System.out.println("ppppp" + entidade);
		this.repository.save(entidade);
	}

	@Override
	public void alterarCliente(Long id, DadosAtualizacaoCliente dados) {
		Optional<Cliente> opDataBaseCliente = repository.findById(id);
		
		if(opDataBaseCliente.isPresent()) {
			Cliente clienteUpdate = opDataBaseCliente.get();
			
			if(dados.nome() != null) {
				clienteUpdate.setNome(dados.nome());
			}
			
			if(dados.genero() != null) {
				clienteUpdate.setGenero(dados.genero());
			}
			
			if(dados.nascimento() != null) {
				clienteUpdate.setNascimento(dados.nascimento());
			}
			
			if(dados.email() != null) {
				clienteUpdate.setEmail(dados.email());
			}
			
			if(dados.telefone().ddd() != null) { 
				clienteUpdate.getTelefone().setDdd(dados.telefone().ddd());
			}
			
			if(dados.telefone().telefone() != null) {
				clienteUpdate.getTelefone().setTelefone(dados.telefone());
			}
			
			if(dados.telefone().tipo() != null) {
				clienteUpdate.getTelefone().setTipoTelefone(dados.telefone());
			}
		}
	}
	
	@Override
	public void alterarSenha(Long id, String senhaCriptografada) {
		Optional<Cliente> opDataBaseSenha = repository.findById(id);
		
		if(opDataBaseSenha.isPresent()) {
			Cliente clienteUpdate = opDataBaseSenha.get();
			clienteUpdate.CriptografarSenha(senhaCriptografada);
		}
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
	public Page pegaTodosClientes(Pageable paginacao) {
		return repository.findAll(paginacao).map(DadosDetalhamentoCliente::new);
	}
	
	@Override
	public void deletar(Long id) {
		Optional<Cliente> cliente = repository.findById(id);
		if(cliente.isPresent()) {
			repository.deleteById(id);;
		}
	}
}