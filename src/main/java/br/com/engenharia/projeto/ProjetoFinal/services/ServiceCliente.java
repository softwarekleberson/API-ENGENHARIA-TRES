package br.com.engenharia.projeto.ProjetoFinal.services;

import java.util.List;
import java.util.Set;
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
import br.com.engenharia.projeto.ProjetoFinal.negocio.cliente.implementacao.IStrategyCliente;
import br.com.engenharia.projeto.ProjetoFinal.negocio.cliente.implementacao.IStrategyCriptografaSenha;
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
    private List<IStrategyCriptografaSenha> criptografaSenha;

    public DetalharCliente criar(@Valid DadosCadastroCliente dados) {
        
    	Cliente cliente = new Cliente(dados);
        validadores.forEach(v -> v.processar(cliente));
        criptografaSenha.forEach(v -> v.processar(cliente));
        daoCliente.salvar(cliente);

        Set<Cobranca> cobrancas = criarCobrancas(dados, cliente);
        Set<Entrega> entregas = criarEntregas(dados, cliente);
        atribuirIdCliente(cobrancas, entregas, cliente.getId());

        salvarCobrancas(cobrancas);
        salvarEntregas(entregas);
        
        Log log = new Log(cliente.getId());
        daoLog.save(log);
        
        return new DetalharCliente(cliente);
    }

    private Set<Cobranca> criarCobrancas(DadosCadastroCliente dados, Cliente cliente) {
        return dados.cobranca().stream()
                .map(Cobranca::new)
                .collect(Collectors.toSet());
    }

    private Set<Entrega> criarEntregas(DadosCadastroCliente dados, Cliente cliente) {
        return dados.entrega().stream()
                .map(Entrega::new)
                .collect(Collectors.toSet());
    }

    private void atribuirIdCliente(Set<Cobranca> cobrancas, Set<Entrega> entregas, Long clienteId) {
        cobrancas.forEach(c -> c.setClinte(clienteId));
        entregas.forEach(e -> e.setClinte(clienteId));
    }

    private void salvarCobrancas(Set<Cobranca> cobrancas) {
        cobrancas.forEach(daoCobranca::salvar);
    }

    private void salvarEntregas(Set<Entrega> entregas) {
        entregas.forEach(daoEntrega::salvar);
    }
}