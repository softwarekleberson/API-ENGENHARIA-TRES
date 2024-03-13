package br.com.engenharia.projeto.ProjetoFinal.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.engenharia.projeto.ProjetoFinal.dao.ClienteDao;
import br.com.engenharia.projeto.ProjetoFinal.dao.CobrancaDao;
import br.com.engenharia.projeto.ProjetoFinal.dao.EntregaDao;
import br.com.engenharia.projeto.ProjetoFinal.dao.LogDao;
import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosAtualizacaoCliente;
import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosAtualizacaoSenha;
import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosDetalhamentoCliente;
import br.com.engenharia.projeto.ProjetoFinal.entidade.Cliente;
import br.com.engenharia.projeto.ProjetoFinal.entidade.Log;
import br.com.engenharia.projeto.ProjetoFinal.negocio.cliente.implementacao.criptografiaSenha.IStrategyCriptografaSenha;
import br.com.engenharia.projeto.ProjetoFinal.negocio.cliente.senha.implementacao.put.IStrategyUpdateSenha;
import br.com.engenharia.projeto.ProjetoFinal.persistencia.ClienteRepository;
import jakarta.validation.Valid;

@Service
public class ServiceClienteUpdate {
	
	@Autowired
	private ClienteRepository clienteRepositoy;
	
    @Autowired
    private ClienteDao daoCliente;
    
    @Autowired
    private CobrancaDao cobrancaDao;
    
    @Autowired
    private EntregaDao entregaDao;

    @Autowired
    private LogDao daoLog;
    
    @Autowired
    private List<IStrategyUpdateSenha> validadores;
    
    @Autowired
    private List<IStrategyCriptografaSenha> validaoresCriptografiaSenha;

	public DadosDetalhamentoCliente atualizarCliente(@Valid DadosAtualizacaoCliente dados) {
		Optional<Cliente> cliente = clienteRepositoy.findById(dados.idCliente());
		if(cliente.isEmpty()) {
			throw new IllegalArgumentException("Id incorreto");
		}
		
		daoCliente.alterarCliente(cliente.get().getId(), dados); 
		Log log = new Log(dados.idCliente());
		daoLog.save(log);
		
		return null;
	}
	
	public DadosDetalhamentoCliente atualizarSenha(@Valid DadosAtualizacaoSenha dados) {
		Optional<Cliente> cliente = clienteRepositoy.findById(dados.idCliente());
		if(cliente.isEmpty()) {
			throw new IllegalArgumentException("Id incorreto");
		}
		
		validadores.forEach(v-> v.processar(dados));
		validaoresCriptografiaSenha.forEach(v-> v.processar(cliente.get()));
		daoCliente.alterarSenha(dados.idCliente(), cliente.get().devolveSenhaCriptografada());
		
		Log log = new Log(dados.idCliente());
		daoLog.save(log);
		
		return null;
	}
}