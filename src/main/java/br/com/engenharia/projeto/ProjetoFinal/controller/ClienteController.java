package br.com.engenharia.projeto.ProjetoFinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.engenharia.projeto.ProjetoFinal.dao.ClienteDao;
import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosAtualizacaoCliente;
import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosAtualizacaoSenha;
import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosCadastroCliente;
import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosDetalhamentoCliente;
import br.com.engenharia.projeto.ProjetoFinal.entidade.Cliente;
import br.com.engenharia.projeto.ProjetoFinal.persistencia.CartaoRepository;
import br.com.engenharia.projeto.ProjetoFinal.persistencia.ClienteRepository;
import br.com.engenharia.projeto.ProjetoFinal.persistencia.CobrancaRepository;
import br.com.engenharia.projeto.ProjetoFinal.persistencia.EntregaRepository;
import br.com.engenharia.projeto.ProjetoFinal.services.ServiceCliente;
import br.com.engenharia.projeto.ProjetoFinal.services.ServiceClienteUpdate;
import jakarta.validation.Valid;

@RestController
@RequestMapping("cliente")
public class ClienteController {

	@Autowired
	private ServiceCliente service;
	
	@Autowired
	private ServiceClienteUpdate serviceClienteUpdate;
	
	@Autowired
	private ClienteRepository Clienterepository;
	
	@Autowired
	private CartaoRepository cartaoRepository;
	
	@Autowired
	private CobrancaRepository cobrancaRepository;
	
	@Autowired
	private EntregaRepository entregaRepository;
		
	
	@PostMapping
	public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroCliente dados, UriComponentsBuilder uriBuilder) {
		var dto = service.criar(dados);
	    var uri = uriBuilder.path("/cliente/{id}").buildAndExpand(dto.id()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@GetMapping
	public ResponseEntity<Page<Cliente>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
		var page = new ClienteDao(Clienterepository).pegaTodosClientes(paginacao);
		return ResponseEntity.ok(page);
	}
	
	@PutMapping
	public  ResponseEntity atualizarCliente(@RequestBody @Valid DadosAtualizacaoCliente dados) {
		DadosDetalhamentoCliente updateCliente = serviceClienteUpdate.atualizarCliente(dados);
		return ResponseEntity.ok(updateCliente);
	}
	
	@PutMapping("/senha")
	public  ResponseEntity atualizarSenha(@RequestBody @Valid DadosAtualizacaoSenha dados) {
		DadosDetalhamentoCliente detalharCliente = serviceClienteUpdate.atualizarSenha(dados);
		return ResponseEntity.ok(detalharCliente);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar (@PathVariable Long id) {
		new ClienteDao(Clienterepository, cartaoRepository, cobrancaRepository, entregaRepository).deletar(id);
		return ResponseEntity.noContent().build();
	}	
}