package br.com.engenharia.projeto.ProjetoFinal.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.engenharia.projeto.ProjetoFinal.controle.FachadaCliente;
import br.com.engenharia.projeto.ProjetoFinal.dao.LogDao;
import br.com.engenharia.projeto.ProjetoFinal.dominio.Cliente;
import br.com.engenharia.projeto.ProjetoFinal.dominio.Log;
import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosAtualizacaoCliente;
import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosCadastroCliente;
import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosDetalhamentoCliente;
import br.com.engenharia.projeto.ProjetoFinal.persistencia.ClienteRepository;
import br.com.engenharia.projeto.ProjetoFinal.persistencia.LogRepository;
import jakarta.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

import jakarta.validation.Valid;

@RestController
@RequestMapping("clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	LogRepository logRepository;

	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastroCliente dados) {
		var cliente = new Cliente(dados);
		new FachadaCliente(repository).salvar(cliente);
		
		var log = new Log(cliente.getId(), LocalDateTime.now());
		new LogDao(logRepository).sava(log);
	}

	@PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoCliente dados) {
        var cliente = repository.getReferenceById(dados.idCliente());
        new FachadaCliente(repository).alterar(cliente, dados);
        
        var log = new Log(dados.idCliente(), LocalDateTime.now());
        new LogDao(logRepository).sava(log);
    }
	
	@GetMapping
	public Page<DadosDetalhamentoCliente> listar(@PageableDefault(size = 10, sort = { "nome" }) Pageable paginacao) {
		return repository.findAllByAtivoTrue(paginacao).map(DadosDetalhamentoCliente::new);
	}
	
	@DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        var cliente = repository.getReferenceById(id);
        new FachadaCliente(repository).excluir(cliente);
    }
}
