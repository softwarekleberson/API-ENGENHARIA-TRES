package br.com.engenharia.projeto.ProjetoFinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

import br.com.engenharia.projeto.ProjetoFinal.dao.CartaoDao;
import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosAtualizacaoCartao;
import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosCadastroCartao;
import br.com.engenharia.projeto.ProjetoFinal.dtos.DadosDetalhamentoCartao;
import br.com.engenharia.projeto.ProjetoFinal.persistencia.CartaoRepository;
import br.com.engenharia.projeto.ProjetoFinal.services.ServiceCartao;
import jakarta.validation.Valid;

@RestController
@RequestMapping("cartoes")
public class CartaoController {

	@Autowired
	private ServiceCartao service;
	
	@Autowired
	private CartaoRepository repository;
	
	
	@PostMapping
	public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroCartao dados, UriComponentsBuilder uriBuilder) {
		var dto = service.criar(dados);
	    var uri = uriBuilder.path("/cartao/{id}").buildAndExpand(dto.id()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping
	public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoCartao dados) {
		DadosDetalhamentoCartao detalhamentoCartao = service.atualizar(dados);
        return ResponseEntity.ok(detalhamentoCartao);
	}
	
	@GetMapping("{clienteId}")
	public ResponseEntity<Page<DadosDetalhamentoCartao>> listarPorCliente(@PathVariable Long clienteId, Pageable pageable){
		Page<DadosDetalhamentoCartao> cartoes = new CartaoDao(repository).listarCartaosDoCliente(clienteId, pageable);
		return ResponseEntity.ok(cartoes);
    }
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar (@PathVariable Long id) {
		new CartaoDao(repository).deletar(id);
		return ResponseEntity.noContent().build();
	}	
}