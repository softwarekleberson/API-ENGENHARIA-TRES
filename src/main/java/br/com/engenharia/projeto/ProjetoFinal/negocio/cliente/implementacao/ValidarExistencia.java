package br.com.engenharia.projeto.ProjetoFinal.negocio.cliente.implementacao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
		
		System.out.println("Validar Existencia");
		Optional<Cliente> cliente = repository.findByCpf(dominio.getCpf());
		
		if(!cliente.isEmpty()) {
			throw new IllegalArgumentException("Cpf cadastrado anteriormente");
		}
		
		return null;
	}
}