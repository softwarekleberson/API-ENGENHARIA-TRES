package br.com.engenharia.projeto.ProjetoFinal.negocio.cliente.implementacao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.engenharia.projeto.ProjetoFinal.dao.ClienteDao;
import br.com.engenharia.projeto.ProjetoFinal.entidade.Cliente;
import br.com.engenharia.projeto.ProjetoFinal.persistencia.ClienteRepository;

@Service
public class ValidarExistencia extends ValidacaoAbstrataCliente{

	@Autowired
	private ClienteRepository repository;
	
	public ValidarExistencia(ClienteRepository repository) {
		this.repository = repository;
	}
	
	public String processar(Cliente dominio) {
		
		ClienteDao clienteDao = new ClienteDao(repository);
		Optional<Cliente> cliente = clienteDao.consultar(dominio);
		
		if(!cliente.isEmpty()) {
			throw new IllegalArgumentException("Cpf cadastrado anteriormente");
		}
		
		return null;
	}
}