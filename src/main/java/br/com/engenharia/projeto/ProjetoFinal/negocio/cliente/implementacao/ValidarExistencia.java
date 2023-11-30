package br.com.engenharia.projeto.ProjetoFinal.negocio.cliente.implementacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.engenharia.projeto.ProjetoFinal.dao.ClienteDao;
import br.com.engenharia.projeto.ProjetoFinal.dominio.Cliente;
import br.com.engenharia.projeto.ProjetoFinal.persistencia.ClienteRepository;

public class ValidarExistencia implements IStrategyCliente{

	@Autowired
	private ClienteRepository repository;
	
	public ValidarExistencia(ClienteRepository repository) {
		this.repository = repository;
	}
	
	public String processar(Cliente dominio) {
		
		ClienteDao clienteDao = new ClienteDao(repository);
		List<Cliente> cliente = clienteDao.consultar(dominio);
		
		if(!cliente.isEmpty()) {
			return "Cliente cadastrado";
		}
		
		return null;
	}

}
