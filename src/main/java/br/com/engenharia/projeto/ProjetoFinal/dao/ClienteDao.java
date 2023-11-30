package br.com.engenharia.projeto.ProjetoFinal.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.engenharia.projeto.ProjetoFinal.dominio.Cliente;
import br.com.engenharia.projeto.ProjetoFinal.persistencia.ClienteRepository;

public class ClienteDao implements IdaoCliente{

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
	public String alterar(Cliente entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> consultar(Cliente entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean inativar(Cliente entidade) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String alterarEndercoCobranca(Cliente entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String alterarEndercoEntrega(Cliente entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String excluir(Cliente entidade) {
		// TODO Auto-generated method stub
		return null;
	}

}
