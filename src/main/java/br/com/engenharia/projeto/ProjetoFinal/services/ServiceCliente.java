package br.com.engenharia.projeto.ProjetoFinal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.engenharia.projeto.ProjetoFinal.dao.ClienteDao;
import br.com.engenharia.projeto.ProjetoFinal.dao.LogDao;
import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosCadastroCliente;
import br.com.engenharia.projeto.ProjetoFinal.dtos.DetalharCliente;
import br.com.engenharia.projeto.ProjetoFinal.entidade.Cliente;
import br.com.engenharia.projeto.ProjetoFinal.entidade.Log;
import br.com.engenharia.projeto.ProjetoFinal.infra.TratadorErros.ValidacaoExcepetion;
import br.com.engenharia.projeto.ProjetoFinal.negocio.cliente.implementacao.IStrategyCliente;
import jakarta.validation.Valid;

@Service
public class ServiceCliente {

	@Autowired
	private ClienteDao daoCliente;
	
	@Autowired
	private LogDao daoLog;
	
	@Autowired
	private List<IStrategyCliente> validadores;
	
	public DetalharCliente criar(@Valid DadosCadastroCliente dados) {
		
		Cliente cliente = new Cliente(dados);
		
		
		validadores.forEach(v -> {
			try {
				v.processar(cliente);
			} catch (ValidacaoExcepetion e) {
				e.printStackTrace();
			}
		});
		
		daoCliente.salvar(cliente);
		
		Log log = new Log(cliente.getId()); 
		daoLog.save(log);
		
		return new DetalharCliente(cliente);
	}
}