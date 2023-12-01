package br.com.engenharia.projeto.ProjetoFinal.negocio.cliente.implementacao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import br.com.engenharia.projeto.ProjetoFinal.dao.ClienteDao;
import br.com.engenharia.projeto.ProjetoFinal.dominio.Cliente;
import br.com.engenharia.projeto.ProjetoFinal.persistencia.ClienteRepository;

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
			sb.append("cliente cadastrado anteriormente");
			return sb.toString();
		}
		
		return null;
	}

}
