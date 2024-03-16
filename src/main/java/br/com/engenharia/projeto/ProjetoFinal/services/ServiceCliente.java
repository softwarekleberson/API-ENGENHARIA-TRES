package br.com.engenharia.projeto.ProjetoFinal.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.engenharia.projeto.ProjetoFinal.dao.ClienteDao;
import br.com.engenharia.projeto.ProjetoFinal.dao.CobrancaDao;
import br.com.engenharia.projeto.ProjetoFinal.dao.EntregaDao;
import br.com.engenharia.projeto.ProjetoFinal.dao.LogDao;
import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosCadastroCliente;
import br.com.engenharia.projeto.ProjetoFinal.dtos.DetalharCliente;
import br.com.engenharia.projeto.ProjetoFinal.entidade.Cliente;
import br.com.engenharia.projeto.ProjetoFinal.entidade.Cobranca;
import br.com.engenharia.projeto.ProjetoFinal.entidade.Entrega;
import br.com.engenharia.projeto.ProjetoFinal.entidade.Log;
import br.com.engenharia.projeto.ProjetoFinal.negocio.cliente.implementacao.criptografiaSenha.IStrategyCriptografaSenha;
import br.com.engenharia.projeto.ProjetoFinal.negocio.cliente.implementacao.post.IStrategyCliente;
import jakarta.validation.Valid;

@Service
public class ServiceCliente {
	
    @Autowired
    private ClienteDao daoCliente;

    @Autowired
    private EntregaDao daoEntrega;

    @Autowired
    private CobrancaDao daoCobranca;
    
    @Autowired
    private LogDao daoLog;

    @Autowired
    private List<IStrategyCliente> validadores;

    @Autowired
    private List<IStrategyCriptografaSenha> criptografiaSenha;

    public DetalharCliente criar(@Valid DadosCadastroCliente dados) {
        
    	Cliente cliente = new Cliente(dados);
        validadores.forEach(v -> v.processar(cliente));
        criptografiaSenha.forEach(v -> v.processar(cliente));
        daoCliente.salvar(cliente);

        List<Cobranca> cobrancas = criarCobrancas(dados, cliente);
        List<Entrega> entregas = criarEntregas(dados, cliente);
        atribuirIdCliente(cobrancas, entregas, cliente.getId());

        salvarCobrancas(cobrancas);
        salvarEntregas(entregas);
        
        Log log = new Log(cliente.getId());
        daoLog.save(log);
        
        return new DetalharCliente(cliente);
    }

    private List<Cobranca> criarCobrancas(DadosCadastroCliente dados, Cliente cliente) {        
    	return dados.cobranca().stream()
                .map(Cobranca::new)
                .collect(Collectors.toList());        
    }

    private List<Entrega> criarEntregas(DadosCadastroCliente dados, Cliente cliente) {
        return dados.entrega().stream()
                .map(Entrega::new)
                .collect(Collectors.toList());
    }

    private void atribuirIdCliente(List<Cobranca> cobrancas, List<Entrega> entregas, Long clienteId) {
    	cobrancas.forEach(c -> c.setCliente(clienteId));
        entregas.forEach(e -> e.setClinte(clienteId));
    }

    private void salvarCobrancas(List<Cobranca> cobrancas) {
    	cobrancas.forEach(daoCobranca::salvar);
    }

    private void salvarEntregas(List<Entrega> entregas) {
    	entregas.forEach(daoEntrega::salvar);
    }
}